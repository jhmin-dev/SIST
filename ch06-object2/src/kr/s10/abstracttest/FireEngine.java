package kr.s10.abstracttest;

public class FireEngine extends Car {
	// ��ӹ��� �߻� �޼��带 �������� ������ ���� �߻�
	@Override public int getEnergy() {
		return 15;
	}
	public void getWater() {
		System.out.println("���� ���ϴ�.");
	}
}