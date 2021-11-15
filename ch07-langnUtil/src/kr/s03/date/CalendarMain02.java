package kr.s03.date;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("��� ������ ���� �Է��ϼ���! (��: ���� > 2021, �� > 7)");
		System.out.print("���� > ");
		int year = input.nextInt();
		System.out.print("�� > ");
		int month = input.nextInt();
		input.close();
		
		System.out.println("[ " + year + "�� " + month + "�� ]");
		System.out.println("========");
		System.out.println("��  ��  ȭ  ��  ��  ��  ��");
	
		// ���� ��¥�� �ð��� ����; new�� ��ü ���� �Ұ�
		Calendar cal = Calendar.getInstance();
		// ��� ����, ��, �� ����; ���� ������ 0~11�̱� ������ �Է� ��-1, ���� �޷��� 1�Ϻ��� �����ϱ� ������ 1�Ϸ� ����
		cal.set(year, month-1, 1);
		// 1���� ������ ���ϱ�; ������ ������ 1=�Ͽ���, 7=�����
		int week = cal.get(Calendar.DAY_OF_WEEK);
		// ���� ������ ��¥ ���ϱ�
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		
		// ù ��¥�� ǥ���ϱ� �� ���� ó��
		for(int i=1;i<week;i++) {
			System.out.printf("%3s", " "); // 3ĭ ��� ���� ����
		}
		// 1�Ϻ��� ������ ��¥���� ǥ��
		for(int i=1;i<=lastOfDate;i++) {
			System.out.printf("%3d", i); // 3ĭ ��� ��¥ ����
			if(week%7==0) System.out.println(); // ������̸� �ٹٲ�
			week++;
		}
		System.out.println("\n========");
	}
}