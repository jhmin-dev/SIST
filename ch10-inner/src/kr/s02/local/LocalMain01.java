package kr.s02.local;

public class LocalMain01 {
	// 멤버 메서드
	public void innerTest() {
		// 로컬 내부 클래스 정의
		class Inner {
			public void getData() {
				System.out.println("Local 내부 클래스");
			}
		}
		// 로컬 내부 클래스의 객체 생성
		Inner inner = new Inner();
		// 로컬 내부 클래스의 메서드 호출
		inner.getData();
	}
	
	public static void main(String[] args) {
		LocalMain01 local = new LocalMain01();
		local.innerTest();
	}	
}