package kr.s07.finaltest;

public class FinalMain01 {
	// ��� ���; ��ü�� ��� �ִ� ���� ȣ�� ����
	final int NUM = 10;
	
	// static ���; ȣ���ϸ� �޸𸮿� �ö󰡰�, ���� Ŭ������ ��� ��ü�� ����; �Ϲ������� ���� �����ڷ� public�� ���
	public static final int NUMBER = 20;
	
	public static void main(String[] args) {
		// ������ ���; ȣ��� �޼��� �� ����� �����
		final int NO = 30;
		System.out.println(NO);
		
		// ����� �� ���� �Ұ�
		// NO = 100;
		
		// Ŭ���� ������ ����� ����� ��ü ���� �� ��� ����
		// System.out.println(NUM);
		FinalMain01 fm = new FinalMain01();
		System.out.println(fm.NUM);
		
		// static ��� ȣ��
		System.out.println(NUMBER); // main�� NUMBER�� ���� Ŭ������ Ŭ������ ���� ����
	}
}