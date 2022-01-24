package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDAO;
import kr.util.PagingUtil;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		ProductDAO dao = ProductDAO.getInstance();
		int totalCount = dao.getCount();
		PagingUtil pg = new PagingUtil(currentPage, totalCount, 10, 5, "list.do");
		
		request.setAttribute("list", dao.getList(pg.getStartCount(), pg.getEndCount()));
		request.setAttribute("pagingHtml", pg.getPagingHtml());
		request.setAttribute("totalCount", totalCount);
		
		// JSP 경로 반환
		return "WEB-INF/views/list.jsp";
	}

}