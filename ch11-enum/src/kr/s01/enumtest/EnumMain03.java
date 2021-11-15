package kr.s01.enumtest;

enum Item {
	ADD, DEL, SEARCH, CANCEL
}

public class EnumMain03 {
	public static void main(String[] args) {
		// values() �޼��带 ���� ���� �ڷ��� Item�� ���Ե� ��� ���� ��ü���� �迭�� ��ȯ
		Item[] items = Item.values();
		System.out.println("items.length : " + items.length);
		
		// Ȯ�� for���� �̿��� ���
		for(Item n : items) {
			System.out.println(n.ordinal());
		}
	}
}