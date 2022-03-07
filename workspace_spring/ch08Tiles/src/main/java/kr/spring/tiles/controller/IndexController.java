package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String process() {
		// Tiles 설정을 호출; JSP 파일이 아니라 tilesdef.xml의 <definition> 태그 식별자를 반환
		return "index";
	}
}