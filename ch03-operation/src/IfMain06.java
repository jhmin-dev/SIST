public class IfMain06 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * ���� �� ���� �Է¹޾Ƽ� ������ �����ϰ� �� �� �� �ִ񰪰� �ּڰ��� ���Ͽ� ����Ͻÿ�.
		 * ��, �Է¹��� �� ���� ���� ��� "�� ���� ����."��� ����Ͻÿ�.
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("ù ��° ���� : ");
		int a = input.nextInt();
		System.out.print("�� ��° ���� : ");
		int b = input.nextInt();
		
		input.close();
		
		if(a>b)
			System.out.printf("�ִ� : %d, �ּڰ� : %d\n", a, b);
		else if(a<b)
			System.out.printf("�ִ� : %d, �ּڰ� : %d\n", b, a);
		else
			System.out.println("�� ���� ����.");
	}
}