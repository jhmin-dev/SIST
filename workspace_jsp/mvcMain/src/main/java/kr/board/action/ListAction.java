package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// request에 데이터 저장
		request.setAttribute("message", "게시판 목록입니다.");
		
		// JSP 경로 반환
		return "/views/list.jsp";
	}
	
}