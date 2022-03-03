package kr.spring.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.board.vo.BoardVO;

@Repository // DAO 전용 어노테이션; 자동 스캔되기 위해 필요
public class BoardDAOImpl implements BoardDAO {
	
	private static final String INSERT_SQL = "INSERT INTO tboard (num, name, title, passwd, content, reg_date) "
											+ "VALUES (tboard_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertBoard(BoardVO board) {
		jdbcTemplate.update(INSERT_SQL, new Object[] {board.getName(), board.getTitle(), board.getPasswd(), board.getContent()});
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}

}