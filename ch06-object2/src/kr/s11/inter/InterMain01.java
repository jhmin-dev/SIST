package kr.s11.inter;

interface A1 {
	// 상수; 인터페이스는 생성자가 없으므로 객체 생성이 불가능하고, 상수는 각자 호출시 메모리에 올라감
	public static final int W = 10; // 원형
	int X = 20; // public static final 생략해도 원형대로 선언됨
	static int Y = 30; // public final 생략해도 원형대로 선언됨
	final int Z = 40; // public static 생략해도 원형대로 선언됨
}

public class InterMain01 {
	public static void main(String[] args) {
		// 인터페이스는 객체 생성 불가
		// A1 ap = new A1();
		
		// static 상수이므로 인터페이스명.상수명 형식으로 호출함
		System.out.println("W = " + A1.W);
		System.out.println("X = " + A1.X);
		System.out.println("Y = " + A1.Y);
		System.out.println("Z = " + A1.Z);
	}
}