package kr.s01.string;

public class StringMain01 {
	public static void main(String[] args) {
		// �Ͻ������� ��ü ����; ���� ���ڿ��� �Ͻ������� ���� �� ���� ���, �޸𸮿� ���� ��ü�� ������ �ʰ� ���� ���� ������ �ϳ��� ��ü�� ������
		String str1 = "abc";
		String str2 = "abc";
		
		// ==�� ����Ͽ� ��ü ��; String Ŭ������ ��� toString() �޼��尡 �����ǵǾ� �־� �������� Ȯ���� �� ������, hashCode() �޼��� ���� �����ǵǾ� �־� ���� ���ڿ��̸� ��ü�� �޶� ���� ���� ��ȯ��
		if(str1 == str2) {
			System.out.println("str1�� str2�� ���� ��ü");
		}
		else {
			System.out.println("str1�� str2�� �ٸ� ��ü");
		}
		
		// equals() �޼��带 ����Ͽ� ���ڿ� �� 
		if(str1.equals(str2)) {
			System.out.println("str1�� str2�� ����(=���ڿ�)�� ����");
		}
		else {
			System.out.println("str1�� str2�� ����(=���ڿ�)�� �ٸ�");
		}
		
		// ��������� ��ü ����; ���� ���ڿ��� ��������� ���� �� ���� ���, �޸𸮿� ���� ��ü�� �ö�
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		// ��ü ��
		if(str3 == str4) {
			System.out.println("str3�� str4�� ���� ��ü");
		}
		else {
			System.out.println("str3�� str4�� �ٸ� ��ü");
		}
		
		// ���ڿ� ��
		if(str3.equals(str4)) {
			System.out.println("str3�� str4�� ����(=���ڿ�)�� ����");
		}
		else {
			System.out.println("str3�� str4�� ����(=���ڿ�)�� �ٸ�");
		}
		
		// ���ڿ��� ��ҹ��ڸ� �������� �ʰ� ��
		String str5 = "bus";
		String str6 = "Bus";
		if(str5.equalsIgnoreCase(str6)) {
			System.out.println("[��ҹ��� ���о��� ��] str5�� str6�� ����(=���ڿ�)�� ����");
		}
		else {
			System.out.println("[��ҹ��� ���о��� ��] str5�� str6�� ����(=���ڿ�)�� �ٸ�");
		}
	}
}