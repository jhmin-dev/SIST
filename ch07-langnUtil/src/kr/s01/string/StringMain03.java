package kr.s01.string;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "  aBa  ";
		String s2 = "abc";
		int a = 100;
		String msg = null;
		
		msg = s1.toUpperCase(); // ���ڿ� �� �ҹ��ڸ� ��� �빮�ڷ� ��ȯ
		System.out.println("msg : " + msg);
		
		msg = s1.toLowerCase(); // ���ڿ� �� �빮�ڸ� ��� �ҹ��ڷ� ��ȯ
		System.out.println("msg : " + msg);
		
		msg = s1.replace("aB", "b"); // Ư�� ���ڿ��� ���ο� ���ڿ��� ġȯ
		System.out.println("msg : " + msg);
		
		msg = s1.trim(); // ���ڿ� ���� ������ ����; �ڹٿ��� ������ �����ͷ� ���������� ���α׷����� �ʿ信 ���� trim() �޼��� Ȱ�� ����
		System.out.println("msg : " + msg);
		
		boolean f= s1.contains("aB"); // ���ڿ� ���� ���ڷ� ���޹��� ���ڿ��� ���ԵǾ� ������ true, �׷��� ������ false�� ��ȯ; �˻� �뵵�� ��� ����
		System.out.println("f : " + f);
		
		f = s2.startsWith("ab"); // ���ڿ��� ���ڿ� ���޵� ���ڿ��� �����ϸ� true, �׷��� ������ false�� ��ȯ; �˻� �뵵�� ��� ����
		System.out.println("f : " + f);
		
		f = s2.endsWith("bc"); // ���ڿ��� ���ڿ� ���޵� ���ڿ��� ������ true, �׷��� ������ false�� ��ȯ; �˻� �뵵�� ��� ����
		System.out.println("f : " + f);
		
		String msg2 = String.valueOf(a); // valueOf() �޼��带 �̿��Ͽ� int�� String���� ��ȯ(=parsing)
		System.out.println("msg2 : " + msg2);
		String msg3 = a + ""; // �� ���ڿ��� �����Ͽ� int�� String���� ��ȯ(=parsing)
		System.out.println(msg3.equals(msg2));
	}
}