package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.product.dao.ProductDAO;
import kr.product.vo.ProductVO;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 자바빈 생성
		ProductVO vo = new ProductVO();
		
		// 전송된 데이터를 자바빈에 저장
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setName(request.getParameter("name"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setStock(Integer.parseInt(request.getParameter("stock")));
		vo.setOrigin(request.getParameter("origin"));
		vo.setContent(request.getParameter("content"));
		
		// DAO 호출
		ProductDAO.getInstance().updateProduct(vo);
		
		// JSP 경로 반환
		return "/WEB-INF/views/modify.jsp";
	}

}