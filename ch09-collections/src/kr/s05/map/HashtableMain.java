package kr.s05.map;

import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableMain {
	public static void main(String[] args) {
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		// h�� put() �޼���� ������ ����
		h.put("name", "ȫ�浿");
		h.put("age", "20"); // ���� �ڷ����� String���� �����߱� ������ 10 �Է½� ���� �߻�
		h.put("tel", "010-1234-5678");
		h.put("job", "Ž��");
		h.put("address", "�����");
		h.put("name", "�ʱ�"); // �ĺ����� �ߺ��� �����ϸ�, �ĺ��ڰ� �ߺ��Ǵ� ��� �������� ����� ���� ����
		// h.put("zipcode", null); // ����� NullPointerException; ���� null�� �������� ����
		// h.put(null, "������"); // ����� NullPointerException; �ĺ��ڿ� null�� �������� ����
		System.out.println(h);
		
		// get() �޼��忡 �ĺ��ڸ� ���ڷ� �Է��Ͽ� ����� ���� ��ȯ����
		String name = h.get("name");
		System.out.println("name = " + name);

		System.out.println();
		
		// h�� ����� �ĺ��� ���ϱ�; keys() �޼��带 ���� Enumeration ��ü�� �����ؾ� ��
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key + " = " + h.get(key));
		}
	}		
}