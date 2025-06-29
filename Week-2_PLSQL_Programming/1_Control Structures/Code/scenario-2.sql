ALTER TABLE customers ADD ISVIP CHAR(10) DEFAULT 'FALSE' CHECK(ISVIP IN ('TRUE','FALSE'));

SET SERVEROUTPUT ON
BEGIN
    FOR cust IN (SELECT customerId, balance FROM customers) LOOP
        IF cust.balance > 10000 THEN
            UPDATE customers
            SET isvip = 'TRUE'
            WHERE customerId = cust.customerId;
            DBMS_OUTPUT.PUT_LINE('Customer with id = '|| cust.customerId ||' marked as VIP');
         ELSE
         	DBMS_OUTPUT.PUT_LINE('For customer id = '|| cust.customerId ||',balance is less than 10,000');
        END IF;
    END LOOP;
END;
/

