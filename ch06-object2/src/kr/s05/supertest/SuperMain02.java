package kr.s05.supertest;
// �θ� Ŭ����
class People {
	int a = 100;
	public People() {
		super(); // �θ� Ŭ������ Object�� �⺻ ������ ȣ���� ���� �����Ͽ� Object ������ ����� �ڽ� Ŭ������ People�� �ʱ�ȭ; �θ� Ŭ������ �⺻ �����ڴ� �����ص� �����Ϸ��� ���� �ڵ����� ���Ե�
	}
}
// �ڽ� Ŭ����
class Student extends People {
	int b = 200;
	public Student() {
		super(); // �θ� Ŭ������ People�� �⺻ ������ ȣ���� ���� �����Ͽ� People ������ ����� �ڽ� Ŭ������ Student�� �ʱ�ȭ
	}
}

public class SuperMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.a);
		System.out.println(s.b);
		System.out.println(s.toString());
	}
}