package kr.s07.finaltest;

public class FinalMain01 {
	// 멤버 상수; 객체가 살아 있는 동안 호출 가능
	final int NUM = 10;
	
	// static 상수; 호출하면 메모리에 올라가고, 같은 클래스의 모든 객체가 공유; 일반적으로 접근 제한자로 public을 사용
	public static final int NUMBER = 20;
	
	public static void main(String[] args) {
		// 지역적 상수; 호출된 메서드 블럭 종료시 사라짐
		final int NO = 30;
		System.out.println(NO);
		
		// 상수는 값 변경 불가
		// NO = 100;
		
		// 클래스 영역에 명시한 상수는 객체 생성 후 사용 가능
		// System.out.println(NUM);
		FinalMain01 fm = new FinalMain01();
		System.out.println(fm.NUM);
		
		// static 상수 호출
		System.out.println(NUMBER); // main과 NUMBER가 같은 클래스라 클래스명 생략 가능
	}
}