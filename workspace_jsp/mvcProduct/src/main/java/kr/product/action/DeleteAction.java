package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDAO;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO.getInstance().deleteProduct(Integer.parseInt(request.getParameter("num")));
		
		// JSP 경로 반환
		return "/WEB-INF/views/delete.jsp";
	}

}