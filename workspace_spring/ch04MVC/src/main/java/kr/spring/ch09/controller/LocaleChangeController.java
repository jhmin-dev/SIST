package kr.spring.ch09.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class LocaleChangeController {
	@Autowired
	private LocaleResolver localeResolver;
	
	@RequestMapping("/changeLanguage.do")
	public String change(@RequestParam("lang") String language, HttpServletRequest request, HttpServletResponse response) {
		Locale locale = new Locale(language);
		// 원하는 Locale 정보를 세팅; 브라우저가 열려 있는(=세션이 유지되는) 동안 세팅한 로케일이 유지됨
		localeResolver.setLocale(request, response, locale);
		return "redirect:/index.jsp";
	}
}