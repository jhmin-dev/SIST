package kr.spring.ch04.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) { // 메서드가 구동될 때 인자의 자료형을 확인하여 일치하는 객체가 있으면 전달; HttpServletResponse 객체는 이미 생성되어 있으므로 전달됨
		// 쿠키를 생성해서 클라이언트에 전송
		response.addCookie(new Cookie("auth", "1"));
		
		return "cookie/make";
	}
	
	/*
	 * @CookieValue 어노테이션을 이용하면 쿠키 값을 메서드 인자로 전달받을 수 있음
	 * 해당 쿠키가 존재하지 않으면 기본적으로 400 오류가 발생
	 * @CookieValue(value = "쿠키 이름", required = false)로 지정시, 쿠키가 존재하지 않으면 인자에 null 값을 전달
	 * @CookieValue(value = "쿠키 이름", defaultValue = "값")로 지정시, 쿠키가 존재하지 않으면 인자에 defaultValue에 지정했던 값을 전달
	 */
	
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value = "auth", defaultValue = "0") String auth) {
		System.out.println("auth 쿠키 : " + auth);
		
		return "cookie/view";
	}
}