package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("���");
		al.add("����");
		al.add("�ٳ���");
		al.add("������");
		al.add("���");

		System.out.println("���� ��");
		for(int i=0;i<al.size();i++) {
			System.out.println(i + " : " + al.get(i));
		}

		// al.remove(2); // remove() �޼��忡 �ε��� ���� �Է��Ͽ� ������ ��� ����; �ε��� ���� �߻�
		al.remove("���"); // remove() �޼��忡 ����� ��Ҹ� �Է½�, ��ġ�ϴ� (ù ��°) ��� ����; �ε��� ���� �߻�

		System.out.println("���� ��");
		for(int i=0;i<al.size();i++) {
			System.out.println(i + " : " + al.get(i));
		}
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(10);
		al2.add(5);
		al2.add(3);
		al2.add(20);
		
		System.out.println("���� ��");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i + " : " + al2.get(i));
		}
		
		// al2.remove(2); // �ε����� ������ ��� ����
		// Integer n = 10;
		// al2.remove(n); // 10�� ��ġ�ϴ� ��� ����
		al2.remove((Integer)10); // �׳� 10�� �Է��ϸ� int�� �ε����� �ν��Ͽ� ���� �߻��ϹǷ� Integer���� ����ؾ� ��
		
		System.out.println("���� ��");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i + " : " + al2.get(i));
		}
		
		al2.set(1, 30); // set() �޼��忡 �ε����� �����ϰ� ������ �����͸� �Է��Ͽ� ������ ����� �����͸� ����
		System.out.println("���� ��");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i + " : " + al2.get(i));
		}
	}
}