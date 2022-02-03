package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.board.vo.BoardVO;
import kr.util.DBUtil;
import kr.util.StringUtil;

public class BoardDAO {
	// 싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}
	
	// 글 등록
	public void insertBoard(BoardVO board) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO zboard (board_num, title, content, filename, ip, mem_num) "
				+ "VALUES (zboard_seq.NEXTVAL, ?, ?, ?, ?, ?)";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getFilename());
			pstmt.setString(4, board.getIp());
			pstmt.setInt(5, board.getMem_num());
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
	
	// 총 레코드 수/검색 레코드 수
	public int getBoardCount(String keyfield, String keyword) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();			
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "WHERE title LIKE ?";
				else if(keyfield.equals("2")) sub_sql = "WHERE id LIKE ?";
				else if(keyfield.equals("3")) sub_sql = "WHERE content LIKE ?";
			}
			// SQL문 작성
			sql = "SELECT COUNT(*) FROM zboard JOIN zmember USING(mem_num)" + sub_sql;
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			if(keyword!=null && !"".equals(keyword)) {
				pstmt.setString(1, "%" + keyword + "%");
			}
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}			
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 목록
	public List<BoardVO> getListBoard(int startRow, int endRow, String keyfield, String keyword) throws Exception {
		List<BoardVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0; // 가변적 ? 번호 처리
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "WHERE title LIKE ?";
				else if(keyfield.equals("2")) sub_sql = "WHERE id LIKE ?";
				else if(keyfield.equals("3")) sub_sql = "WHERE content LIKE ?";				
			}
			// SQL문 작성
			sql = "SELECT * FROM (SELECT z.*, ROWNUM AS rnum "
				+ "FROM (SELECT * FROM zboard JOIN zmember USING(mem_num) "
				+ sub_sql + " ORDER BY board_num DESC) z) "
				+ "WHERE rnum >= ? AND rnum <=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			if(keyword!=null && !"".equals(keyword)) {
				pstmt.setString(++cnt, "%" + keyword + "%");
			}
			pstmt.setInt(++cnt, startRow);
			pstmt.setInt(++cnt, endRow);
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setTitle(StringUtil.useNoHtml(rs.getString("title"))); // 제목에는 HTML 태그를 허용하지 않음
				board.setHit(rs.getInt("hit"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setId(rs.getString("id"));
				// BoardVO를 ArrayList에 저장
				list.add(board);
			}
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 글 상세
	
	// 조회수 증가
	
	// 글 수정
	
	// 글 삭제
	
}