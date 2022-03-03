package kr.spring.ch11.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch11.vo.MemberVO;

@Controller
public class MemberWriteController {
	// 자바빈 초기화
	@ModelAttribute("vo")
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	// 폼 호출
	@GetMapping("/member/write.do")
	public String form() {
		return "member/write";
	}
	
	// 폼에서 전송된 데이터 처리
	@PostMapping("/member/write.do")
	public String submit(@ModelAttribute("vo") @Valid MemberVO memberVO, BindingResult result) {
		System.out.println("전송된 데이터 : " +  memberVO);
		
		// 전송된 데이터 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		return "redirect:/index.jsp";
	}
}