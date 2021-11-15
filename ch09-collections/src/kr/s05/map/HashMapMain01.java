package kr.s05.map;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		
		// mp�� put() �޼���� ������ ����
		mp.put("�ʱ�", 95);
		mp.put("�ᵹ", 100);
		mp.put("�㵹", 85);
		mp.put("��ũ", 93);
		mp.put("����", 70);
		mp.put("�ᵹ", 0); // Map �������̽��� �ĺ����� �ߺ��� �����ϸ�, �ĺ��ڰ� �ߺ��Ǿ��� ��� �������� ����� ���� ����
		mp.put("����", null); // ������ null ����
		mp.put(null, 100); // �ĺ��ڷ� null ����
		System.out.println(mp);
		
		// get() �޼��忡 �ĺ��ڸ� ���ڷ� �Է��Ͽ� ����� ���� ��ȯ����
		int num = mp.get("�ᵹ"); // Integer���� int�� �ڵ� ��ȯ �߻�
		System.out.println("�ᵹ�� ������ " + num);
		int nullnum = mp.get(null);
		Integer nullnum2 = mp.get("����"); // int�� ���� ����� Integer�� int�� ��ȯ�ϴ� �������� ���� �߻�; ����ÿ��� ������ ��� ȣ��� ������ �� �����Ƿ� ���ǹ����� null �����ϵ��� �����ϴ� ���� ����
		System.out.println("�ĺ��� null : " + nullnum + ", �� null : " + nullnum2);
	}
}