public class WhileMain07 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		/*
		 * [�ǽ�] 
		 * Ŀ������������ �Ƹ޸�ī�밡 4,000���Դϴ�. ���� Ŀ�� ������ ���ϰ� ���� �����ϼ���.
		 * ������ ������ �߻��� �Ž������� ����ϰ�, ��ǰ�� �� ��뺸�� ������ ���� ��� ��ǰ�� ������ �� ���� ��� "�ݾ��� �����մϴ�."��� �˷��� �� �ٽ� ������ �� �ִ� ���α׷��� �ۼ��ϼ���.
		 * [��� ����]
		 * ���� ���� �Է� > 2
		 * ���� ������ �ݾ� > 10000
		 * �Ž����� : 2,000��
		 * ---> ���� ����
		 * ========
		 * ���� ���� �Է� > 2
		 * ���� ������ �ݾ� > 5000
		 * 3,000���� �����մϴ�.
		 * ---> �ٽ� ������ �� �ֵ��� ó��
		 */
		int price=4000;
		int quantity; // ����
		int balance; // �Ž�����
		int payment; // ������ �ݾ�
		int total; // �� �����ؾ� �� �ݾ�
		quant: while(true) { // ���� ������ label ����
			System.out.print("���� ���� �Է� > ");
			quantity=input.nextInt();
			if(quantity>0) {
				total=price*quantity;
				while(true) { // �ݾ� ����
					System.out.print("���� ������ �ݾ� > ");
					payment=input.nextInt();
					balance=payment-total;
					if(balance>=0) {
						break; // �ݾ� ���� Ż��
					}
					else {
						System.out.printf("%,d���� �����մϴ�.\n", -balance);
						continue quant; // label�� ������ ���� ������ �̵�
					}
				}
				System.out.printf("�Ž����� : %,d��\n", balance);
				break; // ���� ���� Ż��
			}
			else {
				System.out.println("������ 0 ������ �� �����ϴ�.");
			}
		}
		input.close();
	}
}