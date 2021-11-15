package kr.s01.member;

class Outer3 {
	// 멤버 변수
	int value = 10;
	// 멤버 내부 클래스	
	class Inner3 {
		int value = 20;
		public void method1() {
			int value = 30;
			System.out.println("지역 변수 value : " + value);
			System.out.println("Inner3의 멤버 변수 value : " + this.value);
			System.out.println("Outer3의 멤버 변수 value : " + Outer3.this.value);
		}
	}
}

public class MemberMain03 {
	public static void main(String[] args) {
		Outer3.Inner3 oi = new Outer3().new Inner3(); // 감싸고 있는 클래스의 객체를 호출할 일이 없다면 Outer3 참조 변수를 만들지 않아도 됨
		oi.method1();
	}
}