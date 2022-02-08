package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.board.vo.BoardReplyVO;
import kr.board.vo.BoardVO;
import kr.util.DBUtil;
import kr.util.DurationFromNow;
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
	public BoardVO getBoard(int board_num) throws Exception {
		BoardVO board = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM zboard b JOIN zmember m "
				+ "ON b.mem_num=m.mem_num WHERE b.board_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, board_num);
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setBoard_num(board_num);
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setModify_date(rs.getDate("modify_date"));
				board.setFilename(rs.getString("filename"));
				board.setMem_num(rs.getInt("mem_num"));
				board.setId(rs.getString("id"));
			}
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return board;
	}
	
	// 조회수 증가
	public void updateReadcount(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "UPDATE zboard SET hit=hit+1 WHERE board_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, board_num);
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 글 수정
	public void updateBoard(BoardVO board) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0; // 가변적 ? 번호 처리
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();

			if(board.getFilename()!=null) {
				sub_sql = "filename=?, ";
			}
			
			// SQL문 작성
			sql = "UPDATE zboard SET title=?, content=?, " + sub_sql
				+ "modify_date=SYSDATE, ip=? WHERE board_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(++cnt, board.getTitle());
			pstmt.setString(++cnt, board.getContent());
			if(board.getFilename()!=null) {
				pstmt.setString(++cnt, board.getFilename());
			}
			pstmt.setString(++cnt, board.getIp());
			pstmt.setInt(++cnt, board.getBoard_num());
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
	
	// 파일 삭제
	public void deleteFile(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "UPDATE zboard SET filename='' WHERE board_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, board_num);
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
	
	// 글 삭제
	public void deleteBoard(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// 오토커밋 해제
			conn.setAutoCommit(false);
			
			// 댓글 삭제
			// SQL문 작성
			sql = "DELETE FROM zboard_reply WHERE board_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, board_num);
			// SQL문 실행
			pstmt.executeUpdate();
			
			// 부모글 삭제
			// SQL문 작성
			sql = "DELETE FROM zboard WHERE board_num=?";
			// PreparedStatement 객체 생성
			pstmt2 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt2.setInt(1, board_num);
			// SQL문 실행
			pstmt2.executeUpdate();
			
			// 정상적으로 모든 SQL문이 실행된 경우
			conn.commit();
		}
		catch(Exception e) {
			// SQL문 실행이 하나라도 실패한 경우
			conn.rollback();
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 댓글 등록
	public void insertReplyBoard(BoardReplyVO boardReply) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO zboard_reply (re_num, re_content, re_ip, board_num, mem_num) "
				+ "VALUES (zreply_seq.NEXTVAL, ?, ?, ?, ?)";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, boardReply.getRe_content());
			pstmt.setString(2, boardReply.getRe_ip());
			pstmt.setInt(3, boardReply.getBoard_num());
			pstmt.setInt(4, boardReply.getMem_num());
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
	
	// 댓글 수
	public int getReplyBoardCount(int board_num) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT COUNT(*) FROM zboard_reply JOIN zmember "
				+ "USING(mem_num) WHERE board_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, board_num);
			// SQL문을 실행해서 ResultSet에 결과 행을 담아 반환
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
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 댓글 목록
	public List<BoardReplyVO> getListReplyBoard(int startRow, int endRow, int board_num) throws Exception {
		List<BoardReplyVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
 			sql = "SELECT * FROM (SELECT r.*, ROWNUM AS rnum "
 				+ "FROM (SELECT b.re_num, TO_CHAR(b.re_date, 'YYYY-MM-DD HH24:MI:SS') AS re_date, "
 				+ "TO_CHAR(b.re_modifydate, 'YYYY-MM-DD HH24:MI:SS') AS re_modifydate, b.re_content, "
 				+ "b.board_num, mem_num, m.id FROM zboard_reply b JOIN zmember m USING(mem_num) " // USING에 사용되는 컬럼은 컬럼명에 테이블 알리아스를 붙이면 오류 발생하므로 주의
 				+ "WHERE b.board_num=? ORDER BY b.re_num DESC) r) "
 				+ "WHERE rnum >= ? AND rnum <= ?";
 			// PreparedStatement 객체 생성
 			pstmt = conn.prepareStatement(sql);
 			// ?에 데이터를 바인딩
 			pstmt.setInt(1, board_num);
 			pstmt.setInt(2, startRow);
 			pstmt.setInt(3, endRow);
 			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
 			rs = pstmt.executeQuery();
 			list = new ArrayList<BoardReplyVO>();
 			while(rs.next()) {
 				BoardReplyVO reply = new BoardReplyVO();
 				reply.setRe_num(rs.getInt("re_num"));
 				// 날짜를 1분 전, 1시간 전, 1일 전 형식의 문자열로 변환
 				reply.setRe_date(DurationFromNow.getTimeDiffLabel(rs.getString("re_date")));
 				if(rs.getString("re_modifydate")!=null) {
 					reply.setRe_modifydate(DurationFromNow.getTimeDiffLabel(rs.getString("re_modifydate")));
 				}
 				// 줄바꿈은 인정하고 HTML 태그는 허용하지 않음
 				reply.setRe_content(StringUtil.useBrNoHtml(rs.getString("re_content")));
 				reply.setBoard_num(rs.getInt("board_num"));
 				reply.setMem_num(rs.getInt("mem_num"));
 				reply.setId(rs.getString("id"));

 				list.add(reply);
 			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 댓글 상세
	
	// 댓글 수정
	
	// 댓글 삭제
	
}