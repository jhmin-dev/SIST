package kr.s10.abstracttest;

public class Truck extends Car {
	// 상속받은 추상 메서드를 구현하지 않으면 오류 발생
	@Override public int getEnergy() {
		return 20;
	}
	public void getProduct() {
		System.out.println("상품을 적재합니다.");
	}
}