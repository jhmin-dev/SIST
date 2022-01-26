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
		if(pageNum==null) {
			pageNum = "1";
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		int count = dao.getCount();
		
		// 페이지 처리
		PagingUtil page = new PagingUtil(Integer.parseInt(pageNum), count, 20, 10, "list.do"); // currentPage, totalCount, rowCount, pageCount, pageUrl
		
		List<BoardVO> list = null;
		if(count > 0) {
			list = dao.getList(page.getStartCount(), page.getEndCount());
		}
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		
		// JSP 경로 반환
		return "/WEB-INF/views/list.jsp"; // WEB-INF는 클라이언트에서 직접 호출 불가; WEB-INF 하위에 위치한 JSP 페이지는 (Servlet을 통한) forward 방식으로만 접근 가능
	}

}