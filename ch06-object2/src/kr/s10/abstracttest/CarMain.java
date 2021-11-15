package kr.s10.abstracttest;

public class CarMain {
	public static void main(String[] args) {
		// 추상 클래스는 객체 생성 불가능
		// Car car = new Car();
		
		Bus b = new Bus();
		b.drive();
		b.getPassenger();
		System.out.println("버스의 연료 소모량 : " + b.getEnergy());
		
		Truck t = new Truck();
		t.drive();
		t.getProduct();
		System.out.println("트럭의 연료 소모량 : " + t.getEnergy());
		
		FireEngine f = new FireEngine();
		f.stop();
		f.getWater();
		System.out.println("소방차의 연료 소모량 : " + f.getEnergy());
	}
}