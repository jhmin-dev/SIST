package kr.s01.a;
public class Student {
	
	// 필드
	String name;
	int age;
	
	public static void main(String[] args) {
		// 객체 선언; 자료형을 클래스명으로 사용하여 변수를 선언
		Student s;
		
		// 객체 생성; 메모리에 객체를 생성하고 객체의 주소를 s에 저장; 객체에는 멤버 변수 name과 age가 포함됨
		s = new Student(); // new 연산자는 객체를 생성하는 역할; 자바에서는 배열 역시 객체로 취급되어 new 연산자로 생성
		
		// 객체의 필드에 데이터를 저장
		s.name = "홍길동";
		s.age = 20;
		
		// 객체의 필드에 저장된 데이터 읽기
		System.out.println(s.name + ", " + s.age);
	}
}