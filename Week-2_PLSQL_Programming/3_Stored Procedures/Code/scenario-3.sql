DROP SEQUENCE Transactions_seq;
CREATE SEQUENCE Transactions_seq 
START WITH 3
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account_id IN NUMBER,
    to_account_id   IN NUMBER,
    transfer_amount IN NUMBER
) IS
    insufficient_balance EXCEPTION;
    v_balance NUMBER;
    source_cust_id NUMBER;
    dest_cust_id NUMBER;
BEGIN
   
    SELECT Balance,customerID INTO v_balance,source_cust_id
    FROM Accounts
    WHERE AccountID = from_account_id
    FOR UPDATE;
    
    SELECT customerID INTO dest_cust_id
    FROM Accounts
    WHERE AccountID = to_account_id
    FOR UPDATE;

    -- Checking for sufficient balance
    IF v_balance < transfer_amount THEN
        RAISE insufficient_balance;
    END IF;

    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - transfer_amount,
        LastModified = SYSDATE
    WHERE AccountID = from_account_id;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + transfer_amount,
        LastModified = SYSDATE
    WHERE AccountID = to_account_id;
    
    -- Update source-customers balance
    UPDATE Customers
    SET Balance = Balance - transfer_amount,
        LastModified = SYSDATE
    WHERE customerID = source_cust_id;
    
    -- Update destination-customers balance
    UPDATE Customers
    SET Balance = Balance + transfer_amount,
        LastModified = SYSDATE
    WHERE customerID = dest_cust_id;

    -- Add transactions
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, from_account_id, SYSDATE, transfer_amount, 'Withdrawal');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, to_account_id, SYSDATE, transfer_amount, 'Credit');
    
    DBMS_OUTPUT.PUT_LINE('Transfered Rs.'|| transfer_amount || ' to account with id '|| to_account_id || ' from account  id ' || from_account_id || ' successfully!');
    DBMS_OUTPUT.PUT_LINE('Current balance of account with id '|| from_account_id || ' is: '|| (v_balance-transfer_amount));

    COMMIT;

EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END;
/

DECLARE
	source_acc_id NUMBER;
	destination_acc_id NUMBER;
	amount NUMBER;
BEGIN
	source_acc_id:=&source_acc_id;
	destination_acc_id:=&destination_acc_id;
	amount:=&amount;
	
	TransferFunds(source_acc_id,destination_acc_id,amount);
END;
/