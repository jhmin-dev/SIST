package kr.s05.statictest;

public class StaticMain02 {
	
	int a; // �ν��Ͻ� ����
	static String s; // static(Ŭ����) ����
	
	public static void main(String[] args) { // ���α׷� ����� main �޼��尡 static ������ �ö�
		// a = 10; // �ν��Ͻ� ������ ��ü ���� ���Ŀ� ȣ��
		s = "�ڹ��� ��"; // static ������ ��ü ������ �����ϰ� ȣ��; main�� s�� ���� Ŭ������ �ֱ� ������ Ŭ������ �����ص� ȣ���
		System.out.println("s = " + StaticMain02.s);
	}
}