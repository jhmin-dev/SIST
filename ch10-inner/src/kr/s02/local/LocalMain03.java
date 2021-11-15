package kr.s02.local;

public class LocalMain03 {
	// ��� ����
	int a = 100;
	// ��� �޼���
	public void innerTest() {
		// ���� ����
		int b = 200;
		// ���� ���� Ŭ���� ����
		class Inner {
			public void getData() {
				System.out.println("a : " + a); // LocalMain03�� ��� ���� �� ȣ��
				System.out.println("b : " + b); // innerTest�� ���� ���� �� ȣ��
				// b = 400; // �޼��� ���� ���� ������ ���� ���� Ŭ�������� ȣ��� �� �ڵ����� ���ȭ(=final ����)�Ǳ� ������ �� ���� �Ұ�; JDK 7 ������ ���������� ���� ���� ����ÿ� final�� �����ؾ� ���� ���� Ŭ�������� �� ȣ�� ����	
			}
		}
		// ���� ���� Ŭ������ ��ü ����
		Inner inner = new Inner();
		// ���� ���� Ŭ������ �޼��� ȣ��
		inner.getData();
	}
	
	public static void main(String[] args) {
		LocalMain03 local = new LocalMain03();
		local.innerTest();
	}
}