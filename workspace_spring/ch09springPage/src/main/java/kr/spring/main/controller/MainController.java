package kr.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main/main.do")
	public String main() {
		// Tiles 설정 반환
		return "main";
	}
}