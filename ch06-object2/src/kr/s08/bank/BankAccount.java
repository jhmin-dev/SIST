package kr.s08.bank;

public class BankAccount { // �Ϲ� ����
	/*
	 * [�ǽ�]
	 * ���¹�ȣ(number), ������(name), �ܰ�(balance)
	 * �����ڸ� �̿��Ͽ� ���� ��ȣ, ������, �ܰ� ����
	 * �Ա��ϱ�(deposit), ����ϱ�(withdraw : �ܰ� ���� Ȯ��), ���� ���� ����(printAccount : �Ϲ� ���� ��ȣ, ������, ���� �ܾ�)
	 */
	protected String number; // ����� ����Ͽ� ���� �����ڸ� protected�� ����
	protected String name;
	protected int balance; // ���� ���α׷��� long�� ������ �������� ū ���� ������� �����Ƿ� int �ڷ��� ���
	
	public BankAccount(String number, String name, int balance) {
		this.number=number;
		this.name=name;
		this.balance=balance;
		System.out.println(number+" ���°� �����Ǿ����ϴ�.\n");
	}
	
	public void deposit(int money) {
		if(money>=0) {
			balance+=money;
			System.out.printf("%,d���� �����Ͽ����ϴ�.\n", money);
			return;
		}
		System.out.println("0�� �̻��� �����ϼ���.");
	}
	
	public void withdraw(int money) {
		if(balance>=money) {
			balance-=money;
			System.out.printf("%,d���� ����Ͽ����ϴ�.\n", money);
			return;
		}
		System.out.println("�ܰ� �����մϴ�.");
	}
	
	public void printAccount() {
		System.out.println("���� ��ȣ : �Ϲ� "+number);
		System.out.println("������ : "+name);
		System.out.printf("���� �ܾ� : %,d��\n", balance);
		System.out.println();
	}
}