package kr.s04.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain01 {
	public static void main(String[] args) {
		String[] array = {"Java", "Oracle", "JSP", "Java", "HTML"};
		HashSet<String> hs = new HashSet<String>();
		
		// ������ ����
		for(String n : array) {
			hs.add(n); // �ߺ� ����; add() �޼��忡�� �ɷ���
		}
		System.out.println(hs); // ������ �������� ����

		// ������ �б�; HashSet���� �ٷ� �д� ���� �ƴ϶�, Iterator�� �����ؼ� �д� ���� ��Ģ
		Iterator<String> ir = hs.iterator(); // iterator() �޼���� HashSet�� �����͸� Iterator�� ����
		while(ir.hasNext()) { // hasNext() �޼���� ����� �����Ͱ� �ִ��� Ȯ��
			System.out.println(ir.next()); // next() �޼���� �����͸� ����
		}
		
		System.out.println();
		
		// Ȯ�� for���� �̿��� ������ �б�
		for(String s : hs) {
			System.out.println(s);
		}		
	}
}