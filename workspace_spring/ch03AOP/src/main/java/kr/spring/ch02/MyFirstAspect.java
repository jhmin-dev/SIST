package kr.spring.ch02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyFirstAspect {
	// 공통 기능 수행
	/*
	 * 구현 가능한 Advice(언제 공통 기능을 핵심 기능에 적용할지를 정의)
	 * 종류						설명
	 * Before Advice			대상 객체의 메서드 호출 전에 공통 기능을 실행
	 * @Before
	 * After Returning Advice	대상 객체의 메서드가 예외 없이 실행한 이후에 공통 기능을 실행
	 * @AfterReturning
	 * After Throwing Advice	대상 객체의 메서드를 실행하는 도중 예외가 발생한 경우에 공통 기능을 실행
	 * @AfterThrowing
	 * After Advice				대상 객체의 메서드를 실행하는 도중 예외가 발생했는지의 여부와 상관없이 메서드 실행 후 공통 기능을 실행(try~catch~finally의 finally 블럭과 비슷)
	 * @After
	 * Around Advice			대상 객체의 메서드 실행 전, 후 또는 예외 발생 시점에 공통 기능을 실행하는 데 사용(전, 후에 다른 공통 기능 배치 가능)
	 * @Around
	 */
	@Pointcut("execution(public String launch())")
	public void getPointcut() {
		
	}
	
	// @Before("getPointcut()")
	public void before() {
		// 메서드 시작 직전에 동작하는 어드바이스
		System.out.println("Hello Before! **메서드가 호출되기 전에 나온다!");
	}
	
	// @AfterReturning(value = "getPointcut()", returning = "msg")
	public void afterReturning(String msg) {
		// 메서드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스
		System.out.println("Hello AfterReturning! **메서드가 호출한 후에 나온다! 전달된 객체 : " + msg);
	}
	
	// @AfterThrowing(value = "getPointcut()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		// 메서드 호출이 예외를 던졌을 때 동작하는 어드바이스
		System.out.println("Hello AfterThrowing! **예외가 생기면 나온다! 예외 : " + ex);
	}
	
	// @After("getPointcut()")
	public void after() {
		// 예외가 발생해도 실행됨
		// 메서드 종료 후에 동작하는 어드바이스
		System.out.println("Hello After! **메서드가 호출된 후에 나온다!");
	}
	
	@Around("getPointcut()")
	public String around(ProceedingJoinPoint joinpoint) throws Throwable {
		// 메서드 호출 전후에 동작하는 어드바이스
		System.out.println("Hello Around before! **메서드가 호출되기 전에 나온다!");
		String s = null;
		// try~catch~finally 구조로 명시해야 예외가 발생해도 메서드 실행 후 공통 기능을 수행함
		try {
			// 핵심 기능이 수행된 후 데이터 반환
			s = (String)joinpoint.proceed();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Hello Around after! **메서드가 호출된 후에 나온다! 반환된 객체 : " + s);
		}
		
		return s;
	}
}