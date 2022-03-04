package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// request에 데이터 저장
		request.setAttribute("msg", "내용을 수정했습니다.");
		
		// JSP 경로 반환
		return "views/update.jsp";
	}

}