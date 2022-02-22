package kr.order.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;
import kr.util.PagingUtil;

public class OrderListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		// 로그인되어 있는 경우
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		OrderDAO dao = OrderDAO.getInstance();
		int count = dao.getOrderCountByMem_num(keyfield, keyword, user_num);
		
		// 페이지 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, Integer.parseInt(pageNum), count, 20, 10, "orderList.do");
		
		List<OrderVO> list = null;
		if(count>0) {
			list = dao.getOrderByMem_num(page.getStartCount(), page.getEndCount(), keyfield, keyword, user_num);	
		}
		else {
			list = Collections.emptyList();
		}
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		
		// JSP 경로 반환
		return "/WEB-INF/views/order/order_list.jsp";
	}

}