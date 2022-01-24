package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDAO;
import kr.product.vo.ProductVO;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ProductVO vo = new ProductVO();
		vo.setName(request.getParameter("name"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setStock(Integer.parseInt(request.getParameter("stock")));
		vo.setOrigin(request.getParameter("origin"));
		vo.setContent(request.getParameter("content"));
		
		ProductDAO.getInstance().registerProduct(vo);
		
		// JSP 경로 반환
		return "WEB-INF/views/write.jsp";
	}

}