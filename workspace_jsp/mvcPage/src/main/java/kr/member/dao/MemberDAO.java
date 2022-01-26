package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public void insertMember(MemberVO member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String sql = null;
		int num = 0; // 시퀀스 번호 저장
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// 오토 커밋 해제
			conn.setAutoCommit(false);
			
			// 회원 번호 생성
			// SQL문 작성
			sql = "SELECT zmember_seq.NEXTVAL FROM dual";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			// zmember 테이블에 데이터 저장
			// SQL문 작성
			sql = "INSERT INTO zmember (mem_num, id) VALUES (?, ?)";
			// PreparedStatment 객체 생성
			pstmt2 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt2.setInt(1, num);
			pstmt2.setString(2, member.getId());
			// SQL문 실행
			pstmt2.executeUpdate();
			
			// zmember_detail 테이블에 데이터 저장
			// SQL문 작성
			sql = "INSERT INTO zmember_detail (mem_num, name, passwd, phone, email, zipcode, address1, address2) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			// PreparedStatement 객체 생성
			pstmt3 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt3.setInt(1, num);
			pstmt3.setString(2, member.getName());
			pstmt3.setString(3, member.getPasswd());
			pstmt3.setString(4, member.getPhone());
			pstmt3.setString(5, member.getEmail());
			pstmt3.setString(6, member.getZipcode());
			pstmt3.setString(7, member.getAddress1());
			pstmt3.setString(8, member.getAddress2());
			// SQL문 실행
			pstmt3.executeUpdate();
			
			// SQL문 실행이 모두 성공하면 커밋
			conn.commit();
		}
		catch(Exception e) {
			// SQL문 실행이 하나라도 실패하면 롤백
			conn.rollback(); // rollback() 메서드는 try~catch 의무이지만, insertMember() 메서드 차원에서 throws Exception이므로 생략 가능
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
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
	public MemberVO getMember(int mem_num) throws Exception {
		MemberVO member = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM zmember m JOIN zmember_detail d "
				+ "ON m.mem_num=d.mem_num WHERE m.mem_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, mem_num);
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setMem_num(rs.getInt("mem_num"));
				member.setId(rs.getString("id"));
				member.setAuth(rs.getInt("auth"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setPhoto(rs.getString("photo"));
				member.setReg_date(rs.getDate("reg_date"));
				member.setModify_date(rs.getDate("modify_date"));
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
	
	// 회원 정보 수정
	public void updateMember(MemberVO member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "UPDATE zmember_detail SET name=?, phone=?, email=?, "
				+ "zipcode=?, address1=?, address2=?, "
				+ "modify_date=SYSDATE WHERE mem_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getZipcode());
			pstmt.setString(5, member.getAddress1());
			pstmt.setString(6, member.getAddress2());
			pstmt.setInt(7, member.getMem_num());
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 비밀번호 수정

	// 프로필 사진 수정
	
	// 회원 탈퇴(=회원 정보 삭제)
	
	/* 관리자 */
	// 총 회원 수
	
	// 회원 목록
	
	// 회원 정보 수정
	
	// 회원 정보 삭제

}