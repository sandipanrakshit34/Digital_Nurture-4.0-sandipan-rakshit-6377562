SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    from_account_id IN NUMBER,
    to_account_id IN NUMBER,
    amount IN NUMBER
)
IS
    v_balance NUMBER;
    from_cust_id NUMBER;
    to_cust_id NUMBER;
BEGIN
    -- Check if source account has enough balance
    SELECT balance,customerid INTO v_balance,from_cust_id FROM accounts WHERE accountid = from_account_id;
    SELECT customerid INTO to_cust_id FROM accounts WHERE accountid = to_account_id;

    IF v_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source
    UPDATE accounts
    SET balance = balance - amount
    WHERE accountid = from_account_id;
    
    UPDATE customers
    SET balance = balance - amount
    WHERE customerid = from_cust_id;

    -- Add to destination
    UPDATE accounts
    SET balance = balance + amount
    WHERE accountid = to_account_id;
    
    UPDATE customers
    SET balance = balance + amount
    WHERE customerid = to_cust_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END;
/


DECLARE
	from_acc_id NUMBER;
	to_acc_id NUMBER;
	amount NUMBER;
BEGIN
	from_acc_id:=&sender_acc_id;
	to_acc_id:=&to_acc_id;
	amount:=&amount;
	
	SafeTransferFunds(from_acc_id,to_acc_id,amount);
END;
/
