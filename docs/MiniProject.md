---
title: "MiniProject"
hidetitle: "true"
---

# 영화 예매 프로그램

## 테이블

### 회원 정보 `m_member`

- 회원 번호 `me_num`
- 아이디 `me_id`
- 비밀번호 `me_passwd`
- 이름 `me_name`
- 나이 `me_age`
- 연락처 `me_phone`

### 영화 정보 `m_movie`

- 영화 번호 `mo_num`
- 영화 제목 `mo_title`
- 상영 날짜 `mo_date`
- 상영 시간 `mo_time`
- 남은 좌석 `mo_seats`
- 관람 가능 연령 `mo_ban`

### 예매 정보 `m_reservation`

- 예매 번호 `re_num`
- 회원 번호 `me_num`
- 영화 번호 `mo_num`
- 예매한 좌석 수 `re_seats`

### `table.sql`

```sql
CREATE TABLE m_member(
	me_num NUMBER PRIMARY KEY,
	me_id VARCHAR2(30) UNIQUE NOT NULL,
	me_passwd VARCHAR2(30) NOT NULL,
	me_name VARCHAR2(30) NOT NULL,
	me_age NUMBER NOT NULL,
	me_phone VARCHAR2(13)
);
CREATE SEQUENCE m_member_seq;

CREATE TABLE m_movie(
	mo_num NUMBER PRIMARY KEY,
	mo_title VARCHAR2(90) NOT NULL,
	mo_date VARCHAR2(10) NOT NULL,
	mo_time VARCHAR2(8) NOT NULL,
	mo_ban NUMBER DEFAULT(0) NOT NULL,
	mo_seats NUMBER DEFAULT(5) NOT NULL
);
CREATE SEQUENCE m_movie_seq;

CREATE TABLE m_reservation(
	re_num NUMBER PRIMARY KEY,
	me_num NUMBER NOT NULL REFERENCES m_member (me_num),
	mo_num NUMBER NOT NULL REFERENCES m_movie (mo_num),
	re_seats NUMBER NOT NULL
);
CREATE SEQUENCE m_reservation_seq;

-- 초기화
-- DROP TABLE m_reservation;
-- DROP TABLE m_movie;
-- DROP TABLE m_member;
-- DROP SEQUENCE m_reservation_seq;
-- DROP SEQUENCE m_movie_seq;
-- DROP SEQUENCE m_member_seq;
```

## 기능

### 사용자 페이지

#### 첫 번째 while

1. 로그인 `loginCheck()`
2. 회원 가입 `insertUser()`
	- 아이디 중복 체크 `checkID()`
	- (아이디, 이름, 비밀번호 길이 제한 및 특수문자 제한 검사)
	- 생년월일을 입력받고 Java에서 나이 계산 `getAge()`
3. 종료

#### 두 번째 while

1. 예매하기 `reserve()` -> insertReservation()
	- 나이 제한 확인 `checkAge()`
	- 좌석 수 체크 `checkSeats()`
2. 예매 정보 보기 `reservationCheck()`
	- 영화 제목, 날짜, 시간, 예매한 좌석 수
3. 예매 취소하기 `cancelReservation()`
4. 종료

### 영화 페이지

1. 영화 등록 `insertMovie()`
2. 영화 목록 확인 `selectListMovie()`
	- 상세 정보(영화별 예매 내역 확인)
3. 영화 수정 `updateMovie()`
4. 영화 삭제 `deleteMovie()`
	- 영화 존재 여부 확인 `checkMovie()`
5. 전체 예매 내역 확인 `reservationCheck()`