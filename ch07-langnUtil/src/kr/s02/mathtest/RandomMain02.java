package kr.s02.mathtest;

import java.util.Scanner;

public class RandomMain02 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] ���������� ����
		 * ��ǻ�Ͱ� ������ �߻����� 0=����, 1=����, 2=���� ����.
		 * �޴� > 1. �����ϱ�, 2. ����
		 * [��� ����]
		 * ���������� �Է� > 0. ����, 1. ����, 2. ��
		 * ��� 1) ���º�! (��ǻ�� : ����, ��� : ����)
		 * ��� 2) ��ǻ�� �¸�! (��ǻ�� : ����, ��� : ��)
		 * ��� 3) ��� �¸�! (��ǻ�� : ����, ��� : ����)
		 */
		String[] item = {"����", "����", "��"};

		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("========");
			System.out.println("1. �����ϱ�, 2. �����ϱ�");
			System.out.println("========");
			System.out.print("�޴� > ");
			int num = input.nextInt();
			if(num == 1) {
				System.out.print("���������� �Է�(0. ����, 1. ����, 2. ��) > ");
				int user = input.nextInt();
				// �迭�� �ε����� ����� ���̹Ƿ� ������ �´��� �˻�
				if(user <0 || user > 2) {
					System.out.println("�߸� �Է��߽��ϴ�.");
					continue;
				}
				// ���� �����ϰ� ��� ����
				int computer = (int)(Math.random()*3);
				/*
				 * ��ǻ�� - ����� = ��� ����
				 * 0 - 0 = 0 ���º�
				 * 0 - 1 = -1 ����� �¸�
				 * 0 - 2 = -2 ��ǻ�� �¸�
				 * 1 - 0 = 1 ��ǻ�� �¸�
				 * 1 - 1 = 0 ���º�
				 * 1 - 2 = -1 ����� �¸�
				 * 2 - 0 = 2 ����� �¸�
				 * 2 - 1 = 1 ��ǻ�� �¸�
				 * 2 - 2 = 0 ���º�
				 */
				int result = computer - user;
				if(result == 0) {
					System.out.println("���º�! ��ǻ�� : " + item[computer] + ", ��� : " + item[user]);
				} else if(result == -1 || result == 2) {
					System.out.println("��� �¸�! ��ǻ�� : " + item[computer] + ", ��� : " + item[user]);
				} else { // result == -2 || result == 1
					System.out.println("��ǻ�� �¸�! ��ǻ�� : " + item[computer] + ", ��� : " + item[user]);
				}
			}
			else if(num == 2) {
				System.out.println("���α׷� ����");
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}

		input.close();
	}
}