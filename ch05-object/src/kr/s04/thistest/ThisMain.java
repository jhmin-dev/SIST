package kr.s04.thistest;

public class ThisMain {
	public ThisMain() {
		System.out.println("��ü ���� : " + this); // this�� ��ü ������ ���� ���� ����; ��ü�� �������� ������ ������ ��ü ���ο��� ��ü�� ��Ī�� �� ���
	}
	
	public static void main(String[] args) {
		ThisMain tt = new ThisMain(); // ������ ��ü �ּ��� ����ũ�� �������� ���� ���� tt�� ����; �ڹٴ� �ּҸ� ���������θ� ó���ϸ�, ���α׷��Ӱ� ���� ��ü������ �Ǵ��� �� �ְԲ� ����ũ�� 16���� �ؽ� ���� ������
		System.out.println("��ü ���� �� : " + tt);
	}
}