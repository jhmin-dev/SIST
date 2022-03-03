package kr.spring.ch13.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.spring.ch13.vo.MemberVO;

/*
 * @RestController는 @ResponseBody와 @Controller 어노테이션의 조합
 * 일반적으로 REST 컨트롤러를 생성할 때 사용
 */

@RestController
public class RestMainController {
	@RequestMapping("/member") // REST 스타일에서는 요청 URL에 확장자를 사용하지 않음
	public MemberVO getMember() { // 잭슨 라이브러리 사용시 메서드가 반환한 List나 Map, 자바빈 객체를 JSON 문자열로 변환
		MemberVO vo = new MemberVO();
		vo.setId("test");
		vo.setName("실험");
		
		return vo;
	}
	
	/*
	 * @PathVariable 어노테이션은 URL에 포함된 값을 처리하기 위해 사용
	 * {id}는 값이 변수임을 의미하며, @PathVariable은 URL의 변수 {id}의 값이 메서드 인자 id에 바인딩되도록 함
	 */
	@RequestMapping("/member/id/{id}/name/{name}")
	public MemberVO getMember2(@PathVariable String id, @PathVariable String name) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		
		return vo;
	}
}