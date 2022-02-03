package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.FileUtil;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		// 로그인되어 있는 경우
		MultipartRequest multi = FileUtil.createFile(request); // 파일을 업로드하고 request에 담긴 정보를 MultipartRequest 객체로 전달
		BoardVO board = new BoardVO();
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setFilename(multi.getFilesystemName("filename"));
		board.setIp(request.getRemoteAddr());
		board.setMem_num(user_num);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(board);
		
		// JSP 경로 반환
		return "/WEB-INF/views/board/write.jsp";
	}

}