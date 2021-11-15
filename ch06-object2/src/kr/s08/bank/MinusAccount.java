package kr.s08.bank;

public class MinusAccount extends BankAccount {
	/*
	 * BankAccount ���
	 * ���̳ʽ� �ѵ�(minusLimit)
	 * �ѵ��� ������ ����ϱ�(withdraw) ������
	 * ���̳ʽ� �ѵ� ������ ���Ե� ���� ���� ����(printAccount) ������
	 */
	private int minusLimit; // printAccount�� get �޼��� ������ ����ϴ� ������ Getter & Setter ������ �ʾƵ� ��

	public MinusAccount(String number, String name, int balance, int minusLimit) {
		super(number, name, balance);
		if(minusLimit<0) {
			this.minusLimit=-minusLimit;
		}
		else {
			this.minusLimit=minusLimit;
		}
	}

	@Override public void withdraw(int money) {
		if(balance+minusLimit>=money) {
			balance-=money;
			System.out.printf("%,d���� ����Ͽ����ϴ�.\n", money);
			return;
		}
		System.out.println("���̳ʽ� �ѵ� �ʰ��� ��ݵ��� �ʽ��ϴ�.");
	}

	@Override public void printAccount() {
		System.out.println("���� ��ȣ : ���̳ʽ� "+number);
		System.out.println("������ : "+name);
		System.out.printf("���� �ܾ� : %,d��\n", balance);
		System.out.printf("���̳ʽ� �ѵ� : %,d��\n", minusLimit);
		System.out.println();
	}
}