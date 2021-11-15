package kr.s01.enumtest;

enum Item2 {
	ADD(5), DEL(11), SEARCH(2), CANCEL(22);
	
	// ���� ��ü ������ ������ ��������� �����ϱ� ���� ���� ����
	private final int var;
	
	// ������ ����
	Item2(int v) {
		var = v;
	}
	
	// ������� ��ȯ�ϴ� �޼��� ����
	public int getVar() {
		return var;
	}
}

public class EnumMain04 {
	public static void main(String[] args) {
		System.out.println(Item2.ADD);
		System.out.println(Item2.DEL);
		System.out.println(Item2.SEARCH);
		System.out.println(Item2.CANCEL);
		
		for(Item2 n : Item2.values()) { // values() �޼���� �迭�� �����ؼ� Ȯ�� for�� �̿�
			System.out.println(n + " : " + n.getVar()); // getVar() �޼���� ����� ��ȯ
		}
	}
}