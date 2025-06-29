SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_new_balance NUMBER;
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance, customerID
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        v_new_balance := acc.Balance + (acc.Balance * 0.01);
        
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || acc.AccountID);
        DBMS_OUTPUT.PUT_LINE('Old Balance: ' || acc.Balance);
        DBMS_OUTPUT.PUT_LINE('New Balance: ' || v_new_balance);

        UPDATE Accounts
        SET balance = v_new_balance,
            lastModified = SYSDATE
        WHERE accountID = acc.accountID;
        
        UPDATE Customers
        SET balance = v_new_balance,
        	lastmodified = SYSDATE
        WHERE customerID = acc.customerID;
    END LOOP;
    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/