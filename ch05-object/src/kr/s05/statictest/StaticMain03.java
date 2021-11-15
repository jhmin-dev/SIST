package kr.s05.statictest;

class StaticMethod {
	String s1 = "����ƽ";
	static String s2 = "static";
	
	public static String getString() { // static �޼���� ȣ��� �޸𸮿� �ö�
		// return s1; // �ν��Ͻ� ������ ��ü�� �������� ������ �޸𸮿� �ö� ���� ����
		return s2; // static ������ ȣ��� �޸𸮿� �ö�; getString�� s2�� ���� Ŭ������ �־� ȣ��� Ŭ������ ���� ����
	}
}

public class StaticMain03 {
	public static void main(String[] args) {
		System.out.println(StaticMethod.getString()); // main�� Ŭ������ getString�� Ŭ������ ���� �����Ƿ� Ŭ�������� ����ؾ� static �޼��忡 ���� ����; static ������ static �޼���� ȣ���ϸ� �ٷ� ��� ������; String.valueOf() ���� static �޼���
	}
}