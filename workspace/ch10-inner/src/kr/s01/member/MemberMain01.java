package kr.s01.member;

class Outer {
	// 멤버 변수
	int x = 100;
	// 멤버 내부 클래스
	class Inner {
		int y = 200;
	}
}

public class MemberMain01 {
	public static void main(String[] args) {
		Outer ot = new Outer();
		System.out.println(ot);
		System.out.println("x = " + ot.x);
		
		System.out.println();
		
		// 멤버 내부 클래스의 자료형은 .으로 감싸고 있는 클래스를 함께 명시해야 하며, 객체 생성은 감싸고 있는 클래스의 객체에 .으로 접근 후 new와 생성자 사용
		Outer.Inner oi = ot.new Inner();
		System.out.println(oi);
		System.out.println("y = " + oi.y);	
	}
}