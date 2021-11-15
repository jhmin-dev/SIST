package kr.s02.local;

public class LocalMain02 {
	// ��� ����
	int a = 100;
	// ��� �޼���
	public void innerTest() {
		// ���� ���� Ŭ���� ����
		class Inner {
			public void getData() {
				System.out.println("���� �� : " + a); // ���� ���� Ŭ�������� �ܺ� Ŭ������ ��� ���� �� ȣ�� ����
				a = 200; // ���� ���� Ŭ�������� �ܺ� Ŭ������ ��� ���� �� ���� ����
				System.out.println("���� �� : " + a);
			}
		}
		// ���� ���� Ŭ������ ��ü ����
		Inner inner = new Inner();
		// ���� ���� Ŭ������ �޼��� ȣ��
		inner.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 local = new LocalMain02();
		local.innerTest();
	}
}
