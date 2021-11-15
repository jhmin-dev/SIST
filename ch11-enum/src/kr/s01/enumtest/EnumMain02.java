package kr.s01.enumtest;
// 열거형 상수
enum Lesson {
	JAVA, JSP, SERVLET // 변수명을 식별자 및 값으로 사용하는 열거 객체 생성
}

public class EnumMain02 {
	public static void main(String[] args) {
		System.out.println(Lesson.JAVA);
		System.out.println(Lesson.JSP);
		System.out.println(Lesson.SERVLET);
		
		// name() 메서드로 열거 객체의 문자열 반환
		System.out.println(Lesson.JAVA.name());
		System.out.println(Lesson.JSP.name());
		System.out.println(Lesson.SERVLET.name());
		
		// ordinal() 메서드로 열거 객체의 순번 반환
		System.out.println(Lesson.JAVA.ordinal()); // 순번은 0부터 시작
		System.out.println(Lesson.JSP.ordinal());
		System.out.println(Lesson.SERVLET.ordinal());
	}
}