package kr.s02.local;

public class LocalMain01 {
	// ��� �޼���
	public void innerTest() {
		// ���� ���� Ŭ���� ����
		class Inner {
			public void getData() {
				System.out.println("Local ���� Ŭ����");
			}
		}
		// ���� ���� Ŭ������ ��ü ����
		Inner inner = new Inner();
		// ���� ���� Ŭ������ �޼��� ȣ��
		inner.getData();
	}
	
	public static void main(String[] args) {
		LocalMain01 local = new LocalMain01();
		local.innerTest();
	}	
}