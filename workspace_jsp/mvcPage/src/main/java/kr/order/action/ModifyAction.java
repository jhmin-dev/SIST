package kr.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer user_num = (Integer)request.getSession().getAttribute("user_num");
		
		if(user_num==null) {
			return "redirect:/member/loginForm.do";
		}
		
		// 로그인한 경우
		request.setCharacterEncoding("UTF-8");;
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		String status = request.getParameter("status");
		if(status==null) status = "1"; // 배송 대기
		
		// 주문 수정 전 배송 상태를 최종적으로 체크
		OrderDAO dao = OrderDAO.getInstance();
		OrderVO db_order = dao.getOrder(order_num);
		
		if(db_order.getStatus()>1) {
			// 배송 준비 중 이상으로 상품 주문 정보가 변경되어 사용자가 주문 정보를 변경할 수 없음
			request.setAttribute("notice_msg", "배송 상태가 변경되어 주문자가 주문 정보 변경 불가");
			request.setAttribute("notice_url", request.getContextPath() + "/order/orderList.do");
			return "/WEB-INF/views/common/alert_singleView.jsp";
		}
		
		OrderVO order = new OrderVO();
		order.setOrder_num(order_num);
		order.setPayment(Integer.parseInt(request.getParameter("payment")));
		order.setStatus(Integer.parseInt(status));
		order.setReceive_name(request.getParameter("receive_name"));
		order.setReceive_post(request.getParameter("receive_post"));
		order.setReceive_address1(request.getParameter("receive_address1"));
		order.setReceive_address2(request.getParameter("receive_address2"));
		order.setReceive_phone(request.getParameter("receive_phone"));
		
		// 주문 정보 수정
		dao.updateOrder(order);
		
		return "redirect:/order/orderList.do";
	}

}
