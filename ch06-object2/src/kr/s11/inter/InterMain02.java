package kr.s11.inter;

interface A2 {
	// 추상 메서드; 인터페이스는 객체 생성이 불가하므로 일반 클래스에서 구현하여 사용
	public abstract void getA(); // 원형
	void getB(); // public abstract 생략해도 원형대로 선언됨
}

// 인터페이스를 클래스에 구현
class B2 implements A2 {
	// 인터페이스의 추상 메서드를 구현; 구현되지 않은 추상 메서드가 있을 경우 오류 발생
	@Override public void getA() {
		System.out.println("getA 메서드");
	}
	@Override public void getB() {
		System.out.println("getB 메서드");
	}
}

public class InterMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.getA();
		bp.getB();
	}
}