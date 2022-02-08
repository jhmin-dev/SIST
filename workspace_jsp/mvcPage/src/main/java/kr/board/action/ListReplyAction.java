package kr.board.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardReplyVO;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ListReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> mapAjax = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			mapAjax.put("result", "logout");
		}
		else { // 로그인되어 있는 경우		
			// 전송된 데이터 인코딩 처리
			request.setCharacterEncoding("UTF-8");
			
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null) pageNum = "1";
			
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			
			BoardDAO dao = BoardDAO.getInstance();
			int count = dao.getReplyBoardCount(board_num);
			
			/*
			 * ajax 방식으로 목록을 표시하기 때문에 PagingUtil은 페이지 수를 표시하는 것이 아니라 목록 데이터의 분할을 위한 ROWNUM 번호를 구하는 것이 목적
			 */
			int rowCount = 10;
			PagingUtil page = new PagingUtil(Integer.parseInt(pageNum), count, rowCount, 1, null);
			
			List<BoardReplyVO> list = null;
			if(count>0) {
				list = dao.getListReplyBoard(page.getStartCount(), page.getEndCount(), board_num);
			}
			else {
				list = Collections.emptyList(); // 데이터가 없는 경우 null 대신 비어 있는 리스트를 반환
			}
			
			mapAjax.put("result", "success");
			mapAjax.put("count", count);
			mapAjax.put("rowCount", rowCount);
			mapAjax.put("list", list);
		}
		
		// JSON 데이터로 반환
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		// JSP 경로 반환
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}