package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		// ���׸� ǥ��: ��ü�� ������ �� ��ü�� ������ �� �ִ� ����� �ڷ����� Ŭ������� �����ڸ� ������ <>�� ����; ���׸� ǥ���� ������� ������ ������ �о�� �� ClassCastException �� ���ܰ� �߻��� �� �����Ƿ�, ����� �����
		ArrayList<String> al = new ArrayList<String>();
		al.add("����"); // ���׸� ǥ���� ���� Object�� ��ĳ���õ��� �ʰ� String���� �����
		al.add("�λ�");
		// al.add(1000); // ���׸� ǥ���� �Ἥ ArrayList ��ü�� ������ �� ����Ǵ� ��ü�� �ڷ����� String���� ���������Ƿ� Integer ��ü�� ������ �� ����(=�����Ͻ� ���� �߻�)
		al.add("��õ");
		
		// �ݺ����� �̿��� ArrayList�� ��� ���
		for(int i=0;i<al.size();i++) {
			String city = al.get(i); // ���׸� ǥ���� ���� Object�� �ƴ϶� String���� ��ȯ
			System.out.println(city);
		}
		
		// Ȯ�� for���� �̿��� ArrayList�� ��� ���
		for(String city : al) {
			System.out.println(city);
		}
	}
}