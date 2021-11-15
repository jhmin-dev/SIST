package kr.s03.queue;

import java.util.LinkedList;

public class QueueMain {
	public static void main(String[] args) {
		String[] array = {"����", "��õ", "����", "�λ�", "�뱸"};
		LinkedList<String> ll = new LinkedList<String>();
		
		// ll�� offer() �޼���� ������ ����
		for(int i=0;i<array.length;i++) {
			ll.offer(array[i]);
		}
		System.out.println(ll);
		
		// ll���� poll() �޼���� ������ ����(=ll ���� �����ʹ� ������)
		while(ll.peek()!=null) { // ll�� ����� ù ��° ��Ҹ� �˻�
			System.out.print(ll.poll() + "\t"); // ll�� ����� ù ��° ��Ҹ� ��ȯ�ϰ� ����
		}
		System.out.println("\n"+ll);
	}
}