package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.member.vo.MemberVO;

public class MemberDAO {

	/*
	 * 싱글턴 패턴 : 생성자를 private으로 지정해서 외부에서 호출할 수 없도록 처리하고, static 메서드를 호출해서 객체가 한 번만 생성되고 생성된 객체를 공유할 수 있도록 처리하는 방식
	 */
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	// context.xml에서 설정 정보를 읽어들여 커넥션 풀로부터 커넥션을 할당받음
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}
	
	// 자원 정리
	private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
	
	// 회원 가입
	public void insertMember(MemberVO member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "INSERT INTO smember (num, id, name, passwd, email, phone, reg_date) "
				+ "VALUES (smember_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
			
			// PrepearedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	// 회원 상세 정보
	
	// 아이디 중복 체크, 로그인 체크
	public MemberVO checkMember(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM smember WHERE id=?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, id);
			
			// SQL문을 실행하고 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO(); // 자바빈 객체 생성
				member.setId(rs.getString("id"));
				member.setNum(rs.getInt("num"));
				member.setPasswd(rs.getString("passwd"));
			}
		}
		catch(Exception e) {
			// e.printStackTrace(); // UI는 상황에 따라 정상 화면에 값만 null로 출력되고, 콘솔에는 에러 메시지가 출력됨
			throw new Exception(e); // UI는 에러 페이지가 전송되고, 콘솔에는 에러 메시지가 출력됨
		}
		finally {
			executeClose(rs, pstmt, conn);
		}
		
		return member;
	}
	
	// 회원 정보 수정
	
	// 회원 탈퇴(회원 정보 삭제)
}