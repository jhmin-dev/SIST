package kr.s06.poly;
// �θ� Ŭ����
class Car {
	public void drive() {
		System.out.println("����");
	}
	public void stop() {
		System.out.println("����");
	}
	public void getPower() {
		System.out.println("�Ϲ� �ڵ���");
	}
}
// �ڽ� Ŭ����
class FireEngine extends Car {
	public void getWater() {
		System.out.println("�� �Ѹ���");
	}
	@Override
	public void getPower() {
		System.out.println("�ҹ� ���� ���� �ڵ���");
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
		
		Car ca = new FireEngine(); // �θ� Ŭ���� Ÿ������ FireEngine ��ü�� ����
		ca.drive();
		ca.stop();
		// ca.getWater(); // �޸𸮿��� ������� ������, Car Ÿ���̶� ȣ�� ������ ���ѵǾ� �־� ȣ�� �Ұ�
		ca.getPower(); // Car Ÿ���̶� �����ǵ� �޼���� FireEngine�� �޼��尡 ȣ���
	}
}