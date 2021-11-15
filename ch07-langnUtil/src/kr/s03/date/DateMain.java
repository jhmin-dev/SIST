package kr.s03.date;

import java.text.DateFormat; // ��¥ �� �ð��� ��� ������ �����ϱ� ���� Ŭ����
import java.text.SimpleDateFormat; // ��¥ �� �ð��� ��� ������ ���� �����Ӱ� �����ϱ� ���� Ŭ����
import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now); // ���� ��¥ �� �ð��� �⺻ �������� ���
		// System.out.println(now.toLocaleString()); // ���� ��¥ �� �ð��� �ѱ� �������� ���; deprecated�Ǿ� ������� ����
		
		DateFormat df = DateFormat.getInstance(); // SHORT style�� ����� formatter ��ü ��ȯ
		String today = df.format(now); // Date ��ü�� ������ �����Ͽ� ���ڿ��� ��ȯ
		System.out.println(today);
		
		df = DateFormat.getDateTimeInstance(); // FORMAT locale�� ����� formatter ��ü ��ȯ
		today = df.format(now); // Date ��ü�� ������ �����Ͽ� ���ڿ��� ��ȯ
		System.out.println(today);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh:mm:ss"); // ������ ������ formatter ��ü ����; y�� ����, M�� ��, d�� ��, E�� ����, a�� ����/����, h�� 0~11��, m�� ��, s�� �ʸ� �ǹ��ϸ� yyyy�� 4�ڸ��� ������ ����϶�� �ǹ� 
		today = sf.format(now);
		System.out.println(today);		
	}
}