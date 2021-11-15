package kr.s01.list;

import java.util.Vector;

public class VectorMain01 {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		// ��ü
		v.add(100.3);
		v.add(3.14);
		v.add(1000.); // 1000.0���� 0 ���� ����
		
		// Ȯ�� for��
		for(Double n : v) {
			System.out.println(n); // Vector�� ����� ��� ���
		}
		
		// �ڿ� �˻�
		double search = 1000.0; // �˻��� ���
		int index = v.indexOf(search);
		if(index!=-1) { // �˻��� ��Ұ� v�� �ִ� ���
			System.out.println("�˻� ��� " + search + "�� ��ġ : " + index);
		}
		else { // �˻��� ��Ұ� v�� ���� ���
			System.out.println("�˻� ��� " + search + "��/�� v�� �����ϴ�.");
		}
		
		// �ڿ� ����
		double del = 3.14; // ������ ���
		if(v.contains(del)) { // ������ ��Ұ� v�� �ִ� ���
			v.remove(del);
			System.out.println(del + "�� ������ �Ϸ��Ͽ����ϴ� : " + v);
		}
		else { // ������ ��Ұ� v�� ���� ���
			System.out.println(del + "��/�� v�� �����ϴ� : " + v);
		}
	}
}