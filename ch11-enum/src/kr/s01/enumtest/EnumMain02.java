package kr.s01.enumtest;
// ������ ���
enum Lesson {
	JAVA, JSP, SERVLET // �������� �ĺ��� �� ������ ����ϴ� ���� ��ü ����
}

public class EnumMain02 {
	public static void main(String[] args) {
		System.out.println(Lesson.JAVA);
		System.out.println(Lesson.JSP);
		System.out.println(Lesson.SERVLET);
		
		// name() �޼���� ���� ��ü�� ���ڿ� ��ȯ
		System.out.println(Lesson.JAVA.name());
		System.out.println(Lesson.JSP.name());
		System.out.println(Lesson.SERVLET.name());
		
		// ordinal() �޼���� ���� ��ü�� ���� ��ȯ
		System.out.println(Lesson.JAVA.ordinal()); // ������ 0���� ����
		System.out.println(Lesson.JSP.ordinal());
		System.out.println(Lesson.SERVLET.ordinal());
	}
}