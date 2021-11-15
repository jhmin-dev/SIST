package kr.s02.local;

public class LocalMain03 {
	// 멤버 변수
	int a = 100;
	// 멤버 메서드
	public void innerTest() {
		// 지역 변수
		int b = 200;
		// 로컬 내부 클래스 정의
		class Inner {
			public void getData() {
				System.out.println("a : " + a); // LocalMain03의 멤버 변수 값 호출
				System.out.println("b : " + b); // innerTest의 지역 변수 값 호출
				// b = 400; // 메서드 내의 지역 변수가 로컬 내부 클래스에서 호출될 때 자동으로 상수화(=final 지정)되기 때문에 값 변경 불가; JDK 7 이하의 버전에서는 지역 변수 선언시에 final로 지정해야 로컬 내부 클래스에서 값 호출 가능	
			}
		}
		// 로컬 내부 클래스의 객체 생성
		Inner inner = new Inner();
		// 로컬 내부 클래스의 메서드 호출
		inner.getData();
	}
	
	public static void main(String[] args) {
		LocalMain03 local = new LocalMain03();
		local.innerTest();
	}
}