package kr.spring.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		// applicationContext.xml 설정 파일을 읽어들여 Spring Container 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 식별자를 이용해 객체를 컨테이너로부터 읽어옴
		MessageBean messageBean = (MessageBean)context.getBean("messageBean");
		messageBean.sayHello("초코");
		
		// 어플리케이션 종료시 컨테이너에 존재하는 모든 bean을 종료
		context.close();
	}
}