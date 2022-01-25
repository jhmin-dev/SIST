package kr.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDAO;
import kr.product.vo.ProductVO;
import kr.util.PagingUtil;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		
		ProductDAO dao = ProductDAO.getInstance();
		int totalCount = dao.getCount();

		// 페이지 처리
		PagingUtil pg = new PagingUtil(Integer.parseInt(pageNum), totalCount, 20, 10, "list.do");
		
		List<ProductVO> list = null;
		if(totalCount>0) {
			list = dao.getList(pg.getStartCount(), pg.getEndCount());	
		}

		// 데이터를 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", pg.getPagingHtml());
		request.setAttribute("totalCount", totalCount);
		
		// JSP 경로 반환
		return "/WEB-INF/views/list.jsp";
	}

}