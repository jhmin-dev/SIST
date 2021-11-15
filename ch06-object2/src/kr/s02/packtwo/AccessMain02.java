package kr.s02.packtwo;

import kr.s02.packone.People; // import���� ������ ��Ű���� �޶� People Ŭ������ ��ӹ��� �� ����

class Student extends People {
	public void print() {
		// System.out.println("a = " + a); // private; ��� ����� ���� Ŭ������ �ƴϹǷ� ȣ�� �Ұ�
		// System.out.println("b = " + b); // default; ��� ����� ���� ��Ű���� �ƴϹǷ� ȣ�� �Ұ�
		System.out.println("c = " + c); // protected; ��� �����̹Ƿ� �ٸ� ��Ű���� ȣ�� ����
		System.out.println("d = " + d); // public; ���� ������ �����Ƿ� ȣ�� ����
	}
}

public class AccessMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		s.print();
	}
}