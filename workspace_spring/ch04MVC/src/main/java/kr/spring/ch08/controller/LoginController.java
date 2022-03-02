package kr.spring.ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch08.service.AuthCheckException;
import kr.spring.ch08.service.LoginService;
import kr.spring.ch08.validator.LoginValidator;
import kr.spring.ch08.vo.LoginVO;

@Controller
public class LoginController {
	// 의존 관계 주입
	@Autowired
	private LoginService loginService;
	
	// 자바빈 초기화
	@ModelAttribute
	public LoginVO initCommand() {
		return new LoginVO();
	}
	
	// 폼 호출
	@GetMapping("/login/login.do")
	public String form() {
		return "login/form";
	}
	
	// 폼에서 전송된 데이터 처리
	@PostMapping("/login/login.do")
	public String submit(LoginVO vo, BindingResult result) { // @ModelAttribute 어노테이션 사용하지 않으면 클래스명 첫 글자를 소문자로 변경한 속성명으로 request 영역에 저장
		System.out.println(vo);
		
		// 전송된 데이터 유효성 검증
		new LoginValidator().validate(vo, result);
		// 전송된 데이터 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		try {
			loginService.checkLogin(vo);
			// 아이디와 비밀번호가 일치하는 경우 리다이렉트 처리
			return "redirect:/index.jsp";
		}
		catch (AuthCheckException e) {
			// 필드가 없는 에러 메시지 처리
			result.reject("invalidIdOrPassword");
			// 아이디 또는 비밀번호가 불일치하는 경우 폼 호출
			return form();
		}
	}
}