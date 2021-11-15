package kr.s04.constructor;

public class AccountMain {
	// ��� ����
	String accountNo; // ���� ��ȣ
	String ownerName; // �����ָ�
	int balance; // �ܰ�
	
	// ������
	public AccountMain(String a, String o, int b) {
		accountNo = a;
		ownerName = o;
		balance = b;
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
	}
	
	// ��� �޼���
	public void deposit(int amount) { // �����ϱ�
		balance += amount;
		System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
	}
	public void withdraw(int amount) { // ����ϱ�
		balance -= amount;
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");
	}
	public void printAccount() { // ���� ���� ����
		System.out.println("���¹�ȣ : " + accountNo);
		System.out.println("�����ָ� : " + ownerName);
		System.out.printf("�ܰ� : %,d��\n", balance);
	}
	
	public static void main(String[] args) {
		// ���� ����
		AccountMain am = new AccountMain("100-123", "ȫ�浿", 1000);
		// ���� ����
		am.printAccount();
		//�Ա�
		am.deposit(1000);
		am.printAccount();
		//���
		am.withdraw(2000);
		am.printAccount();
	}
}