package kr.s01.list;

import java.util.ArrayList;

class A {
	// Object의 toString() 메서드를 재정의
	@Override public String toString() {
		return "클래스 A";
	}
}

class B {
	
}

public class ArrayListMain01 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		// 데이터 저장; 서로 다른 클래스 자료형의 객체들을 보관할 경우, 다시 데이터 읽어올 때 다운캐스팅이 번거로우므로 실제로는 같은 클래스의 객체들만 보관
		al.add(new A()); // A 객체의 주소를 Object로 업캐스팅하여 전달
		al.add(new B()); // B 객체의 주소를 Object로 업캐스팅하여 전달
		al.add(10); // 10을 감싼 Integer 객체의 주소를 Object로 업캐스팅하여 전달(자동 Boxing)
		al.add("하늘"); // 문자열 객체의 주소를 Object로 업캐스팅하여 전달
		System.out.println(al); // toString() 메서드가 리스트에 저장된 데이터(=객체 주소)의 목록으로 재정의되어 있음
	}
}