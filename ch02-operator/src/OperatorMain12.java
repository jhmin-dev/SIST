public class OperatorMain12 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		/*
		 * [�ǽ�] A���� �븮�������� �׳� ���� �Ǹž��� 15%�� ������ �ֱ�� �߽��ϴ�.
		 * �Ǹ��� ��ǰ��� ��ǰ�� �ܰ��� ������ Ű����κ��� �Է¹޾� ���� �ݾ��� ����ϴ� ���α׷��� �ۼ��ϼ���.
		 * (��, ��½ÿ��� �Ҽ��� �Ʒ� �ڸ��� ����)
		 * [��� ����]
		 * ��ǰ�� �Է� : �����
		 * �ܰ� �Է� : 500000
		 * �Ǹ� ���� �Է� : 3
		 * ����� 3���� ������ 1,275,000��
		 */
		System.out.print("��ǰ�� �Է� : ");
		String item = input.next();
		System.out.print("�ܰ� �Է� : ");
		int price = input.nextInt();
		System.out.print("�Ǹ� ���� �Է� : ");
		int quantity = input.nextInt();
		System.out.printf("%s %d���� ������ %,d��", item, quantity, (int)(price*quantity*0.85));
		input.close();
	}
}