package kr.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.order.dao.OrderDAO;

public class AdminDeleteOrderAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		OrderDAO.getInstance().deleteOrder(order_num);
		
		return "redirect:/order/list.do";
	}

}