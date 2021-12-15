# 영화 예매 프로그램

## 테이블

### 회원 정보 `my_member`

- 회원 번호 `me_num`
- 아이디 `me_id`
- 비밀번호 `me_pw`
- 이름 `me_name`
- 생년월일 `me_birthdate`
- 가입일 `me_regdate`
- (휴대전화번호 `me_mobile`)
- (이메일 `me_email`)
- 권한 `me_access`

### 영화 정보 `my_movie`

- 영화 번호 `mo_num`
- 제목 `mo_title`
- 관람가 `mo_ban`
	+ 0은 전체 관람가를 의미
- (감독 `mo_pd`)
- (주연 배우 `mo_cast`)

### 극장 정보 `my_theater`

- 상영관 번호 `th_num`
- 상영 날짜 및 시간 `th_date`
- 영화 번호 `mo_num`
- 총 좌석 수 `th_seats_total`
- 잔여 좌석 수 `th_seats`
- (좌석 열의 수 `th_cols`)
- (좌석 행의 수 `th_rows`)

### 예매 정보 `my_reservation`

- 예매 번호 `re_num`
- 회원 번호 `me_num`
- 영화 번호 `mo_num`
- 상영관 번호 `th_num`
- 상영 시간 및 날짜 `th_date`
- 예매한 좌석 수 `re_seats`
	+ 0은 예매 취소를 의미
	+ (연석으로만 예매 가능)
- (예매한 좌석 번호 `re_seats_num`)
	+ (연석의 첫 번째 좌석 번호)

## 뷰

### 상영 정보 `my_timetable`

- 영화 번호
- 영화 제목
- 관람가
- 상영 날짜 및 시간
- 총 좌석 수
- 잔여 좌석 수
- 상영관 번호

## 기능

### 사용자 페이지

#### 첫 번째 while

1. 로그인 `callGetLogin()`, `getLogin()`
2. 회원 가입 `callInsertMember()`, `insertMember()`
	- 아이디 중복 검사 `checkID`
	- 유효성 검사
		+ 길이 `validateLength()`
		+ 날짜 `validateDate()`
		+ (특수문자)
		+ (연락처)
9. 종료

#### 두 번째 while

1. 예매 `makeReservation`
	- 관람가 검사 `checkAge()`
	- 좌석 수 검사 `checkSeats()`
	- (달력 출력)
	- (좌석 형태 출력)
2. 예매 내역 확인 `selectListReservation`
3. 예매 취소 `cancelReservation`
0. 로그아웃/처음으로
9. 종료
	- 객체 직렬화

### 관리자 페이지

#### 첫 번째 while

1. 로그인 `callCheckAdmin()`, `checkAdmin()`
2. 관리자 등록 `callRegisterAdmin()`, `registerAdmin()`
9. 종료

#### 두 번째 while

1. 영화 관리
2. 상영 시간표 관리
3. 회원 및 예매 내역 관리
9. 종료

#### 영화 관리

1. 영화 등록
2. 영화 목록 확인
	- 영화별 예매 내역 확인
3. 영화 수정
	- 기존 영화 정보 가져오기
4. 영화 삭제
	- 영화 존재 여부 검사
0. 처음으로
9. 종료

#### 상영 시간표 관리

1. 상영 시간표 등록
2. 상영 시간표 목록 확인
	- 비어 있는 상영 시간표에 영화 추가
3. 상영 시간표 수정
4. 상영 시간표 삭제
0. 처음으로
9. 종료

#### 회원 및 예매 내역 관리

1. 회원 목록 확인
	- 회원별 예매 내역 확인
2. 전체 예매 내역 확인
3. 예매 내역 일괄 변경
0. 처음으로
9. 종료