package kr.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";

		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		if(keyfield==null) keyfield = ""; // GET 방식으로 null 전송시 PagingUtil에서 문제가 발생할 수 있으므로 빈 문자열로 처리
		if(keyword==null) keyword = "";
		
		BoardDAO dao = BoardDAO.getInstance();
		int totalCount = dao.getBoardCount(keyfield, keyword);
		
		// 페이지 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, Integer.parseInt(pageNum), totalCount, 20, 10, "list.do");
		
		List<BoardVO> list = null;
		if(totalCount>0) {
			list = dao.getListBoard(page.getStartCount(), page.getEndCount(), keyfield, keyword);
		}
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		
		// JSP 경로 반환
		return "/WEB-INF/views/board/list.jsp";
	}

}