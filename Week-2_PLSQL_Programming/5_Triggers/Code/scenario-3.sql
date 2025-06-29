SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER CHECKTRANSACTIONRULES
BEFORE INSERT ON TRANSACTIONS
FOR EACH ROW
DECLARE
    V_BALANCE ACCOUNTS.BALANCE%TYPE;
BEGIN
    -- Get the current balance of the account
    SELECT BALANCE INTO V_BALANCE
    FROM ACCOUNTS
    WHERE ACCOUNTID = :NEW.ACCOUNTID
    FOR UPDATE;

    -- Check the transaction type and validate accordingly
    IF :NEW.TRANSACTIONTYPE = 'Withdrawal' THEN
        IF :NEW.AMOUNT > V_BALANCE THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for the withdrawal.');
        END IF;
    ELSIF :NEW.TRANSACTIONTYPE = 'Deposit' THEN
        IF :NEW.AMOUNT <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    ELSE
        RAISE_APPLICATION_ERROR(-20003, 'Invalid transaction type.');
    END IF;
END CHECKTRANSACTIONRULES;
/
