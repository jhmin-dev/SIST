package kr.s10.abstracttest;

public class CarMain {
	public static void main(String[] args) {
		// �߻� Ŭ������ ��ü ���� �Ұ���
		// Car car = new Car();
		
		Bus b = new Bus();
		b.drive();
		b.getPassenger();
		System.out.println("������ ���� �Ҹ� : " + b.getEnergy());
		
		Truck t = new Truck();
		t.drive();
		t.getProduct();
		System.out.println("Ʈ���� ���� �Ҹ� : " + t.getEnergy());
		
		FireEngine f = new FireEngine();
		f.stop();
		f.getWater();
		System.out.println("�ҹ����� ���� �Ҹ� : " + f.getEnergy());
	}
}