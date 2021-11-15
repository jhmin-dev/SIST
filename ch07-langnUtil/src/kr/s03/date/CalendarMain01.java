package kr.s03.date;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); // �߻� Ŭ������ new�� ��ü �������� ���ϰ� getInstance() �޼���� ��ü ��ȯ; �ڽ� Ŭ���� GregorianCalendar ��ü�� ������
		System.out.println(today); // �ĺ���(=static ���)�� ���� ������ ����
		
		int year = today.get(Calendar.YEAR); // get()�޼���� �ĺ��ڿ� ��Ī�� ���� ��ȯ
		int month = today.get(Calendar.MONTH) + 1; // MONTH�� ��� ���������� 0~11�� ó���ϱ� ������ 11���� 10�� ���� ����
		int date = today.get(Calendar.DATE);
		System.out.println(year + "�� " + month + "�� " + date + "��");
		
		int day = today.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK�� 1�� �Ͽ���, 7�� ������� �ǹ�
		/*
		String nday = ""; // �� ���ڿ��� �ʱ�ȭ
		switch(day) {
		case 1: nday = "��"; break;
		case 2: nday = "��"; break;
		case 3: nday = "ȭ"; break;
		case 4: nday = "��"; break;
		case 5: nday = "��"; break;
		case 6: nday = "��"; break;
		case 7: nday = "��"; break;
		System.out.println(nday + "����");
		}
		*/
		String weekday = "�Ͽ�ȭ�������";
		System.out.println(weekday.charAt(day + 1) + "����");
		
		int amPm = today.get(Calendar.AM_PM); // ����=0, ����=1
		System.out.println(amPm == Calendar.AM ? "����" : "����");
		
		int hour = today.get(Calendar.HOUR); // 12�ð� ǥ���; HOUR_OF_DAY�� 24�ð� ǥ���
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		System.out.println(hour + ":" + min + ":" + sec);
	}
}