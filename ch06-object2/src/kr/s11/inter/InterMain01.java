package kr.s11.inter;

interface A1 {
	// ���; �������̽��� �����ڰ� �����Ƿ� ��ü ������ �Ұ����ϰ�, ����� ���� ȣ��� �޸𸮿� �ö�
	public static final int W = 10; // ����
	int X = 20; // public static final �����ص� ������� �����
	static int Y = 30; // public final �����ص� ������� �����
	final int Z = 40; // public static �����ص� ������� �����
}

public class InterMain01 {
	public static void main(String[] args) {
		// �������̽��� ��ü ���� �Ұ�
		// A1 ap = new A1();
		
		// static ����̹Ƿ� �������̽���.����� �������� ȣ����
		System.out.println("W = " + A1.W);
		System.out.println("X = " + A1.X);
		System.out.println("Y = " + A1.Y);
		System.out.println("Z = " + A1.Z);
	}
}