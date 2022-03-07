package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.spring.board.vo.BoardVO;

@Repository // 자동 스캔 처리
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertBoard(BoardVO board) {
		sqlSession.insert("insertBoard", board);
	}

	@Override
	public int getBoardCount() {
		Integer count = sqlSession.selectOne("getBoardCount");
		return count;
	}

	@Override
	public List<BoardVO> getBoardList(Map<String, Object> map) {
		return sqlSession.selectList("getBoardList", map); // 인자로 XML에 포함된 SQL문 호출에 사용할 식별자와 ?에 바인딩할 데이터가 담긴 Map 객체 전달
	}

	@Override
	public BoardVO getBoard(int num) {
		return sqlSession.selectOne("getBoard", num); // 자바빈 또는 Map 객체가 아니라 값 하나만 전달시, 해당 값이 담긴 변수명 num이 데이터 바인딩시의 식별자로 사용됨
	}

	@Override
	public void updateBoard(BoardVO board) {
		sqlSession.update("updateBoard", board);
	}

	@Override
	public void deleteBoard(int num) {
		sqlSession.delete("deleteBoard", num);
	}
}