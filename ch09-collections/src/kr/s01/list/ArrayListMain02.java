package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		// ����Ʈ�� ����Ǵ� ������ �����ϸ�, �ߺ� ������ ���
		ArrayList al = new ArrayList();
		al.add("������"); // �ε��� 0��, String�� Object�� ��ĳ����
		al.add("�󸶹�");
		al.add("�����");
		al.add("��ī��");
		
		// �ݺ����� �̿��� ArrayList�� ��� ���
		for(int i=0;i<al.size();i++) { // ����Ʈ�� ���̴� size() �޼��带 �̿�
			String name = (String)al.get(i); // ArrayList�� ����� ��Ҵ� get() �޼��带 ���� ��ȯ�� �� ������, Object�� ��ȯ�ǹǷ� �ٿ�ĳ�����ؾ� ��
			System.out.println(name);
		}
	}
}