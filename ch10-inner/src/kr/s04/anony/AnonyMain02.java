package kr.s04.anony;

class Inner7 {
	int y = 200;
	public void disp() {
		System.out.println("�θ� Ŭ������ disp �޼���");
	}
}

public class AnonyMain02 {
	// ��� �޼���
	public void fun() {
		// �͸� ���� Ŭ����; Ŭ������ �����ϴ� ���ÿ� (�θ� Ŭ������ �̸��� �ڷ����� ����) ��ü�� ����; ���� ���� Ŭ����ó�� (�޼��� ������ ��ü ���� �� ��� ȣ����� ��� ó���Ǿ�) Ŭ�������� (�޼��� ���� ���� �ְ� �޼��� �ۿ�����) ���ʿ��� ��쿡 ���
		Inner7 inner = new Inner7() { // �͸� ���� Ŭ������ Ŭ���� ��
			@Override public void disp() { // Inner7�� disp �޼��带 ������
				System.out.println("�ڽ� Ŭ������ disp �޼���");
			}
			public void make() { // �͸� ���� Ŭ������ ������ �޼��带 ȣ�� �Ұ��ϹǷ� ���ǹ�
				System.out.println("make �޼���");
			}
		}; // {} �������� �� �ٷ� �ν��ϸ� ;���� ������ ��
		// �͸� ���� Ŭ������ �޼��� ȣ��
		inner.disp();
		// inner.make(); // �ڷ����� Inner7�̱� ������ ȣ�� ������ �θ� Ŭ���� �������� ���ѵǾ� make �޼���� ȣ�� �Ұ�
	}
	
	public static void main(String[] args) {
		AnonyMain02 an = new AnonyMain02();
		an.fun();
	}
}