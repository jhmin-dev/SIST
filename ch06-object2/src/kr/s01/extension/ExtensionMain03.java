package kr.s01.extension;
// �θ� Ŭ����
class A {
	int x = 100; // ���� �����ڸ� ������ default�� �����Ǹ�, ���� ��Ű�� ������ ȣ�� ����
	private int y = 200; // ���� Ŭ���� �������� ȣ�� �����ϵ��� ����ȭ
	
	public int getY() {
		return y;
	}
}
// �ڽ� Ŭ����
class B extends A {
	int z = 300;
}

public class ExtensionMain03 {
	public static void main(String[] args) {
		B bp = new B();
		System.out.println(bp.x);
		// System.out.println(bp.y); // private ��� ������ ��� ���踦 �ξ ���� Ŭ������ �ƴϱ� ������ ȣ�� �Ұ�
		System.out.println(bp.getY()); // �θ� Ŭ�������� public �޼��带 �����θ� ����ȭ�� y�� ���� �����ؼ� ���޹��� �� ����
		System.out.println(bp.z);
	}
}