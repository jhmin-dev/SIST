package kr.s05.statictest;

class StaticMethod {
	String s1 = "스태틱";
	static String s2 = "static";
	
	public static String getString() { // static 메서드는 호출시 메모리에 올라감
		// return s1; // 인스턴스 변수는 객체를 생성하지 않으면 메모리에 올라가 있지 않음
		return s2; // static 변수는 호출시 메모리에 올라감; getString과 s2가 같은 클래스에 있어 호출시 클래스명 생략 가능
	}
}

public class StaticMain03 {
	public static void main(String[] args) {
		System.out.println(StaticMethod.getString()); // main의 클래스와 getString의 클래스가 같지 않으므로 클래스명을 명시해야 static 메서드에 접근 가능; static 변수와 static 메서드는 호출하면 바로 사용 가능함; String.valueOf() 역시 static 메서드
	}
}