package kr.s01.a;
public class Student02 {
	// 필드
	// 멤버 변수
	String name;
	int age;
	String hobby;
	
	public static void main(String[] args) {
		// 객체의 선언 및 생성
		Student02 student = new Student02();
		
		student.name = "홍길동";
		student.age = 20;
		student.hobby = "축구";
		
		System.out.println(student.name + ", " + student.age + ", " + student.hobby);
		
		// 객체는 무한히 생성 가능함; 하나의 설계도면으로 주소(와 저장된 데이터)가 다른 여러 건물을 짓는 것
		Student02 student2 = new Student02();
		
		student2.name = "박문수";
		student2.age = 45;
		student2.hobby = "야구";
		
		System.out.println(student2.name + ", " + student2.age + ", " + student2.hobby);	
	}
}