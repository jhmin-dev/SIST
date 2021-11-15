package kr.s05.supertest;
// 부모 클래스
class People {
	int a = 100;
	public People() {
		super(); // 부모 클래스인 Object의 기본 생성자 호출을 먼저 수행하여 Object 영역을 만들고 자식 클래스인 People을 초기화; 부모 클래스의 기본 생성자는 생략해도 컴파일러에 의해 자동으로 포함됨
	}
}
// 자식 클래스
class Student extends People {
	int b = 200;
	public Student() {
		super(); // 부모 클래스인 People의 기본 생성자 호출을 먼저 수행하여 People 영역을 만들고 자식 클래스인 Student를 초기화
	}
}

public class SuperMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.a);
		System.out.println(s.b);
		System.out.println(s.toString());
	}
}