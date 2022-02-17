/* 회원 관리 */
CREATE TABLE zmember(
	mem_num NUMBER NOT NULL,
	id VARCHAR2(12) UNIQUE NOT NULL, /* 탈퇴하더라도 아이디를 보존하여 재가입을 방지 */
	auth NUMBER(1) DEFAULT 2 NOT NULL, /* 회원 등급; 0: 탈퇴, 1: 정지, 2: 일반, 3: 관리자 */
	CONSTRAINT zmember_pk PRIMARY KEY (mem_num)
);

CREATE TABLE zmember_detail( /* 개인 정보를 별도의 테이블로 분리하여 탈퇴시에 개인 정보만 삭제 */
	mem_num NUMBER NOT NULL,
	name VARCHAR2(30) NOT NULL,
	passwd VARCHAR2(12) NOT NULL,
	phone VARCHAR2(15) NOT NULL,
	email VARCHAR2(50) NOT NULL,
	zipcode VARCHAR2(5)  NOT NULL,
	address1 VARCHAR2(90) NOT NULL,
	address2 VARCHAR2(90) NOT NULL,
	photo VARCHAR2(150), /* 프로필 사진 파일명 */
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	CONSTRAINT zmember_detail_pk PRIMARY KEY (mem_num),
	CONSTRAINT zmember_detail_fk FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zmember_seq;

/* 게시판 */
CREATE TABLE zboard(
	board_num NUMBER NOT NULL,
	title VARCHAR2(150) NOT NULL,
	content CLOB NOT NULL,
	hit NUMBER(5) DEFAULT 0 NOT NULL, /* 조회수는 최대 십만 단위까지 */
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	filename VARCHAR2(150),
	ip VARCHAR2(40) NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zboard_pk PRIMARY KEY (board_num),
	CONSTRAINT zboard_fk FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zboard_seq;

/* 댓글 */
CREATE TABLE zboard_reply(
	re_num NUMBER NOT NULL,
	re_content VARCHAR2(900) NOT NULL,
	re_date DATE DEFAULT SYSDATE NOT NULL,
	re_modifydate DATE,
	re_ip VARCHAR2(40)  NOT NULL,
	board_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zreply_pk PRIMARY KEY (re_num),
	CONSTRAINT zreply_fk1 FOREIGN KEY (board_num) REFERENCES zboard (board_num),
	CONSTRAINT zreply_fk2 FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zreply_seq;

/* 상품 관리 */
CREATE TABLE zitem(
	item_num NUMBER NOT NULL,
	name VARCHAR2(30) NOT NULL,
	price NUMBER(8) NOT NULL,
	quantity NUMBER(5) NOT NULL,
	photo1 VARCHAR2(60) NOT NULL,
	photo2 VARCHAR2(60) NOT NULL,
	detail CLOB NOT NULL,
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	status NUMBER(1) NOT NULL,
	CONSTRAINT zitem_pk PRIMARY KEY(item_num)
);

CREATE SEQUENCE zitem_seq;

/* 장바구니 */
CREATE TABLE zcart(
	cart_num NUMBER,
	item_num NUMBER NOT NULL,
	order_quantity NUMBER(7) NOT NULL,
	reg_date DATE NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zcart_pk PRIMARY KEY (cart_num),
	CONSTRAINT zcart_fk1 FOREIGN KEY (item_num) REFERENCES zitem (item_num),
	CONSTRAINT zcart_fk2 FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zcart_seq;

/* 주문 */
CREATE TABLE zorder(
	order_num NUMBER NOT NULL,
	item_name VARCHAR2(600) NOT NULL,
	order_total NUMBER(9) NOT NULL,
	payment NUMBER(1) NOT NULL,
	status NUMBER(1) DEFAULT 1 NOT NULL,
	receive_name VARCHAR2(30) NOT NULL,
	receive_post VARCHAR2(5) NOT NULL,
	receive_address1 VARCHAR2(90) NOT NULL,
	receive_address2 VARCHAR2(90) NOT NULL,
	receive_phone VARCHAR2(15) NOT NULL,
	notice VARCHAR2(4000),
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zorder_pk PRIMARY KEY (order_num),
	CONSTRAINT zorder_fk1 FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zorder_seq;

CREATE TABLE zorder_detail(
	detail_num NUMBER NOT NULL,
	item_num NUMBER NOT NULL,
	item_name VARCHAR2(30) NOT NULL,
	item_price NUMBER(8) NOT NULL,
	item_total NUMBER(8) NOT NULL,
	order_quantity NUMBER(7) NOT NULL,
	order_num NUMBER NOT NULL,
	CONSTRAINT zdetail_pk PRIMARY KEY (detail_num),
	CONSTRAINT zdetail_fk1 FOREIGN KEY (order_num) REFERENCES zorder (order_num)
);

CREATE SEQUENCE zdetail_seq;