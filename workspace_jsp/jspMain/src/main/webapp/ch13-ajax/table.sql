CREATE TABLE people(
	id VARCHAR2(10) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	job VARCHAR2(30) NOT NULL,
	address VARCHAR2(60) NOT NULL,
	blood_type VARCHAR2(2) NOT NULL
);

INSERT INTO people VALUES ('test', '실험', '학생', '서울시', 'A'); -- 중복 체크용 초기 데이터
COMMIT;