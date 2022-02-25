package kr.spring.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	/*
	 * @RequestParam 어노테이션은 HTTP 요청 파라미터를 메서드의 인자로 전달하며, 파라미터명과 호출 메서드의 인자명이 같으면 어노테이션은 생략 가능
	 * 자료형 역시 인자의 자료형에 맞게 자동으로 형변환됨
	 * 
	 * @RequestParam 어노테이션은 required 속성의 기본값이 true라 파라미터를 전달하지 않으면 400 오류가 발생
	 * 해당 속성을 false로 설정하거나 또는 아예 어노테이션을 생략하면 파라미터 값이 없을 때 인자가 null로 처리되어 400 오류가 발생하지 않음
	 * 단, 인자의 자료형이 int 등 객체가 아닌 경우에는 null을 처리할 수 없어 500 오류가 발생하므로 defaultValue 속성에 값을 지정하는 방식을 사용해야 함
	 */
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(@RequestParam("query") String name, @RequestParam(value = "p", defaultValue = "1") int pageNumber) {
		System.out.println("name = " + name + ", p = " + pageNumber);
		
		return new ModelAndView("search/internal"); // 뷰만 반환시에는 ModelAndView 생성자에 뷰 이름을 전달
	}
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value = "query", required = false) String query, @RequestParam(value = "p", defaultValue = "1") int pageNumber) {
		System.out.println("query = " + query + ", p = " + pageNumber);
		
		return new ModelAndView("search/external");
	}
}