package kr.s01.enumtest;

enum Item {
	ADD, DEL, SEARCH, CANCEL
}

public class EnumMain03 {
	public static void main(String[] args) {
		// values() 메서드를 통해 열거 자료형 Item에 포함된 모든 열거 객체들을 배열로 반환
		Item[] items = Item.values();
		System.out.println("items.length : " + items.length);
		
		// 확장 for문을 이용한 출력
		for(Item n : items) {
			System.out.println(n.ordinal());
		}
	}
}