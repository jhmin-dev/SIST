package kr.s09.abstracttest;
// �Ϲ� Ŭ���������� �߻� �޼��带 ���� �� ����
abstract class A2 {
	// �߻� �޼���; ������ ���� ���� �̿ϼ� �޼���
	public abstract void getA();
	// �Ϲ� �޼���; {} ���� ������ (���๮�� ������) �޼��尡 ������ ��
	public void make() {
		System.out.println("make �޼���");
	}
}
// �߻� Ŭ������ ��ӹ����� �߻� Ŭ������ ������ �ִ� �߻� �޼��带 �ڽ� Ŭ������ �����ؾ� ��
class B2 extends A2 {
	// �����Ǹ� ���� �θ� Ŭ������ �̱����� �߻� �޼��尡 ȣ����� �ʵ��� ��
	@Override public void getA() {
		System.out.println("getA �޼���");
	}
}

public class AbstractMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.getA();
		bp.make();
	}
}