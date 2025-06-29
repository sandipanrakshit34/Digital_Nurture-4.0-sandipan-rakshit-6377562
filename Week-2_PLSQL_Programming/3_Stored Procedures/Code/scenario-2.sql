CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) IS
	old_salary NUMBER;
	new_salary NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Updating salary of department: '|| dept_name || ' by '|| bonus_percent || '%');
    SELECT salary INTO old_salary FROM employees WHERE department = dept_name;
    new_salary:=old_salary + (old_salary * bonus_percent / 100);
    DBMS_OUTPUT.PUT_LINE('Old Salary= '|| old_salary);
    DBMS_OUTPUT.PUT_LINE('New Salary= '|| new_salary);
    UPDATE employees
    SET salary = new_salary
    WHERE department = dept_name;
    COMMIT;
END;
/

DECLARE
	dept VARCHAR2(50);
	bonus NUMBER;
BEGIN
	dept:='&department';
	bonus:=&bonus;
	UpdateEmployeeBonus(dept,bonus);
END;
/