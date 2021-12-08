# 영화 예매 프로그램

## 폐기한 코드

### 연령 제한을 CASE WHEN~THEN~ELSE로

- `MovieDAO.java`
```java
	// 연령 제한 확인
	public int checkAge(ReservationVO reservation) {
		int check=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT CASE WHEN (SELECT me_age FROM m_member WHERE me_num=?) >= "
				+ "(SELECT mo_ban FROM m_movie WHERE mo_num=?) THEN 1 ELSE 0 END FROM dual";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservation.getMe_num());
			pstmt.setInt(2, reservation.getMo_num());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)==1) check=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return check;
	}
```

### 날짜 및 시간을 자바에서 String으로, 데이터베이스에서 Date로

- `MovieMain.java`
```java
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("메뉴 : 1. 영화 등록, 2. 영화 목록 확인, 3. 영화 수정, 4. 영화 삭제, 5. 전체 예매 내역 확인, 6. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) { // 영화 등록
					MovieVO vo = new MovieVO();
					System.out.print("영화 제목 > ");
					vo.setMo_title(br.readLine());
					System.out.println("관람가는 제한 연령을 숫자만 입력하세요.");
					System.out.println("15금이면 15만 입력하고, 전체 관람가는 0을 입력하세요.");
					System.out.print("관람가 > ");
					vo.setMo_ban(Integer.parseInt(br.readLine()));
					System.out.println("상영 날짜 및 시간은 YYYY-MM-DD HH:MI:SS 형식으로 입력하세요.");
					System.out.print("상영 날짜 및 시간 > ");
					vo.setMo_date(br.readLine());
					System.out.print("좌석 수 > ");
					vo.setMo_seats(Integer.parseInt(br.readLine()));
					dao.insertMovie(vo);
				} // if 블럭 종료
				/*
				 * 2~6번 메뉴를 위한 else if 블럭 및 else 블럭 생략
				 */
			}
			catch(NumberFormatException e) {
				System.out.println("메뉴를 잘못 입력했습니다!");
			}
		}
	}
```
- `MovieDAO.java`
```java
	// 영화 등록
	public void insertMovie(MovieVO movie) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "insert into m_movie (mo_num, mo_title, mo_ban, mo_date, mo_seats) "
					+ "values (m_movie_seq.nextval, ?, ?, to_date(?, 'YYYY-MM-DD HH:MI:SS'), ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getMo_title());
			pstmt.setInt(2, movie.getMo_ban());
			pstmt.setString(3, movie.getMo_date());
			pstmt.setInt(4, movie.getMo_seats());
			int count = pstmt.executeUpdate();
			System.out.println(count+"편의 영화를 추가했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
```
- `MovieVO.java`
```java
	private String mo_date;
	
	public String getMo_date() {
		return mo_date;
	}
	public void setMo_date(String mo_date) {
		this.mo_date = mo_date;
	}
```