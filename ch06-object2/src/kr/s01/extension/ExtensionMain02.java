package kr.s01.extension;
// �θ� Ŭ����
class People {
	public void eat() {
		System.out.println("�Ļ��ϴ�.");
	}
}
// �ڽ� Ŭ����
class Student extends People {
	public void study() {
		System.out.println("�����ϴ�.");
	}
}

public class ExtensionMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat(); // People�� �޼��带 ��ӹ޾� ȣ��
		s.study(); // Student�� �޼��带 ȣ��
		System.out.println(s.toString()); // Object�� �޼��带 (People�� ����) ��ӹ޾� ȣ��
		System.out.println(s); // ���� ������ �� ��� �ڵ������� toString()�� ȣ��
	}
}