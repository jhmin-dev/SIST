package kr.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.vo.BoardVO;

@Controller // @Controller, @Service, @Repository는 @Component가 확장된 어노테이션이라 자동 스캔 설정했을 때 별도로 @Component 어노테이션 추가할 필요 없음
public class BoardController {
	// 자바빈 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	// 글쓰기 폼 호출
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}

	// 글쓰기 폼에서 전송된 데이터 처리
	@PostMapping("/insert.do")
	public String submit(BoardVO boardVO, BindingResult result) {
		
		return "redirect:/list.do";
	}

	@RequestMapping("/list.do")
	public ModelAndView process() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		
		return mav;
	}
}