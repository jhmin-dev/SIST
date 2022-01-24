package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// request에 데이터 저장
		request.setAttribute("result", "삭제를 완료했습니다.");
		
		// JSP 경로 반환
		return "views/delete.jsp";
	}

}