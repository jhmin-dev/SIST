package kr.s10.abstracttest;

public class Bus extends Car {
	// ��ӹ��� �߻� �޼��带 �������� ������ ���� �߻�
	@Override public int getEnergy() {
		return 10;
	}
	public void getPassenger() {
		System.out.println("�����մϴ�.");
	}
}