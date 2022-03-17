package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.vo.BoardVO;

@Mapper // @Mapper 어노테이션이 있어야 구현되는 객체를 서비스에서 인식 가능
public interface BoardMapper {
	public void insertBoard(BoardVO board);
	@Select("SELECT COUNT(*) FROM tboard")
	public int getBoardCount();
	public List<BoardVO> getBoardList(Map<String, Object> map);
	@Select("SELECT * FROM tboard WHERE num=#{num}")
	public BoardVO getBoard(int num);
	@Update("UPDATE tboard SET name=#{name}, title=#{title}, content=#{content} WHERE num=#{num}")
	public void updateBoard(BoardVO board);
	@Delete("DELETE FROM tboard WHERE num=#{num}")
	public void deleteBoard(int num);
}