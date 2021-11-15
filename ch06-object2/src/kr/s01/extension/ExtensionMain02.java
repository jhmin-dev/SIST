package kr.s01.extension;
// 부모 클래스
class People {
	public void eat() {
		System.out.println("식사하다.");
	}
}
// 자식 클래스
class Student extends People {
	public void study() {
		System.out.println("공부하다.");
	}
}

public class ExtensionMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat(); // People의 메서드를 상속받아 호출
		s.study(); // Student의 메서드를 호출
		System.out.println(s.toString()); // Object의 메서드를 (People을 통해) 상속받아 호출
		System.out.println(s); // 참조 변수만 쓸 경우 자동적으로 toString()을 호출
	}
}