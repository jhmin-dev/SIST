package kr.s10.abstracttest;

public class Truck extends Car {
	// ��ӹ��� �߻� �޼��带 �������� ������ ���� �߻�
	@Override public int getEnergy() {
		return 20;
	}
	public void getProduct() {
		System.out.println("��ǰ�� �����մϴ�.");
	}
}