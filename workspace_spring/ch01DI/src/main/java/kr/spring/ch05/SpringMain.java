package kr.spring.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		// applicationContext.xml 설정 파일을 읽어 들여 Spring Container를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너에 DI 생성자 설정 방식으로 생성된 객체를 읽어옴
		MemberService memberService =  (MemberService)context.getBean("memberService");
		memberService.send();
		
		// 어플리케이션이 종료시 컨테이너에 존재하는 모든 bean을 종료
		context.close();
	}
}