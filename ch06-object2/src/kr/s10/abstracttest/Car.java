package kr.s10.abstracttest;
// �θ� Ŭ����; �߻� �޼��带 �����ϰ� �����Ƿ� �߻� Ŭ�������� ��
public abstract class Car {
	public void drive() {
		System.out.println("�޸���");
	}
	public void stop() {
		System.out.println("���ߴ�");
	}
	// �߻� �޼���; ������ �Ҹ��� �� �������� �ٸ��� �⺻���� �����Ƿ�, �θ� Ŭ������ ���� �����ϴ� ��� �ڽ� Ŭ������ ����(=�������̵�)�� ����
	public abstract int getEnergy();
}