package kr.spring.ch03;

import org.springframework.beans.factory.annotation.Autowired;

public class SystemMonitor {
	/*
	 * @Autowired 어노테이션은 생성자, 필드, 메서드에 지정 가능하며, 타입을 이용해서 자동적으로 프로퍼티 값을 설정
	 * 해당 타입의 bean 객체가 존재하지 않거나 또는 bean 객체가 2개 이상 존재할 경우 Spring은 @Autowired 어노테이션이 적용된 bean 객체를 생성할 때 예외를 발생
	 * @Autowired(required=false)로 지정하면 해당 타입의 bean 객체가 존재하지 않더라도 Spring이 예외를 발생하지 않음(기본값은 true)
	 */
	// 필드에 @Autowired를 지정
	// @Autowired
	private SmsSender sender;

	// 생성자에 @Autowired를 지정
	/*
	@Autowired
	public SystemMonitor(SmsSender sender) {
		this.sender = sender;
	}
	*/
	
	// 메서드에 @Autowired를 지정
	@Autowired
	public void setSender(SmsSender sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "SystemMonitor [sender=" + sender + "]";
	}
}