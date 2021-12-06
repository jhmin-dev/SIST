---
title: "MiniProject"
---

# 영화 예매 프로그램

## 테이블

### 회원 정보 `m_member`

- 회원 번호 `me_num`
- 아이디 `me_id`
- 비밀번호 `me_passwd`
- 이름 `me_name`
- 생년월일 `me_birthdate`
- 연락처 `me_phone`

### 영화 정보 `m_movie`

- 영화 번호 `mo_num`
- 영화 제목`mo_title`
- 상영 날짜 및 시간 `mo_date`
- 남은 좌석 `mo_seats`

### 예매 정보 `m_reservation`

- 예매 번호 `re_num`
- 회원 번호 `me_num`
- 영화 번호 `mo_num`

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

1. 회원 가입 `insertUser()`
2. 로그인 `loginCheck()`

#### 두 번째 while

1. 예매하기 `reserve()`
2. 예매 정보 보기 `reservationCheck()`

### 영화 페이지

1. 영화 등록 `insertMovie()`
2. 영화 목록 확인 `selectListMovie()`
3. 영화 수정 `updateMovie()`
4. 영화 삭제 `deleteMovie()`

### (추가)

- 나이 제한
- 개봉 기간