CREATE TABLE salary(
	name VARCHAR2(30) PRIMARY KEY,
	pay NUMBER
);

INSERT INTO salary VALUES('TEST', 1000);
INSERT INTO salary VALUES('CALL', 2000);
INSERT INTO salary VALUES('PROCEDURE', 3000);
COMMIT;

CREATE OR REPLACE PROCEDURE adjust(name_i IN VARCHAR2, rate IN FLOAT)
AS
	newpay FLOAT;
BEGIN
	SELECT pay INTO newpay FROM salary WHERE name = name_i;
	newpay := newpay * (1 + rate);
	UPDATE salary SET pay=newpay WHERE name = name_i;
	COMMIT;
EXCEPTION WHEN OTHERS THEN
	DBMS_OUTPUT.PUT_LINE(name_i || ' 갱신 실패');
	ROLLBACK;
END;