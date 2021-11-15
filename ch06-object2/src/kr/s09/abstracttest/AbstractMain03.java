package kr.s09.abstracttest;
// �߻� Ŭ����
abstract class AbsEx1 {
	// �ʵ�
	int a = 100;
	int b = 200;
	final String STR = "abstract test"; // ���ڿ� ���
	// �Ϲ� �޼���
	public String getStr() {
		return STR;
	}
	// �߻� �޼���
	abstract public int getA();
	public abstract int getB();
}
// �߻� Ŭ������ �߻� Ŭ������ ����� ���, ��ӹ��� �߻� �޼��带 �������� �ʾƵ� ������ �߻����� ����
abstract class AbsEx2 extends AbsEx1 {
	// �ʵ�
	String msg = "�ż���";
	// �߻� �޼���
	public abstract String getMsg();
	// �߻� �޼��� ����
	@Override public int getA() {
		return a;
	}
}
// �Ϲ� Ŭ������ �߻� Ŭ������ ����� ���, ��ӹ��� �߻� �޼��带 ��� �����ؾ� ��
public class AbstractMain03 extends AbsEx2 {
	// �߻� �޼��� ����
	@Override public int getB() {
		return b;
	}
	@Override public String getMsg() {
		return msg;
	}
	
	public static void main(String[] args) {
		AbstractMain03 ab = new AbstractMain03();
		System.out.println(ab.getA());
		System.out.println(ab.getB());
		System.out.println(ab.getStr());
		System.out.println(ab.getMsg());
	}
}