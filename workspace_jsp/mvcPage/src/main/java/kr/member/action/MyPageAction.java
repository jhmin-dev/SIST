package kr.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;

public class MyPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			return "redirect:/member/loginForm.do"; // 클라이언트가 호출 가능한 영역(*.do 형식)은 redirect로 처리
		}
		
		// 로그인되어 있는 경우
		// 회원 정보
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.getMember(user_num);
		
		// 구매 상품 정보
		OrderDAO orderDao = OrderDAO.getInstance(); 
		List<OrderVO> orderList = orderDao.getOrderByMem_num(1, 5, null, null, user_num);
		
		request.setAttribute("member", member);
		request.setAttribute("orderList", orderList);
		
		// JSP 경로 반환
		return "/WEB-INF/views/member/myPage.jsp"; // 클라이언트가 호출 불가한 영역(WEB-INF 폴더 하위의 JSP 파일들)은 forward로 처리
	}

}