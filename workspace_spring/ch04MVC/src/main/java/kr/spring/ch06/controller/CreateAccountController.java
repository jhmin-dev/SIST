package kr.spring.ch06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch06.validator.MemberValidator;
import kr.spring.ch06.vo.MemberVO;

@Controller
public class CreateAccountController {
	// 자바빈 초기화; @ModelAttribute 어노테이션을 사용하면 해당 메서드에 의해 생성된 자바빈 객체를 request 영역에 저장
	@ModelAttribute("vo")
	public MemberVO initCommand() {
		return new MemberVO();
	}

	// 폼 호출
	@GetMapping("/account/create.do")
	public String form() {
		return "account/creationForm";
	}

	// 폼에서 전송된 데이터 처리
	@PostMapping("/account/create.do")
	public String submit(@ModelAttribute("vo") MemberVO memberVO, BindingResult result) { // @ModelAttribute에서 지정한 속성명이 account/created.jsp에 적용됨
		System.out.println("전송된 데이터 : " + memberVO);
		
		// 전송된 데이터 유효성 검증
		new MemberValidator().validate(memberVO, result);
		// BindingResult에 유효성 검증 결과 에러에 대한 내용이 저장되어 있으면 폼을 다시 호출
		if(result.hasErrors()) { // hasErrors() 메서드는 하나라도 에러 정보가 있으면 true
			return "account/creationForm";
		}
		
		return "account/created";
	}
}