package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.FileUtil;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		// 로그인되어 있는 경우
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO db_board = dao.getBoard(board_num);
		if(user_num!=db_board.getMem_num()) { // 로그인한 회원 번호와 작성자 회원 번호가 일치하지 않는 경우
			return "/WEB-INF/views/common/notice.jsp";
		}
		
		// 로그인한 회원 번호와 작성자 회원 번호가 일치하는 경우
		// 글 삭제
		dao.deleteBoard(board_num);
		
		// 파일 삭제
		FileUtil.removeFile(request, db_board.getFilename());
		
		// JSP 경로 반환
		return "redirect:/board/list.do";
	}

}