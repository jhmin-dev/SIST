package kr.s02.mathtest;

import java.util.Random; // ���� ������ ���� Ŭ����

public class RandomMain {
	public static void main(String[] args) {
		String[] gift = {"����Ʈ��", "TV", "�����", "��!"};
		
		double ran = Math.random(); // random() �޼���� 0.0 �̻�, 1.0 �̸��� ������ ���� ��ȯ; ������ ������ ������ ��ĥ ����� �ֱ� ������ double �ڷ��� ���
		System.out.println("�߻��� ���� : " + ran);
		
		int get = (int)(ran * gift.length); // ������ ������ �����Ͽ� ���� �ڸ��� �迭�� �ε����� ������ ������ ���� �ϰ�, ���� ����ȯ���� �Ҽ��� ���� ����
		System.out.println("���� ������ ���� : " + get);
		System.out.println("������ ���� : " + gift[get]);

		String[] luck = {"������ ����", "�ζ� ��÷", "�ǰ��� ��", "ûȥ ����"};
		
		Random r = new Random(); // static �޼��尡 �ƴ϶� ��ü�� �����ؾ� ��
		get = r.nextInt(4); // 0���� ���ڿ� ���޵� �� ���������� ������ ������ ���� �߻�
		System.out.println("�߻��� ���� : " + get);
		System.out.println("������ � : " + luck[get]);
	}
}