package kr.spring.ch06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		// 자바 코드 기반 설정
		// 설정 정보를 가지고 있는 클래스를 읽어들여 컨테이너를 생성
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Executor executor = (Executor)context.getBean("executor2");
		executor.addUnit();
		
		context.close();
	}
}