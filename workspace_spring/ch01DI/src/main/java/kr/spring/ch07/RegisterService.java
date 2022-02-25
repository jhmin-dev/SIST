package kr.spring.ch07;

public class RegisterService {
	private RegisterDAO registerDAO;
	
	// 의존 관계 설정 방식 : 프로퍼티
	public void setRegisterDAO(RegisterDAO registerDAO) { // 생성자는 기본 생성자를 사용하고, setter 메서드를 통해 객체의 주소를 전달; 표준적인 setter 메서드 명명 방식을 준수하지 않으면 에러
		this.registerDAO = registerDAO; 
	}
	
	public void write() {
		System.out.println("RegisterService의 write() 메서드 실행");
		registerDAO.insert();
	}
}