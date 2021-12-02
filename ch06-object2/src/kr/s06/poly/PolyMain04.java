package kr.s06.poly;
// 부모 클래스
class Car {
	public void drive() {
		System.out.println("주행");
	}
	public void stop() {
		System.out.println("멈춤");
	}
	public void getPower() {
		System.out.println("일반 자동차");
	}
}
// 자식 클래스
class FireEngine extends Car {
	public void getWater() {
		System.out.println("물 뿌리기");
	}
	@Override
	public void getPower() {
		System.out.println("소방 설비를 갖춘 자동차");
	}
}

public class PolyMain04 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.drive();
		fe.stop();
		fe.getWater();
		fe.getPower();
		
		System.out.println();
		
		Car ca = new FireEngine(); // 부모 클래스 타입으로 FireEngine 객체를 생성
		ca.drive();
		ca.stop();
		// ca.getWater(); // 메모리에는 만들어져 있지만, Car 타입이라 호출 범위가 제한되어 있어 호출 불가
		ca.getPower(); // Car 타입이라도 재정의된 메서드는 FireEngine의 메서드가 호출됨
	}
}