package kr.spring.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.spring.board.vo.BoardVO;

@Repository // DAO 전용 어노테이션; 자동 스캔되기 위해 필요
public class BoardDAOImpl implements BoardDAO {
	private static final String INSERT_SQL 
			= "INSERT INTO tboard (num, name, title, passwd, content, reg_date) "
			+ "VALUES (tboard_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
	private static final String SELECT_COUNT_SQL
			= "SELECT COUNT(*) FROM tboard";
	private static final String SELECT_LIST_SQL
			= "SELECT * FROM (SELECT a.*, ROWNUM AS rnum FROM "
			+ "(SELECT * FROM tboard ORDER BY reg_date DESC) a) WHERE rnum>=? AND rnum<=?";
	private static final String SELECT_DETAIL_SQL
			= "SELECT * FROM tboard WHERE num=?";
	private static final String UPDATE_SQL
			= "UPDATE tboard SET name=?, title=?, content=? WHERE num=?";
	private static final String DELETE_SQL 
			= "DELETE FROM tboard WHERE num=?";
	
	// ResultSet 처리를 위해 RowMapper가 구현된 익명 클래스 객체 생성
	private RowMapper<BoardVO> rowMapper = new RowMapper<BoardVO>() { // RowMapper 인터페이스를 구현한 익명 클래스를 정의하고(=RowMapper<BoardVO>() {}), 그 익명 클래스의 객체를 생성하여(=new) 변수 rowMapper에 할당
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException { // RowMapper 인터페이스의 추상 메서드 mapRow()를 구현
			BoardVO board = new BoardVO();
			board.setNum(rs.getInt("num"));
			board.setName(rs.getString("name"));
			board.setTitle(rs.getString("title"));
			board.setPasswd(rs.getString("passwd"));
			board.setContent(rs.getString("content"));
			board.setReg_date(rs.getDate("reg_date"));
			
			return board;
		}
	};
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertBoard(BoardVO board) {
		jdbcTemplate.update(INSERT_SQL, 
				new Object[] {board.getName(), board.getTitle(), board.getPasswd(), board.getContent()}); // 인자로 SQL문과 ?에 바인딩될 데이터가 담긴 Object 배열을 전달
	}

	@Override
	public int getBoardCount() {
		return jdbcTemplate.queryForObject(SELECT_COUNT_SQL, Integer.class); // 인자로 SQL문과 반환하는 데이터의 자료형을 전달
	}

	@Override
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		List<BoardVO> list = jdbcTemplate.query(SELECT_LIST_SQL, 
				new Object[] {startRow, endRow}, rowMapper); // 인자로 SQL문, ?에 바인딩될 데이터가 담긴 Object 배열, RowMapper가 구현된 익명 클래스 객체를 전달
		return list;
	}

	@Override
	public BoardVO getBoard(int num) {
		BoardVO board = jdbcTemplate.queryForObject(SELECT_DETAIL_SQL, 
				new Object[] {num}, rowMapper); // 인자로 SQL문, ?에 바인딩될 데이터가 담긴 Object 배열, RowMapper가 구현된 익명 클래스 객체를 전달
		return board;
	}

	@Override
	public void updateBoard(BoardVO board) {
		jdbcTemplate.update(UPDATE_SQL, 
				new Object[] {board.getName(), board.getTitle(), board.getContent(), board.getNum()}); // 인자로 SQL문과 ?에 바인딩될 데이터가 담긴 Object 배열을 전달
	}

	@Override
	public void deleteBoard(int num) {
		jdbcTemplate.update(DELETE_SQL, new Object[] {num}); // 인자로 SQL문과 ?에 바인딩될 데이터가 담긴 Object 배열을 전달
	}
}