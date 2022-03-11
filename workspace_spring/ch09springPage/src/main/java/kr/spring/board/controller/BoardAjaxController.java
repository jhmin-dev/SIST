package kr.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.board.service.BoardService;

@Controller
public class BoardAjaxController {
	private static final Logger logger = LoggerFactory.getLogger(BoardAjaxController.class);
	
	@Autowired
	private BoardService boardService;
	
	// 부모글 업로드된 파일 삭제
	@RequestMapping("/board/deleteFile.do")
	@ResponseBody
	public Map<String, String> processFile(int board_num, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) { // 로그인되어 있지 않은 경우
			map.put("result", "logout");
		}
		else {
			boardService.deleteFile(board_num);
			map.put("result", "success");
		}
		
		return map;
	}
}