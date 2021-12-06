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
			sql = "SELECT * FROM book ORDER BY bk_num DESC";
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과 집합을 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t도서명\t\t분류\t등록일");
			while(rs.next()) {
				System.out.print(rs.getInt("bk_num")+"\t");
				String bk_name = rs.getString("bk_name");
				if(bk_name.length()>6+6) System.out.print(bk_name.substring(0,4+6) + "..\t");
				else if(bk_name.length()>6) System.out.print(bk_name + "\t");
				else System.out.print(bk_name + "\t\t");
				String bk_category = rs.getString("bk_category");
				if(bk_category.length()>6) System.out.print(bk_category.substring(0,4) + "..\t");
				else System.out.print(bk_category + "\t");
				System.out.println(rs.getDate("bk_regdate"));
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