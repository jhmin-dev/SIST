package kr.spring.ch01;

import org.springframework.beans.factory.annotation.Required;

public class Camera {
	private int number;
	
	// @Required 어노테이션을 이용한 필수 프로퍼티 검사
	// 메서드에만 명시 가능하고 프로퍼티에는 명시 불가능
	@Required
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Camera [number=" + number + "]";
	}
}