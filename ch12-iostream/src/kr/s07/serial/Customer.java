package kr.s07.serial;

import java.io.Serializable;

public class Customer implements Serializable { // Serializable 인터페이스를 구현하면 해당 클래스는 객체 직렬화 대상이 되어 객체 직렬화를 수행 가능; Serializable이 구현되지 않으면 객체 직렬화 불가; Serializable 인터페이스는 비어 있는 인터페이스로, 구현해야 할 별도의 추상 메서드 가지고 있지 않음; 데이터가 들어간 멤버 변수만 직렬화 대상
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
