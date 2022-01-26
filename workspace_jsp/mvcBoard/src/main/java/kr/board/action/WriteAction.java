package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 자바빈 객체 생성
		BoardVO vo = new BoardVO();	
		vo.setTitle(request.getParameter("title"));
		vo.setName(request.getParameter("name"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setContent(request.getParameter("content"));
		vo.setIp(request.getRemoteAddr());
		
		// DAO 호출
		BoardDAO dao = BoardDAO.getInstance();
		// 글 작성
		dao.insert(vo);
		
		// JSP 경로 반환
		return "/WEB-INF/views/write.jsp";
	}

}