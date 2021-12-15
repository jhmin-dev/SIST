package myminiprj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaDAO {
	// 로그인
	public int getLogin(String me_id, String me_pw) {
		int me_num = 0;

		return me_num;
	}

	// 관리자 검사
	public String checkAdmin(String me_id, String me_pw) {
		String me_access = "USER";

		return me_access;
	}

	// 회원 가입
	public void insertMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO my_member (me_num, me_id, me_pw, me_name, me_birthdate) "
				+ "VALUES (my_member_seq.NEXTVAL, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMe_id());
			pstmt.setString(2, vo.getMe_pw());
			pstmt.setString(3, vo.getMe_name());
			pstmt.setString(4, vo.getMe_birthdate());
			int count = pstmt.executeUpdate();
			if(count==1) {
				System.out.println(vo.getMe_name()+"님 회원 가입이 완료되었습니다.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 관리자 등록
	public void registerAdmin() {

	}

	// 아이디 중복 검사
	public int checkID(MemberVO vo) {
		int check = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT me_num FROM my_member WHERE me_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMe_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt("me_num");
				System.out.println(vo.getMe_id()+"는 이미 존재하는 아이디입니다!");
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
}