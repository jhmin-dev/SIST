package kr.s11.inter;

interface A2 {
	// �߻� �޼���; �������̽��� ��ü ������ �Ұ��ϹǷ� �Ϲ� Ŭ�������� �����Ͽ� ���
	public abstract void getA(); // ����
	void getB(); // public abstract �����ص� ������� �����
}

// �������̽��� Ŭ������ ����
class B2 implements A2 {
	// �������̽��� �߻� �޼��带 ����; �������� ���� �߻� �޼��尡 ���� ��� ���� �߻�
	@Override public void getA() {
		System.out.println("getA �޼���");
	}
	@Override public void getB() {
		System.out.println("getB �޼���");
	}
}

public class InterMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.getA();
		bp.getB();
	}
}