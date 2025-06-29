SET SERVEROUTPUT ON;
DECLARE
	var_cust_id NUMBER;
	var_cust_age NUMBER;
BEGIN
    FOR cust IN (
        SELECT c.customerId, TRUNC(MONTHS_BETWEEN(SYSDATE, c.dob)/12) AS age
        FROM customers c
    ) LOOP
    	var_cust_id:=cust.customerID;
    	var_cust_age:=cust.age;
    	
        IF var_cust_age > 60 THEN
            UPDATE loans
            SET interestRate = interestRate - 1
            WHERE customerId = var_cust_id;
            DBMS_OUTPUT.PUT_LINE('Customer id: ' || var_cust_id || ' ,age: ' || var_cust_age);
            DBMS_OUTPUT.PUT_LINE('Status: Discount applied');
         ELSE
            DBMS_OUTPUT.PUT_LINE('Customer id: ' || var_cust_id || ' ,age: ' || var_cust_age);
            DBMS_OUTPUT.PUT_LINE('Status: No discount applied');
        END IF;
    END LOOP; 
END;
/

