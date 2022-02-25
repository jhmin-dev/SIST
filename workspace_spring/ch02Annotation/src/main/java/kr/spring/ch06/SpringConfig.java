package kr.spring.ch06;

import javax.inject.Named;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드 기반 설정
@Configuration
public class SpringConfig {
	@Bean
	public Worker worker() {
		return new Worker();
	}
	
	/*
	 * 자바 코드 기반 설정에서는 bean 객체를 생성하는 메서드명이 bean의 식별자로 사용됨
	 * @Bean("식별자")처럼 @Bean 어노테이션에 bean의 식별자를 지정 가능
	 * @Named 어노테이션은 사용 불가
	 */
	@Bean
	public Executor executor2() {
		return new Executor();
	}
}