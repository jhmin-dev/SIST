package kr.s02.local;

public class LocalMain02 {
	// 멤버 변수
	int a = 100;
	// 멤버 메서드
	public void innerTest() {
		// 로컬 내부 클래스 정의
		class Inner {
			public void getData() {
				System.out.println("변경 전 : " + a); // 로컬 내부 클래스에서 외부 클래스의 멤버 변수 값 호출 가능
				a = 200; // 로컬 내부 클래스에서 외부 클래스의 멤버 변수 값 변경 가능
				System.out.println("변경 후 : " + a);
			}
		}
		// 로컬 내부 클래스의 객체 생성
		Inner inner = new Inner();
		// 로컬 내부 클래스의 메서드 호출
		inner.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 local = new LocalMain02();
		local.innerTest();
	}
}
