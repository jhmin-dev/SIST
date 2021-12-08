package kr.s09.book;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
	// 도서 등록
	public void insertBook(BookVO book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO book (bk_num, bk_name, bk_category) "
				+ "VALUES (book_seq.NEXTVAL, ?, ?)";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, book.getBk_name());
			pstmt.setString(2, book.getBk_category());
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			System.out.println(count+"건의 도서를 등록했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 도서 목록 보기
	public void selectListBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM book LEFT OUTER JOIN (SELECT bk_num, re_status from reservation WHERE re_status=1)"
				+ "USING(bk_num) ORDER BY bk_num DESC";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과 집합을 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t분류\t\t등록일\t\t대출 여부\t도서명");
			while(rs.next()) {
				System.out.print(rs.getInt("bk_num")+"\t");
				String bk_category = rs.getString("bk_category");
				if(bk_category.length()>6) System.out.print(bk_category + "\t");
				else System.out.print(bk_category + "\t\t");
				System.out.print(rs.getDate("bk_regdate") + "\t");
				if(rs.getInt("re_status")==0) { // re_status가 NULL일 경우, getInt() 메서드는 0으로 반환하고 getString() 메서드는 null로 반환
					System.out.print("대출 가능\t");
				}
				else {
					System.out.print("대출 중\t");
				}
				System.out.println(rs.getString("bk_name"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	// 대출 등록
	public void insertReservation(ReservationVO reservation) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO reservation (re_num, bk_num, me_num, re_status)"
				+ "VALUES (reservation_seq.NEXTVAL, ?, ?, 1)";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, reservation.getBk_num());
			pstmt.setInt(2, reservation.getMe_num());
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 삽입
			int count = pstmt.executeUpdate();
			System.out.println(count + "권의 도서를 대출하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 대출 여부 확인
	public int getStatusReservation(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT re_status FROM book LEFT OUTER JOIN (SELECT * FROM reservation WHERE re_status=1)"
				+ "USING(bk_num) WHERE bk_num=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, bk_num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 대출 여부 조회
			rs = pstmt.executeQuery();
			if(rs.next()) { // 있는 도서 번호를 입력한 경우
				count = rs.getInt(1); // re_status의 값을 반환; null일 경우 getInt() 메서드는 0을 반환
			}
			else { // 없는 도서 번호를 입력한 경우
				count = -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 반납 여부 체크
	public int getStatusBack(int re_num, int me_num) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT re_status FROM reservation WHERE re_num=? AND me_num=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, re_num); // 대출 번호
			pstmt.setInt(2, me_num); // 회원 번호
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 반납 여부 체크
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			else {
				count = -1;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 반납 처리
	public void updateReservation(int re_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "UPDATE reservation SET re_status=0, re_modifydate=SYSDATE WHERE re_num=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setInt(1, re_num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 반납 처리
			int count = pstmt.executeUpdate();
			System.out.println(count + "권의 도서를 반납하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 대출 목록 보기
	public void selectListReservation() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT re_num, me_id, bk_name, re_status, re_regdate, re_modifydate "
				+ "FROM reservation JOIN book USING(bk_num) JOIN member USING(me_num) ORDER BY re_num DESC";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행하고 테이블로부터 결과 집합을 얻어서 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			System.out.println("번호\t아이디\t도서명\t대출 여부\t대출일\t\t반납일");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num") + "\t");
				System.out.print(rs.getString("me_id") + "\t");
				if(rs.getString("bk_name").length()>6) { // 도서명이 긴 경우 말줄임표 처리
					System.out.print(rs.getString("bk_name").substring(0, 4) + "..\t");
				}
				else {
					System.out.print(rs.getString("bk_name") + "\t");
				}
				if(rs.getInt("re_status")==0) {
					System.out.print("반납\t");
				}
				else {
					System.out.print("대출 중\t");
				}
				System.out.print(rs.getDate("re_regdate") + "\t");
				if(rs.getDate("re_modifydate")==null) { // 반납하지 않았을 경우 null 대신 빈 문자열 출력
					System.out.println();
				}
				else {
					System.out.println(rs.getDate("re_modifydate"));
				};
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	// 내 대출 목록
	public void selectMyList(int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT re_num, bk_name, re_status, re_regdate, re_modifydate "
				+ "FROM reservation JOIN book USING(bk_num) JOIN member USING(me_num)"
				+ "WHERE me_num=? ORDER BY re_num DESC";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, me_num);
			// JDBC 수행 4단계 : SQL문을 실행하고 테이블로부터 결과 집합을 얻어서 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			System.out.println("번호\t도서명\t대출 여부\t대출일\t\t반납일");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num") + "\t");
				if(rs.getString("bk_name").length()>6) { // 도서명이 긴 경우 말줄임표 처리
					System.out.print(rs.getString("bk_name").substring(0, 4) + "..\t");
				}
				else {
					System.out.print(rs.getString("bk_name") + "\t");
				}
				if(rs.getInt("re_status")==0) {
					System.out.print("반납\t");
				}
				else {
					System.out.print("대출 중\t");
				}
				System.out.print(rs.getDate("re_regdate") + "\t");
				if(rs.getDate("re_modifydate")==null) { // 반납하지 않았을 경우 null 대신 빈 문자열 출력
					System.out.println();
				}
				else {
					System.out.println(rs.getDate("re_modifydate"));
				};
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	// 회원 가입
	public void insertMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO member (me_num, me_id, me_passwd, me_name, me_phone)"
				+ "VALUES (member_seq.NEXTVAL, ?, ?, ?, ?)";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, member.getMe_id());
			pstmt.setString(2, member.getMe_passwd());
			pstmt.setString(3, member.getMe_name());
			pstmt.setString(4, member.getMe_phone());
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			System.out.println(count + "건의 회원 정보를 추가했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 회원 목록
	public void selectListMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM member ORDER BY me_num DESC";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과 집합을 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("번호\tID\t이름\t연락처\t\t가입일"); // 비밀번호의 경우 관리자 페이지에서도 노출하지 않는 것이 안전
			while(rs.next()) {
				System.out.print(rs.getInt("me_num")+"\t");
				System.out.print(rs.getString("me_id") + "\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("me_phone")+"\t");
				System.out.println(rs.getDate("me_regdate"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	// 아이디 중복 체크
	public int checkID(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT me_id FROM member WHERE me_id=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, me_id);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 아이디를 조회
			rs = pstmt.executeQuery();
			if(rs.next()) { // me_id는 UNIQUE KEY이므로 최대 한 건만 반환
				count = 1; // 1: 이미 있는 아이디, 0: 없는 아이디
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 로그인 체크
	public int loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num = 0; // 로그인이 가능하면 회원 번호 반환; me_num은 1부터 시작
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT me_num FROM member WHERE me_id=? AND me_passwd=?";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 회원 번호 구하기
			rs = pstmt.executeQuery();
			if(rs.next()) { // me_id는 UNIQUE KEY이므로 결과를 최대 한 건만 반환
				me_num = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return me_num;
	}
}