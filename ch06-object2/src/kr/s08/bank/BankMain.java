package kr.s08.bank;

public class BankMain {
	public static void main(String[] args) {
		/*
		 * ���̳ʽ� ���� ����
		 * ����� �� ���� ���
		 */
		/* �Է��� �޾� ���̳ʽ� ���¸� ����
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("���� �⺻ ������ �Է��ϼ���.");
		System.out.print("���� ��ȣ > ");
		String number = input.nextLine();
		System.out.print("�����ָ� > ");
		String name = input.nextLine();
		System.out.print("���� �ܾ� > ");
		int balance = input.nextInt();
		System.out.print("���̳ʽ� �ѵ� > ");
		int minusLimit = input.nextInt();
		
		input.close();
		
		MinusAccount ma = new MinusAccount(number, name, balance, minusLimit);
		*/
		MinusAccount ma = new MinusAccount("110-1234", "ȫ�浿", 1000, 500);
		
		ma.printAccount();
		
		ma.deposit(2000);
		ma.printAccount();
		
		ma.withdraw(3100); // ���� �ܰ� -500�� �� �������� ��� ����
		ma.printAccount();
		
		ma.withdraw(500); // �ѵ� �ʰ��� ��� �Ұ�
		ma.printAccount();
	}
}