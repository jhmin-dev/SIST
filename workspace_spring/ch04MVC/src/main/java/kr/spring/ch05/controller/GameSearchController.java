package kr.spring.ch05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.ch05.service.SearchService;
import kr.spring.ch05.vo.SearchVO;

@Controller
public class GameSearchController {
	@Autowired
	private SearchService searchService; // @Autowired 어노테이션에 의해 setter 메서드는 자동으로 생성됨
	
	// 폼 호출
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	// 폼에서 전송된 데이터를 처리
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("vo") SearchVO vo) { // 인자로 받은 SearchVO는 @ModelAttribute 어노테이션에 의해 request에 저장됨
		// Service 호출
		String result = searchService.search(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("search/game");
		mav.addObject("searchResult", result);
		
		return mav;
	}
}