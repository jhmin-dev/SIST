package kr.s04.constructor;

public class CarMain03 {
	// ������ �����ε�
	public CarMain03(int n) {
		this(String.valueOf(n)); // ������ ������ �� �ٸ� �����ڸ� ȣ���� ���� �����ڸ��� �� �� ���� this�� ���; �����ڸ����� ȣ���ϴ� ���� ��ü �����ÿ�, new ������ �������� ����  
	}
	public CarMain03(float n) {
		// System.out.println("float ������ ��ȯ"); // ������ ������ �� �ٸ� �����ڸ� ȣ���ϱ� ���� ���๮�� ��ġ�ϸ� ���� �߻�; �ٸ� ������ ȣ���� �켱������ ó���ؾ� �� �߿��� �ʱ�ȭ �۾����� �����ϱ� ����
		this(String.valueOf(n));
		System.out.println("float ������ ��ȯ");
	}
	public CarMain03(String s) {
		System.out.println(s + "�� ���� : " + s.length());		
	}

	public static void main(String[] args) {
		CarMain03 cm1 = new CarMain03(2000); // �޼��忡�� �ߴ� ���ڿ��� ����� ���� ���ϴ� �۾��� ������ �� ������, ��ü �������� 1ȸ�� ���� ����
		CarMain03 cm2 = new CarMain03(3.141592f);
		CarMain03 cm3 = new CarMain03("Hello");
	}
}