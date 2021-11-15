package kr.s01.member;

class Outer2 {
	// 멤버 변수
	private int x = 100;
	// 멤버 내부 클래스
	class Inner2 {
		private int y = 200;
		public void make() {
			System.out.println("x = " + x); // x와 Inner2가 모두 Outer2의 멤버로 인식되기 때문에 Outer2의 private 변수를 Inner2에서 바로 접근 가능; 웹에서는 거의 사용하지 않지만 안드로이드에서는 Getters, Setters 만드는 대신 내부 클래스를 사용하는 편
			System.out.println("y = " + y);
		}
	}
}

public class MemberMain02 {
	public static void main(String[] args) {
		Outer2 ot = new Outer2();
		Outer2.Inner2 oi = ot.new Inner2();
		oi.make();
	}
}