package kr.s11.inter;

interface Inter1 {
	// 추상 메서드
	public abstract int getA();	
}

interface Inter2 {
	// 추상 메서드
	public abstract int getB();
}

// Inter1과 Inter2가 Inter3에 상속; 인터페이스끼리는 상속이 가능하며, 다중 상속도 인정됨
interface Inter3 extends Inter1, Inter2 {
	// 추상 메서드
	public abstract int getData();
}

interface Inter4 {
	// 추상 메서드
	public abstract String getStr();
}

// 클래스에 Inter3과 Inter4를 구현; 한 클래스에 여러 인터페이스를 동시에 구현 가능
class InterSub implements Inter3, Inter4 {
	// Inter3의 추상 메서드 구현
	@Override public int getA() {
		return 10;
	}
	@Override public int getB() {
		return 20;
	}
	@Override public int getData() {
		return 30;
	}
	// Inter4의 추상 메서드 구현
	@Override public String getStr() {
		return "서울";
	}
}

public class InterMain03 {
	public static void main(String[] args) {
		InterSub is = new InterSub();
		System.out.println(is.getA());
		System.out.println(is.getB());
		System.out.println(is.getData());
		System.out.println(is.getStr());
	}
}