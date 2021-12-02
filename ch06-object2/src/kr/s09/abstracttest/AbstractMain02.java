package kr.s09.abstracttest;
// 일반 클래스에서는 추상 메서드를 만들 수 없음
abstract class A2 {
	// 추상 메서드; 구현이 되지 않은 미완성 메서드
	public abstract void getA();
	// 일반 메서드; {} 블럭이 있으면 (수행문이 없더라도) 메서드가 구현된 것
	public void make() {
		System.out.println("make 메서드");
	}
}
// 추상 클래스를 상속받으면 추상 클래스가 가지고 있는 추상 메서드를 자식 클래스에 구현해야 함
class B2 extends A2 {
	// 재정의를 통해 부모 클래스의 미구현된 추상 메서드가 호출되지 않도록 함
	@Override public void getA() {
		System.out.println("getA 메서드");
	}
}

public class AbstractMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.getA();
		bp.make();
	}
}