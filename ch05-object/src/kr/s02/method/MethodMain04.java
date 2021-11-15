package kr.s02.method;

import java.util.Scanner;
/*
 * [�ǽ�] 
 * Account
 * 1) ��� ���� : ���� ��ȣ(account_num), ������(name), �ܰ�(balance)
 * 2) ��� �޼��� : 
 * 1. �����ϱ�(deposit): balance �� ���� ��, �Ա��� �Ϸ�Ǿ����ϴ�. ���
 * 2. ����ϱ�(withdraw): balance �� ���� ��, ����� �Ϸ�Ǿ����ϴ�. ���
 * 3. ��������(printAccount): ���� ��ȣ, ������, �ܰ� ���
 * MethodMain04
 * 1) Account ����
 * 2) ���� �⺻ ���� �Է�: ���� ��ȣ, ������, �ܰ�
 * 3) ���� ���� ���
 * 4) �Ա��ϱ�
 * 5) ���� ���� ���
 * 6) ����ϱ�
 * 7) ���� ���� ���
 */
class Account {
	String account_num, name;
	int balance;
	
	public void deposit(int n) {
		balance+=n;
		System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
	}
	public void withdraw(int n) {
		balance-=n;
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");
	}
	public void printAccount() {
		System.out.println("====���� ����====");
		System.out.println("���� ��ȣ : "+account_num);
		System.out.println("������ : "+name);
		System.out.printf("�ܰ� : %,d��\n", balance);
	}
}

public class MethodMain04 {
	public static void main(String[] args) {
		Account bank=new Account();
		Scanner input=new Scanner(System.in);
		
		System.out.println("���� �⺻ ������ �Է��ϼ���.");
		System.out.print("���¹�ȣ > ");
		bank.account_num=input.nextLine(); // �� �� ��ü�� �Է¹޴� �޼���
		System.out.print("������ > ");
		bank.name=input.next(); // ���� �������� �Է¹޴� �޼���
		System.out.print("�ܰ� > ");
		bank.balance=input.nextInt();
		/*
		bank.printAccount();

		System.out.println("====�Ա�====");
		System.out.print("�Ա��� �ݾ��� �Է��ϼ��� > ");
		bank.deposit(input.nextInt());
		bank.printAccount();
		
		System.out.println("====���====");
		System.out.print("����� �ݾ��� �Է��ϼ��� > ");
		bank.withdraw(input.nextInt());
		bank.printAccount();
		*/
		while(true) { // �޴� �����; �⺻ ������ while�� �ۿ��� ���� �Է��ؾ� ��
			System.out.println("========");
			System.out.println("1. ����|2. ���|3. �ܰ�|4. ����");
			System.out.println("========");
			
			System.out.print("�޴� ���� > ");
			int num=input.nextInt();
			if(num==1) {
				System.out.print("���ݾ� > ");
				bank.deposit(input.nextInt());
			}
			else if(num==2) {
				System.out.print("��ݾ� > ");
				bank.withdraw(input.nextInt());
			}
			else if(num==3) {
				bank.printAccount();
			}
			else if(num==4) {
				System.out.println("���α׷� ����");
				break;
			}
			else {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�.");
			}
		}
		input.close();
	}
}