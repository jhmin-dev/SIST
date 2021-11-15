package kr.s01.extension;
// 부모 클래스
class Parent extends Object { // 기본적으로 생략되며, 자바의 모든 클래스는 자동적으로 Object가 상속됨
	int a = 100;
}
// 자식 클래스
class Child extends Parent {

}

public class ExtensionMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a); // 상속 관계를 맺으면 부모 클래스의 자원을 자식 클래스에서 가져다 쓸 수 있음
	}
}