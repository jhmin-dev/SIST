public class OperatorMain06 {
	public static void main(String[] args) {
		// ���� ������, �� ������, �� ������
		int a, b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++; // ������ 10>=11 ���� �� a�� 11�� �����ϸ�, ������ ������ false�̹Ƿ� �İ��� �������� ����

		System.out.println(a + ", " + b);
		System.out.println("c = " + c);
		
		int d, e;
		d = e = 10;
		
		boolean f = ++d > e++ || d++ >= ++e; // ������ 11>10 ���� �� e�� 11�� �����ϸ�, ������ ������ true�̹Ƿ� �İ��� �������� ����
		
		System.out.println(d + ", " + e);
		System.out.println("f = " + f);
	}
}