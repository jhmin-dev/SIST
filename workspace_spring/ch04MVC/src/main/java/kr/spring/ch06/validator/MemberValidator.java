package kr.spring.ch06.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch06.vo.MemberVO;

public class MemberValidator implements Validator {
	// Validator가 검증할 수 있는 타입인지(=자바빈 구조인지)를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { // Object는 자바빈의 부모 클래스, Errors는 BindingResult의 부모 인터페이스
		MemberVO memberVO = (MemberVO)target;
		if(memberVO.getId()==null || memberVO.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required"); // 에러가 발생한 자바빈의 프로퍼티명과 에러 코드를 인자로 전달
		}
		if(memberVO.getName()==null || memberVO.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if(memberVO.getZipcode()==null || memberVO.getZipcode().trim().isEmpty()) {
			errors.rejectValue("zipcode", "required");
		}
		if(memberVO.getAddress1()==null || memberVO.getAddress1().trim().isEmpty()) {
			errors.rejectValue("address1", "required");
		}
		if(memberVO.getAddress2()==null || memberVO.getAddress2().trim().isEmpty()) {
			errors.rejectValue("address2", "required");
		}
	}
}