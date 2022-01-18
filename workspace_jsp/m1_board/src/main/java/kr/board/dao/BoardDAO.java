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
	
	private BoardDAO() {};
	
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
	public void insert(BoardVO boardVO) throws Exception {
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
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getName());
			pstmt.setString(3, boardVO.getPasswd());
			pstmt.setString(4, boardVO.getContent());
			pstmt.setString(5, boardVO.getIp());
			
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
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
	
	// 글 목록
	public List<BoardVO> getList(int startRow, int endRow) throws Exception { // 일반적으로 같은 클래스 내부에서만 사용할 때는 자료형을 ArrayList로, 외부에서 사용할 때는 자료형을 List로 지정
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		List<BoardVO> list = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM "
				+ "(SELECT * FROM sboard ORDER BY num DESC) a) "
				+ "WHERE rnum >= ? AND rnum <= ?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			
			// ArrayList 객체 생성
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				// 하나의 레코드 정보를 담기 위해 자바빈 객체 생성
				BoardVO boardVO = new BoardVO();
				boardVO.setNum(rs.getInt("num"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setName(rs.getString("name"));
				boardVO.setReg_date(rs.getDate("reg_date"));

				// 자바빈을 ArrayList에 등록
				list.add(boardVO);
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
	
	// 글 상세
	public BoardVO getBoard(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
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
				board = new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setContent(rs.getString("content"));
				board.setIp(rs.getString("ip"));
				board.setReg_date(rs.getDate("reg_date"));
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(rs, pstmt, conn);
		}
		
		return board;
	}
	
	// 글 수정
	public void update(BoardVO boardVO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			// SQL문 작성
			sql = "UPDATE sboard SET title=?, name=?, content=?, ip=?, reg_date=SYSDATE WHERE num=?";
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getName());
			pstmt.setString(3, boardVO.getContent());
			pstmt.setString(4, boardVO.getIp());
			pstmt.setInt(5, boardVO.getNum());
			
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
	
	// 글 삭제
	public void delete(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
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
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			executeClose(null, pstmt, conn);
		}
	}
}