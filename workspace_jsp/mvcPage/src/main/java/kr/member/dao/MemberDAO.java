package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.member.vo.MemberVO;
import kr.util.DBUtil;

public class MemberDAO {
	// 싱글턴 패턴
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	/* 일반 회원 */
	// 회원 가입
	
	// 아이디 중복 체크 및 로그인 처리
	public MemberVO checkMember(String id) throws Exception {
		MemberVO member = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM zmember m LEFT OUTER JOIN zmember_detail d "
				+ "ON m.mem_num=d.mem_num WHERE m.id=?"; // zmember_detail에서 정보가 삭제된 아이디(=탈퇴한 경우)도 조회되어야 아이디 중복 체크가 가능하므로 OUTER JOIN			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, id);			
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setMem_num(rs.getInt("mem_num"));
				member.setId(rs.getString("id"));
				member.setAuth(rs.getInt("auth"));
				member.setPasswd(rs.getString("passwd"));
				member.setPhoto(rs.getString("photo"));
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return member;
	}
	
	// 회원 상세 정보
	
	// 회원 정보 수정
	
	// 비밀번호 수정

	// 프로필 사진 수정
	
	// 회원 탈퇴(=회원 정보 삭제)
	
	/* 관리자 */
	// 총 회원 수
	
	// 회원 목록
	
	// 회원 정보 수정
	
	// 회원 정보 삭제

}