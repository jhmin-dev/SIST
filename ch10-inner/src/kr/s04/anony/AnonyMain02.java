package kr.s04.anony;

class Inner7 {
	int y = 200;
	public void disp() {
		System.out.println("부모 클래스의 disp 메서드");
	}
}

public class AnonyMain02 {
	// 멤버 메서드
	public void fun() {
		// 익명 내부 클래스; 클래스를 정의하는 동시에 (부모 클래스의 이름과 자료형을 빌려) 객체를 생성; 로컬 내부 클래스처럼 (메서드 내에서 객체 생성 및 멤버 호출까지 모두 처리되어) 클래스명이 (메서드 내에 갇혀 있고 메서드 밖에서는) 불필요한 경우에 사용
		Inner7 inner = new Inner7() { // 익명 내부 클래스의 클래스 블럭
			@Override public void disp() { // Inner7의 disp 메서드를 재정의
				System.out.println("자식 클래스의 disp 메서드");
			}
			public void make() { // 익명 내부 클래스는 정의한 메서드를 호출 불가하므로 무의미
				System.out.println("make 메서드");
			}
		}; // {} 블럭까지를 한 줄로 인식하며 ;으로 끝내야 함
		// 익명 내부 클래스의 메서드 호출
		inner.disp();
		// inner.make(); // 자료형이 Inner7이기 때문에 호출 범위가 부모 클래스 영역으로 제한되어 make 메서드는 호출 불가
	}
	
	public static void main(String[] args) {
		AnonyMain02 an = new AnonyMain02();
		an.fun();
	}
}