package kr.spring.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		// applicationContext.xml 설정 파일을 읽어들여 Spring Container를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 객체를 컨테이너로부터 읽어옴
		OperatorBean bean = (OperatorBean)context.getBean("operatorBean");
		int result = bean.add(10, 20);
		
		System.out.println("결과 : " + result);
		
		// 어플리케이션 종료시 컨테이너에 존재하는 모든 bean을 종료
		context.close();
	}
}