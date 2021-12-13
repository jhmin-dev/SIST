-- 테이블 및 시퀀스 생성
CREATE TABLE my_member (
	me_num NUMBER PRIMARY KEY,
	me_id VARCHAR2(20) UNIQUE NOT NULL,
	me_pw VARCHAR2(30) NOT NULL,
	me_name VARCHAR2(4000) NOT NULL,
	me_birthdate DATE,
	me_regdate DATE DEFAULT SYSDATE NOT NULL,
	-- me_mobile VARCHAR2(11),
	-- me_email VARCHAR2(4000),
	me_access VARCHAR2(4000) DEFAULT 'USER' NOT NULL
);
CREATE SEQUENCE my_member_seq;

CREATE TABLE my_movie(
	mo_num NUMBER PRIMARY KEY,
	mo_title VARCHAR2(4000) NOT NULL,
	mo_ban NUMBER(2) DEFAULT(0) NOT NULL
	-- , mo_pd VARCHAR2(4000),
	-- mo_cast VARCHAR2(4000)
);
CREATE SEQUENCE my_movie_seq;

CREATE TABLE my_theater(
	th_num NUMBER(2) NOT NULL,
	th_date DATE NOT NULL,
	mo_num REFERENCES my_movie (mo_num),
	th_seats_total NUMBER  NOT NULL,
	th_seats NUMBER NOT NULL,
	CONSTRAINT my_timetable_pk PRIMARY KEY (th_num, th_date)
);

CREATE TABLE my_reservation(
	re_num NUMBER PRIMARY KEY,
	me_num NUMBER NOT NULL REFERENCES m_member (me_num),
	mo_num NUMBER NOT NULL REFERENCES m_movie (mo_num),
	th_num NUMBER NOT NULL,
	th_date DATE NOT NULL,
	re_seats NUMBER NOT NULL,
	CONSTRAINT my_reservation_fk FOREIGN KEY (th_num, th_date) REFERENCES my_theater (th_num, th_date)
);
CREATE SEQUENCE my_reservation_seq;

-- 뷰 생성
CREATE OR REPLACE VIEW my_timetable
AS SELECT mo_num, mo_title, mo_ban, th_date, th_seats, th_seats_total, th_num FROM my_movie JOIN my_theater USING(mo_num)
WITH READ ONLY;

-- 테이블, 시퀀스, 뷰 삭제
DROP VIEW my_timetable;
DROP TABLE my_reservation;
DROP TABLE my_theater;
DROP TABLE my_movie;
DROP TABLE my_member;
DROP SEQUENCE my_reservation_seq;
DROP SEQUENCE my_movie_seq;
DROP SEQUENCE my_member_seq;