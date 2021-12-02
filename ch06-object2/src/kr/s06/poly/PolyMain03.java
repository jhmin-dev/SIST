package kr.s06.poly;
// 부모 클래스
class Parent2 {
	public void make() {
		System.out.println("부모 클래스의 make 메서드");
	}
}
// 자식 클래스
class Child2 extends Parent2 {
	@Override public void make() {
		System.out.println("자식 클래스의 make 메서드");
	}
}

public class PolyMain03 {
	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make(); // 재정의된 메서드가 호출됨
		
		Parent2 p = ch; // 자동적으로 형변환
		p.make(); // 부모 클래스 타입으로 형변환해도 자식 클래스에 메서드가 재정의되어 있으면 재정의된 메서드가 호출됨; 형변환에 의해 호출 영역이 줄어들어도 재정의가 우선; 재정의 후 부모 클래스의 메서드를 호출하는 유일한 방법은 super.를 이용하는 것
	}
}