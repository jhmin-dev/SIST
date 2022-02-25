package kr.spring.ch08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		// DI 프로퍼티 설정 방식 : 여러 개의 프로퍼티 사용
		WorkController work = (WorkController)context.getBean("work");
		System.out.println(work);
		
		context.close();
	}
}