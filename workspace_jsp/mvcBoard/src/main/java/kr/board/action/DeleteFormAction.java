package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class DeleteFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("num", Integer.parseInt(request.getParameter("num")));
		
		// JSP 경로 반환
		return "/WEB-INF/views/deleteForm.jsp";
	}

}