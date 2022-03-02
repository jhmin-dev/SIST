package kr.spring.ch08.service;

import kr.spring.ch08.vo.LoginVO;

public class LoginService {
	public void checkLogin(LoginVO loginVO) throws AuthCheckException {
		// 테스트 목적으로 userId와 password가 일치하면 로그인된 것으로 처리
		if(!loginVO.getUserId().contentEquals(loginVO.getPassword())) {
			System.out.println("인증 에러 : " +  loginVO.getUserId());
			throw new AuthCheckException(); // 메서드 선언부에 throws를 추가하거나 try~catch문으로 감싸야 함
		}
	}
}