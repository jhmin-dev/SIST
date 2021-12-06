CREATE TABLE member(
	me_num NUMBER PRIMARY KEY,
	me_id VARCHAR2(10) UNIQUE NOT NULL,
	me_passwd VARCHAR2(10) NOT NULL,
	me_name VARCHAR2(30) NOT NULL,
	me_phone VARCHAR2(13) NOT NULL,
	me_regdate DATE DEFAULT SYSDATE NOT NULL
);
CREATE SEQUENCE member_seq;

CREATE TABLE book(
	bk_num NUMBER PRIMARY KEY,
	bk_name VARCHAR2(90) NOT NULL,
	bk_category VARCHAR2(30) NOT NULL,
	bk_regdate DATE DEFAULT SYSDATE NOT NULL
);
CREATE SEQUENCE book_seq;

CREATE TABLE reservation(
	re_num NUMBER PRIMARY KEY,
	re_status NUMBER(1) NOT NULL, /* 0. 미대출/반납, 1. 대출 중 */
	bk_num NUMBER NOT NULL REFERENCES book (bk_num), /* 도서 번호 */
	me_num NUMBER NOT NULL REFERENCES member (me_num), /* 회원 번호 */
	re_regdate DATE DEFAULT SYSDATE NOT NULL, /* 대출일 */
	re_modifydate DATE /* 반납일 */
);
CREATE SEQUENCE reservation_seq;