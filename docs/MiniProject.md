---
title: "MiniProject"
---

# 영화 예매 프로그램

## 테이블

### m_member

- me_num
- me_id
- me_passwd
- me_name
- me_birthdate
- me_phone

### m_movie

- mo_num
- mo_title
- mo_date
- mo_seats

### m_reservation

- re_num
- me_num
- mo_num

### `table.sql`

```sql
CREATE TABLE m_member(
	me_num NUMBER PRIMARY KEY,
	me_id VARCHAR2(15) UNIQUE NOT NULL,
	me_passwd VARCHAR2(30) NOT NULL,
	me_name VARCHAR2(30) NOT NULL,
	me_birthdate DATE NOT NULL,
	me_phone VARCHAR2(13) NOT NULL
);
CREATE SEQUENCE m_member_seq;

CREATE TABLE m_movie(
	mo_num NUMBER PRIMARY KEY,
	mo_title VARCHAR2(90) NOT NULL,
	mo_date DATE NOT NULL,
	mo_seats NUMBER DEFAULT(5) NOT NULL
);
CREATE SEQUENCE m_movie_seq;

CREATE TABLE m_reservation(
	re_num NUMBER PRIMARY KEY,
	me_num NUMBER NOT NULL REFERENCES m_member (me_num),
	mo_num NUMBER NOT NULL REFERENCES m_movie (mo_num)
);
CREATE SEQUENCE m_reservation_seq;
```

## 기능

### 사용자 페이지

#### 첫 번째 while

1. insertUser
2. loginCheck

#### 두 번째 while

1. reserve
2. reservationCheck

### 영화 페이지

1. insertMovie
2. selectListMovie
3. updateMovie
4. deleteMovie

### 추가

- 나이 제한
- 개봉 기간