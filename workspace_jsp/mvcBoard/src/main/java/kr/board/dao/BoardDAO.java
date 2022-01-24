package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.board.vo.BoardVO;

public class BoardDAO {
	// 싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}

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
	
	// 글 저장
	public void insert(BoardVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "INSERT INTO sboard (num, title, name, passwd, content, ip, reg_date) "
				+ "VALUES (sboard_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getIp());
			
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(null, pstmt, conn);
		}
	}
	
	// 글의 총 갯수
	public int getCount() throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "SELECT COUNT(*) FROM sboard";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 목록
	public List<BoardVO> getList(int startRow, int endRow) throws Exception {
		List<BoardVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM (SELECT sb.*, ROWNUM AS rnum "
				+ "FROM (SELECT * FROM sboard ORDER BY num DESC) sb) "
				+ "WHERE rnum >= ? AND rnum <= ?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			// 반복문을 이용해서 자바빈을 생성하고 정보를 저장
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				// 자바빈 생성
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setReg_date(rs.getDate("reg_date"));
				
				// 자바빈을 ArrayList에 저장
				list.add(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 글 상세 정보
	public BoardVO getBoard(int num) throws Exception {
		BoardVO vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM sboard WHERE num=?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num);
			
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setNum(num);
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setReg_date(rs.getDate("reg_date"));
			}
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(rs, pstmt, conn);
		}
		
		return vo;
	}
	
	// 글 수정
	public void update(BoardVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "UPDATE sboard SET title=?, name=?, content=?, ip=?, reg_date=SYSDATE "
				+ "WHERE num=?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getNum());
			
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(null, pstmt, conn);
		}		
	}
	
	// 글 삭제
	public void delete(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "DELETE FROM sboard WHERE num=?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num);
			
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(null, pstmt, conn);
		}		
	}
}