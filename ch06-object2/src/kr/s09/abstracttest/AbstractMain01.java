package kr.s09.abstracttest;
// 추상클래스; 미완성 개념으로 단독으로 객체 생성이 불가능하고, 일반적으로 자식 클래스에 상속되어 사용
abstract class A {
	private int x;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
}
// 추상클래스가 부모 클래스 역할을 수행
class B extends A {
	int b = 200;
}

public class AbstractMain01 {
	public static void main(String[] args) {
		// 추상클래스는 객체 생성이 불가능
		// A ap = new A();
		
		B bp = new B();
		bp.setX(100);
		System.out.println(bp.getX());
		System.out.println(bp.b);
	}
}