package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class DetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// request에 데이터 저장
		request.setAttribute("detail", "게시판 상세 정보입니다.");
		
		// JSP 경로 반환
		return "views/detail.jsp";
	}
	
}