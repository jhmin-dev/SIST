package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.vo.BoardVO;

public interface BoardMapper { // 인터페이스명을 XML 파일명과 동일하게 하면 별도의 구현 클래스를 만들 필요 없이 MyBatis에서 처리
	// SQL문은 XML이나 어노테이션 중 한쪽에만 명시 가능
	public void insertBoard(BoardVO board);
	@Select("SELECT COUNT(*) FROM tboard") // (SQL문이 간단한 경우) 어노테이션에 SQL문 명시
	public int getBoardCount();
	// (SQL문이 복잡한 경우) XML에 SQL문 명시; XML에서 SQL문의 식별자는 DAO의 메서드명을 사용
	public List<BoardVO> getBoardList(Map<String, Object> map);
	@Select("SELECT * FROM tboard WHERE num=#{num}")
	public BoardVO getBoard(int num);
	@Update("UPDATE tboard SET name=#{name}, title=#{title}, content=#{content} WHERE num=#{num}")
	public void updateBoard(BoardVO board);
	@Delete("DELETE FROM tboard WHERE num=#{num}")
	public void deleteBoard(int num);
}