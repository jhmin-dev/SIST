package kr.s01.a;
class Tv {
	// ��� ����(=�Ӽ�)
	boolean power; // ���� ����(on/off)
	int channel; // ���� ä��
	
	// ��� �޼���(=����)
	public void isPower() {
		power = !power; // power���� true�̸� false��, false�̸� true�� ���
	}
	public void channelUp() {
		++channel; // ä���� 1 ����
	}
	public void channelDown() {
		--channel; // ä���� 1 ����
	}
}

public class TvMain {
	
	public static void main(String[] args) {
		// ��ü ���� �� ����
		Tv t = new Tv();
		// Tv�� ����
		t.isPower();
		System.out.println("Tv ���� ���� : " + t.power);
		System.out.println("���� ä�� : " + t.channel);
		// ä�� ����
		t.channel = 7;
		System.out.println("ù ��° ����� ä�� : " + t.channel);
		// ä�� ����
		t.channelDown();
		System.out.println("�� ��° ����� ä�� : " + t.channel);
		// Tv�� ����
		t.isPower();
		System.out.println("Tv ���� ���� : " + t.power);
	}
}