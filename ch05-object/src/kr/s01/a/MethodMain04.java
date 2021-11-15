package kr.s01.a;
class Worker {
	/*
	 * [�ǽ�] 
	 * Worker
	 * 1) ��� ���� : ���� �̸�(name), �޿�(money), ���� �ܰ�(balance)
	 * 2) ��� �޼��� : work(�����ϸ� money�� 1,000�� ����), deposit(�����ϸ� money�� ���� balance�� ������Ű�� money�� 0���� ó��)
	 * MethodMain04
	 * 1) Worker ��ü ����
	 * 2) ������ �̸� ����
	 * 3) 10�� ���ϴµ� �� ���� 3,000���� ������ ���¿� ����
	 * 4) ���� �̸�, ���� ���¿� �Աݵ��� �ʰ� ���� �ִ� �޿�(money), ���� �ܰ�(balance)�� ���
	 */
	String name;
	int money, balance;
	
	public void work() {
		money+=1000; // ó�� ������ 0���� �ʱ�ȭ�Ǳ� ������ ���� �߻����� �ʰ� ������
	}
	
	public void deposit() {
		balance+=money;
		money=0;
	}
}

public class MethodMain04 {
	public static void main(String[] args) {
		Worker w = new Worker();
		w.name = "�ʱ�";
		for(int i=0;i<10;i++) {
			w.work();
			if(w.money>=3000) { // w.money%3000==0�� ����
				w.deposit();
			}
		}
		System.out.println("�̸� : " + w.name);
		System.out.printf("���� �ִ� �޿� : %,d��\n", w.money);
		System.out.printf("���� �ܰ� : %,d��", w.balance);
	}
}