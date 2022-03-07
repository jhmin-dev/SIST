package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("/product.do")
	public String process() {
		// Tiles 설정 호출
		return "product";
	}
}