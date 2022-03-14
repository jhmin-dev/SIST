/* 회원 관리 */
CREATE TABLE spmember(
	mem_num NUMBER NOT NULL,
	id VARCHAR2(12) UNIQUE NOT NULL,
	auth NUMBER(1) DEFAULT 2 NOT NULL, /* 0=탈퇴, 1=정지, 2=일반, 3=관리자 */
	CONSTRAINT spmember_pk PRIMARY KEY (mem_num)
);

CREATE TABLE spmember_detail(
	mem_num NUMBER NOT NULL,
	name VARCHAR2(30) NOT NULL,
	passwd VARCHAR2(35) NOT NULL,
	phone VARCHAR2(15) NOT NULL,
	email VARCHAR2(50) NOT NULL,
	zipcode VARCHAR2(5) NOT NULL,
	address1 VARCHAR2(90) NOT NULL,
	address2 VARCHAR2(90) NOT NULL,
	photo BLOB,
	photo_name VARCHAR2(100),
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	CONSTRAINT spmember_detail_pk PRIMARY KEY (mem_num),
	CONSTRAINT spmember_detail_fk FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);

CREATE SEQUENCE spmember_seq;

/* 게시판 */
CREATE TABLE spboard(
	board_num NUMBER NOT NULL,
	title VARCHAR2(100) NOT NULL,
	content CLOB not null,
	hit NUMBER(5) DEFAULT 0 NOT NULL,
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	uploadfile BLOB,
	filename VARCHAR2(100),
	ip VARCHAR2(40) NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT spboard_pk PRIMARY KEY (board_num),
	CONSTRAINT spboard_spmember_fk FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);

CREATE SEQUENCE spboard_seq;

/* 댓글 */
CREATE TABLE spboard_reply(
	re_num NUMBER NOT NULL,
	re_content VARCHAR2(900) NOT NULL,
	re_date DATE DEFAULT SYSDATE NOT NULL,
	re_mdate DATE,
	re_ip VARCHAR2(40) NOT NULL,
	board_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT spboard_reply_pk PRIMARY KEY (re_num),
	CONSTRAINT reply_spboard_fk1 FOREIGN KEY (board_num) REFERENCES spboard (board_num),
	CONSTRAINT reply_spmember_fk2 FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);

CREATE SEQUENCE spreply_seq;