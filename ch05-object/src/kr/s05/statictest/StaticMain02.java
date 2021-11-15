package kr.s05.statictest;

public class StaticMain02 {
	
	int a; // 인스턴스 변수
	static String s; // static(클래스) 변수
	
	public static void main(String[] args) { // 프로그램 실행시 main 메서드가 static 영역에 올라감
		// a = 10; // 인스턴스 변수는 객체 생성 이후에 호출
		s = "자바의 꿈"; // static 변수는 객체 생성과 무관하게 호출; main과 s가 같은 클래스에 있기 때문에 클래스명 생략해도 호출됨
		System.out.println("s = " + StaticMain02.s);
	}
}