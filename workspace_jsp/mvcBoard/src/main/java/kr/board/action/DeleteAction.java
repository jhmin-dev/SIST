package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO db_vo = dao.getBoard(num);
		boolean check = false;
		if(db_vo!=null) {
			// 비밀번호 일치 여부 체크
			check = db_vo.isCheckedPassword(passwd);
		}

		if(check) {
			dao.delete(num);
		}
		
		request.setAttribute("check", check); // UI를 처리하기 위해 request 영역에 check 값 저장
		
		// JSP 경로 반환
		return "/WEB-INF/views/delete.jsp";
	}

}