package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 자바빈 객체 생성
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setTitle(request.getParameter("title"));
		vo.setName(request.getParameter("name"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setContent(request.getParameter("content"));
		vo.setIp(request.getRemoteAddr());
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO db_vo = dao.getBoard(vo.getNum());
		boolean check = false;
		if(db_vo!=null) {
			// 비밀번호 일치 여부 체크
			check = db_vo.isCheckedPassword(vo.getPasswd());
		}
		
		if(check) {
			dao.update(vo);
		}
		
		request.setAttribute("check", check); // 화면 제어에 이용하기 위해 request 영역에 check 값 저장
		
		// JSP 경로 반환
		return "/WEB-INF/views/modify.jsp";
	}

}