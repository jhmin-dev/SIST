package kr.spring.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnote.xml");
		
		// 핵심 기능 실행, 설정 파일에 지정한 설정대로 공통 기능이 수행됨
		Product p = (Product)context.getBean("product");
		p.launch();
		
		context.close();
	}
}