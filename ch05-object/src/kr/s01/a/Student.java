package kr.s01.a;
public class Student {
	
	// �ʵ�
	String name;
	int age;
	
	public static void main(String[] args) {
		// ��ü ����; �ڷ����� Ŭ���������� ����Ͽ� ������ ����
		Student s;
		
		// ��ü ����; �޸𸮿� ��ü�� �����ϰ� ��ü�� �ּҸ� s�� ����; ��ü���� ��� ���� name�� age�� ���Ե�
		s = new Student(); // new �����ڴ� ��ü�� �����ϴ� ����; �ڹٿ����� �迭 ���� ��ü�� ��޵Ǿ� new �����ڷ� ����
		
		// ��ü�� �ʵ忡 �����͸� ����
		s.name = "ȫ�浿";
		s.age = 20;
		
		// ��ü�� �ʵ忡 ����� ������ �б�
		System.out.println(s.name + ", " + s.age);
	}
}