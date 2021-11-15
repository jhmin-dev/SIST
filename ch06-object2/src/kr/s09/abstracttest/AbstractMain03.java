package kr.s09.abstracttest;
// 추상 클래스
abstract class AbsEx1 {
	// 필드
	int a = 100;
	int b = 200;
	final String STR = "abstract test"; // 문자열 상수
	// 일반 메서드
	public String getStr() {
		return STR;
	}
	// 추상 메서드
	abstract public int getA();
	public abstract int getB();
}
// 추상 클래스에 추상 클래스를 상속한 경우, 상속받은 추상 메서드를 구현하지 않아도 오류가 발생하지 않음
abstract class AbsEx2 extends AbsEx1 {
	// 필드
	String msg = "신세계";
	// 추상 메서드
	public abstract String getMsg();
	// 추상 메서드 구현
	@Override public int getA() {
		return a;
	}
}
// 일반 클래스에 추상 클래스를 상속한 경우, 상속받은 추상 메서드를 모두 구현해야 함
public class AbstractMain03 extends AbsEx2 {
	// 추상 메서드 구현
	@Override public int getB() {
		return b;
	}
	@Override public String getMsg() {
		return msg;
	}
	
	public static void main(String[] args) {
		AbstractMain03 ab = new AbstractMain03();
		System.out.println(ab.getA());
		System.out.println(ab.getB());
		System.out.println(ab.getStr());
		System.out.println(ab.getMsg());
	}
}