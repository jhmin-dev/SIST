package kr.spring.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextScan.xml");

		// @Component 어노테이션을 이용한 bean 객체 생성
		HomeController home = (HomeController)context.getBean("homeController");
		System.out.println(home);
		
		context.close();
	}
}