package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// request에 데이터 저장
		request.setAttribute("result", "전송된 데이터를 저장했습니다.");
		
		// JSP 경로 반환
		return "views/write.jsp";
	}
	
}