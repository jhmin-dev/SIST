package kr.s02.packtwo;

import kr.s02.packone.People; // import���� ������ ��Ű���� �޶� People Ŭ������ ������ �� ����

public class AccessMain {
	public static void main(String[] args) {
		People p = new People();
		// System.out.println(p.a); // private; ���� Ŭ������ �ƴϱ� ������ ȣ�� �Ұ�
		// System.out.println(p.b); // default; ���� ��Ű���� �ƴϱ� ������ ȣ�� �Ұ�
		// System.out.println(p.c); // protected; ���� ��Ű���� �ƴϰ� ��� ���赵 �ƴϱ� ������ ȣ�� �Ұ�
		System.out.println(p.d); // public; ���� ������ �����Ƿ� ȣ�� ����
	}
}
