package kr.s01.a;
class Tv {
	// 멤버 변수(=속성)
	boolean power; // 전원 상태(on/off)
	int channel; // 현재 채널
	
	// 멤버 메서드(=동작)
	public void isPower() {
		power = !power; // power값이 true이면 false로, false이면 true로 토글
	}
	public void channelUp() {
		++channel; // 채널을 1 높임
	}
	public void channelDown() {
		--channel; // 채널을 1 낮춤
	}
}

public class TvMain {
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		Tv t = new Tv();
		// Tv를 실행
		t.isPower();
		System.out.println("Tv 실행 여부 : " + t.power);
		System.out.println("현재 채널 : " + t.channel);
		// 채널 변경
		t.channel = 7;
		System.out.println("첫 번째 변경된 채널 : " + t.channel);
		// 채널 변경
		t.channelDown();
		System.out.println("두 번째 변경된 채널 : " + t.channel);
		// Tv를 종료
		t.isPower();
		System.out.println("Tv 실행 여부 : " + t.power);
	}
}