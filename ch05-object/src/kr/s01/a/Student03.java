package kr.s01.a;
public class Student03 {
	// 필드
	// 멤버 변수
	String name;
	int korean;
	int english;
	int math;
	int sum;
	double avg;
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		Student03 student = new Student03();
		
		// 객체의 필드에 데이터를 저장
		student.name = "홍길동"; // .(dot) 연산자는 상위요소(객체)에서 하위요소(멤버 변수)로 접근할 때 사용
		student.korean = 98;
		student.english = 97;
		student.math = 95;
		student.sum = student.korean + student.english + student.math;
		student.avg = student.sum / 3.0;
		
		// 객체의 필드에 저장된 데이터 읽기
		System.out.println("이름 : " + student.name);
		System.out.println("국어 : " + student.korean);
		System.out.println("영어 : " + student.english);
		System.out.println("수학 : " + student.math);
		System.out.println("총점 : " + student.sum);
		System.out.printf("평균 : %.2f", student.avg);
	}
}