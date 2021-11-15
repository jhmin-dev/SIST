package kr.s05.supertest;
// 부모 클래스
class People2 {
	int a;
	// 부모 클래스에 기본 생성자가 없고 인자가 있는 생성자만 정의된 상태이기 때문에 자식 클래스에서 객체를 생성할 때는 명시적으로 부모 클래스의 인자가 있는 생성자를 호출해야 객체 생성이 가능함
	public People2(int a) {
		this.a = a;
	}
}
// 자식 클래스
class Student2 extends People2 { // 생성자를 명시하지 않을 경우, 부모 클래스에 기본 생성자가 없기 때문에 오류 발생
	public Student2() {
		super(100); // 부모 클래스의 인자 자료형이 int인 생성자를 호출 
	}
}

public class SuperMain03 {
	public static void main(String[] args) {
		
	}
}