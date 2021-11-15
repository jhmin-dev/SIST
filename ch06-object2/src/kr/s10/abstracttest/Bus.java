package kr.s10.abstracttest;

public class Bus extends Car {
	// 상속받은 추상 메서드를 구현하지 않으면 오류 발생
	@Override public int getEnergy() {
		return 10;
	}
	public void getPassenger() {
		System.out.println("승차합니다.");
	}
}