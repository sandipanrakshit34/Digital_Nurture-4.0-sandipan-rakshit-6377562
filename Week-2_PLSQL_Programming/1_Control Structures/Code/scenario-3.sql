SET SERVEROUTPUT ON
BEGIN
    FOR loan IN (
        SELECT l.loanid, c.name, l.enddate
        FROM loans l
        JOIN customers c ON l.customerid = c.customerid
        WHERE l.enddate <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan.name || 
                             ', your loan with ID: ' || loan.loanid || 
                             ' is due on ' || TO_CHAR(loan.enddate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/

