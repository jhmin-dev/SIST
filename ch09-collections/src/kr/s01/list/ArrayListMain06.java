package kr.s01.list;

import java.util.ArrayList;
import java.util.Collections; // ArrayList���� ���� �޼��尡 ����

public class ArrayListMain06 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("�ӷ�");
		list.add("���");
		list.add("�޵�");
		list.add("�ڵ�");
		list.add("���");
		list.add("���");
		
		// �ε��� Ž��
		int index1 = list.indexOf("���"); // �տ������� "���"�� Ž��
		System.out.println("ù ��° ��� : " + index1);
		int index2 = list.lastIndexOf("���"); // ���������� "���"�� Ž��
		System.out.println("������ ��� : " + index2);
		int index3 = list.indexOf("����"); // ���� ����� �ε����� Ž���ϸ� -1�� ��ȯ
		System.out.println("���� : " + index3);
		
		// ����
		Collections.sort(list); // ���������� ��Ҹ� ����(=�ε��� ���ġ)
		System.out.println(list);
		Collections.reverse(list); // �������� �������� ��Ҹ� ����
		System.out.println(list);
	}
}