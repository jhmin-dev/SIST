package kr.s01.list;

import java.util.ArrayList;

class A {
	// Object�� toString() �޼��带 ������
	@Override public String toString() {
		return "Ŭ���� A";
	}
}

class B {
	
}

public class ArrayListMain01 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		// ������ ����; ���� �ٸ� Ŭ���� �ڷ����� ��ü���� ������ ���, �ٽ� ������ �о�� �� �ٿ�ĳ������ ���ŷο�Ƿ� �����δ� ���� Ŭ������ ��ü�鸸 ����
		al.add(new A()); // A ��ü�� �ּҸ� Object�� ��ĳ�����Ͽ� ����
		al.add(new B()); // B ��ü�� �ּҸ� Object�� ��ĳ�����Ͽ� ����
		al.add(10); // 10�� ���� Integer ��ü�� �ּҸ� Object�� ��ĳ�����Ͽ� ����(�ڵ� Boxing)
		al.add("�ϴ�"); // ���ڿ� ��ü�� �ּҸ� Object�� ��ĳ�����Ͽ� ����
		System.out.println(al); // toString() �޼��尡 ����Ʈ�� ����� ������(=��ü �ּ�)�� ������� �����ǵǾ� ����
	}
}