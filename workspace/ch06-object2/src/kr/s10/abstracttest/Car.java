package kr.s10.abstracttest;
// 부모 클래스; 추상 메서드를 포함하고 있으므로 추상 클래스여야 함
public abstract class Car {
	public void drive() {
		System.out.println("달리다");
	}
	public void stop() {
		System.out.println("멈추다");
	}
	// 추상 메서드; 에너지 소모량은 차 종류마다 다르고 기본값이 없으므로, 부모 클래스가 값을 지정하는 대신 자식 클래스의 구현(=오버라이딩)을 강요
	public abstract int getEnergy();
}