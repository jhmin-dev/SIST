package kr.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.cart.dao.CartDAO;
import kr.cart.vo.CartVO;
import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderDetailVO;
import kr.order.vo.OrderVO;

public class OrderAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		// 로그인되어 있는 경우
		
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		CartDAO dao = CartDAO.getInstance();
		int all_total = dao.getTotalByMem_num(user_num);
		if(all_total<=0) {
			request.setAttribute("notice_msg", "정상적인 주문이 아니거나 상품의 수량이 부족합니다.");
			request.setAttribute("notice_url", request.getContextPath() + "/item/itemList.do");
			return "/WEB-INF/views/common/alert_singleView.jsp";
		}
		
		List<CartVO> cartList = dao.getListCart(user_num);
		
		// 주문 상품의 대표 상품명 생성
		String item_name;
		if(cartList.size()==1) {
			item_name = cartList.get(0).getItem().getName();
		}
		else {
			item_name = cartList.get(0).getItem().getName() + " 외 " + (cartList.size()-1) + "건";
		}
		
		// zorder_detail에 저장할 데이터 생성
		// 여러 종류의 상품이 있을 수 있기 때문에 상품의 정보를 OrderDetailVO에 각각 저장
		List<OrderDetailVO> orderDetailList = new ArrayList<OrderDetailVO>();
		for(CartVO cart : cartList) {
			ItemDAO itemDao = ItemDAO.getInstance();
			ItemVO item = itemDao.getItem(cart.getItem_num());
			
			if(item.getStatus()==1) {
				// 상품 미표시인 경우
				request.setAttribute("notice_msg", "[" + item.getName() + "] 상품 판매 중지");
				request.setAttribute("notice_url", request.getContextPath() + "/cart/list.do");
				return "/WEB-INF/views/common/alert_singleView.jsp";
			}
			
			if(item.getQuantity()<cart.getOrder_quantity()) {
				// 상품 재고 수량 부족
				request.setAttribute("notice_msg", "[" + item.getName() + "] 재고 수량 부족으로 주문 불가");
				request.setAttribute("notice_url", request.getContextPath() + "/cart/list.do");
				return "/WEB-INF/views/common/alert_singleView.jsp";				
			}
			
			OrderDetailVO orderDetail = new OrderDetailVO();
			orderDetail.setItem_num(cart.getItem_num());
			orderDetail.setItem_name(cart.getItem().getName());
			orderDetail.setItem_price(cart.getItem().getPrice());
			orderDetail.setOrder_quantity(cart.getOrder_quantity());
			orderDetail.setItem_total(cart.getSub_total());
			
			orderDetailList.add(orderDetail);
		}
		
		// zorder에 저장할 데이터 생성
		OrderVO order = new OrderVO();
		order.setItem_name(item_name);
		order.setOrder_total(all_total);
		order.setPayment(Integer.parseInt(request.getParameter("payment")));
		order.setReceive_name(request.getParameter("receive_name"));
		order.setReceive_post(request.getParameter("receive_post"));
		order.setReceive_address1(request.getParameter("receive_address1"));
		order.setReceive_address2(request.getParameter("receive_address2"));
		order.setReceive_phone(request.getParameter("receive_phone"));
		order.setNotice(request.getParameter("notice"));
		order.setMem_num(user_num);
		
		// 주문 정보를 테이블에 저장
		OrderDAO orderDao = OrderDAO.getInstance();
		orderDao.insertOrder(order, orderDetailList);
		
		// refresh 정보를 응답 헤더에 저장
		response.addHeader("Refresh", "1;url=../main/main.do"); // 지정한 시간 이후에 지정한 URL로 이동
		request.setAttribute("accessMsg", "주문 작성이 완료되었습니다.");
		request.setAttribute("accessUrl", request.getContextPath() + "/main/main.do"); // notice.jsp의 버튼에 연결되는 URL
		
		// JSP 경로 반환
		return "/WEB-INF/views/common/notice.jsp";
	}

}