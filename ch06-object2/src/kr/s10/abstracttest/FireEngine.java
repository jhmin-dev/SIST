package kr.s10.abstracttest;

public class FireEngine extends Car {
	// 상속받은 추상 메서드를 구현하지 않으면 오류 발생
	@Override public int getEnergy() {
		return 15;
	}
	public void getWater() {
		System.out.println("불을 끕니다.");
	}
}