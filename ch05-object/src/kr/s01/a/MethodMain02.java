package kr.s01.a;
public class MethodMain02 {
	// ������ �����͸� ��ȯ�ϴ� ��� �޼���
	public int signOf(int a) {
		int sign = 0; // ���� ����
		if(a>0)
			sign = 1;
		else if(a<0)
			sign = -1; //  ���� ��; �ʱⰪ�� �����߱� ������ else ���� ����
		return sign; // ����� ��ȯ
	}
	
	public static void main(String[] args) {
		/*
		 * [�ǽ�] �Է��� int�� ������ �����̸� -1��, 0�̸� 0��, ����̸� 1�� ��ȯ�ϴ� signOf �޼��带 �ۼ��Ͻÿ�.
		 * [��� ����]
		 * ���� �Է� > 5
		 * ������� ?
		 */
		MethodMain02 method = new MethodMain02(); // �޼���� ��ü�� ���ԵǾ� �����ϱ� ������ �ݵ�� ��ü�� �����ؾ� ��� ����
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("���� �Է� > ");
		int result = method.signOf(input.nextInt());
		input.close();
		System.out.println("������� ? " + result);
	}
}