package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(15);
		al.add(16);
		
		System.out.println(al);
		for(int i=0;i<al.size();i++) { // ����� ���� ���Ǻη� �����ϴ� ���, �ε����� 0���� �˻��ϰ� �Ǹ� ��Ұ� ������ �� �ε��� ������ �Ͼ ��ġ�� ��Ұ� �߻�; �ε����� ���������� �˻��ϸ� ��Ҹ� �����ص� �ε��� ������ �Ͼ�� �����Ƿ� ������ �߻����� ����
			if(al.get(i)%2==0) { //����� ���� ¦���� ���
				al.remove(i); // �ش� ��Ҹ� ����
			}
		}
		System.out.println("�ε��� 0���� �ݺ��� ���� : " + al);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(10);
		al2.add(20);
		al2.add(15);
		al2.add(16);
		
		System.out.println(al2);
		for(int i=al2.size();i>0;i--) {
			if(al2.get(i-1)%2==0) {
				al2.remove(i-1);
			}
		}
		System.out.println("������ �ε������� �ݺ��� ���� : " + al2);
	}
}