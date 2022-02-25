package kr.spring.ch03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.ch03.service.ArticleService;
import kr.spring.ch03.vo.NewArticleVO;

@Controller
public class NewArticleController {
	@Autowired // 프로퍼티에 @Autowired 명시한 경우, setter는 명시하지 않아도 어노테이션에 의해 자동으로 생성됨
	private ArticleService articleService;
	
	// GET 방식으로 폼 호출
	// @RequestMapping(value = "/article/newArticle.do", method = RequestMethod.GET)
	@GetMapping("/article/newArticle.do") // Spring 4.3에 추가된 보다 간편한 어노테이션
	public String form() {
		return "article/newArticleForm"; // 데이터 없이 뷰만 반환하는 경우, 메서드 반환형을 String으로 지정하고 뷰 이름을 문자열로 반환하면 DispatcherServlet에서 처리
	}
	
	/*
	 * 1) 호출 메서드에 인자로 자바빈을 명시하면, 실행시 자바빈을 생성해서 request에 전달된 데이터의 파라미터명과 자바빈의 프로퍼티명을 대조해서 일치하면 데이터를 프로퍼티에 세팅
	 * 2) 호출 메서드에 인자로 자바빈을 명시하면, 자바빈의 클래스명 첫 글자를 소문자로 바꾼 이름을 속성명으로 사용하여 자바빈을 request 영역에 저장
	 * 3) @ModelAttribute 어노테이션을 이용해서 자바빈을 지정하면, 자바빈을 request 영역에 저장시 속성명을 지정 가능(지정하지 않으면 어노테이션 사용하지 않을 경우와 동일한 속성명 사용)
	 */
	
	// POST 방식으로 폼으로부터 데이터를 전달받음
	// @RequestMapping(value = "/article/newArticle.do", method = RequestMethod.POST)
	@PostMapping("/article/newArticle.do") // Spring 4.3에 추가된 보다 간편한 어노테이션
	public String submit(NewArticleVO vo) {
		articleService.writeArticle(vo);
		
		return "article/newArticleSubmitted";
	}
}