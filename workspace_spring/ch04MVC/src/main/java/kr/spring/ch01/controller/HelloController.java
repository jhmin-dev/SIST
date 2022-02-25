package kr.spring.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 어노테이션으로 클래스를 HandlerMapping에 등록
public class HelloController {
	// 요청 URL과 실행 메서드 연결
	@RequestMapping("/hello.do")
	public ModelAndView hello() { // 요청 매핑은 어노테이션으로 처리되기 때문에 메서드명은 자유롭게 지정 가능
		ModelAndView mav = new ModelAndView();
		// 뷰 이름 지정
		mav.setViewName("hello"); // JSP 파일명만 지정; servlet-context.xml에 설정된 prefix와 suffix를 조합하여 뷰의 전체 경로를 얻게 됨
		// 뷰에서 사용할 데이터 세팅
		mav.addObject("greeting", "안녕하세요"); // addOjbect() 메서드로 ModelAndView 객체에 속성명과 속성값을 저장하면 DispatcherServlet에 의해 해당 데이터가 request로 넘겨짐
		return mav; // DispatcherServlet에 ModelAndView 객체를 반환
	}
}