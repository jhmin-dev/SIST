package kr.s06.poly;
// �θ� Ŭ����
class Parent2 {
	public void make() {
		System.out.println("�θ� Ŭ������ make �޼���");
	}
}
// �ڽ� Ŭ����
class Child2 extends Parent2 {
	@Override public void make() {
		System.out.println("�ڽ� Ŭ������ make �޼���");
	}
}

public class PolyMain03 {
	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make(); // �����ǵ� �޼��尡 ȣ���
		
		Parent2 p = ch; // �ڵ������� ����ȯ
		p.make(); // �θ� Ŭ���� Ÿ������ ����ȯ�ص� �ڽ� Ŭ������ �޼��尡 �����ǵǾ� ������ �����ǵ� �޼��尡 ȣ���; ����ȯ�� ���� ȣ�� ������ �پ�� �����ǰ� �켱; ������ �� �θ� Ŭ������ �޼��带 ȣ���ϴ� ������ ����� super.�� �̿��ϴ� ��
	}
}