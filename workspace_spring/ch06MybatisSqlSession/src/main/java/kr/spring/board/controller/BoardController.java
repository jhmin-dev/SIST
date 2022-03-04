package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 로그 처리(로그 대상 지정)
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 목록
	@RequestMapping("/list.do")
	public ModelAndView getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardVO> list = null;
		
		list = boardService.getBoardList(map);
		
		ModelAndView mav = new ModelAndView();
		// view 이름 지정
		mav.setViewName("selectList");
		// 데이터 저장
		mav.addObject("list", list);
		
		return mav;
	}
}