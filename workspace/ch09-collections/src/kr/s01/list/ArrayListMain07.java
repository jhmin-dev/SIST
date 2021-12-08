package kr.s01.list;

import java.util.ArrayList;

class CartItem { // 문자열과 int를 묶어 관리하기 위해 클래스 생성
	private String name; // 상품명
	private int num; // 수량
	private int price; // 가격
	
	public CartItem() {} // 기본 생성자
	public CartItem(String name, int num, int price) { // 인자가 있는 생성자
		this.name = name;
		this.num = num;
		this.price = price;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

public class ArrayListMain07 {
	public static void main(String[] args) {
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		list.add(new CartItem("라면", 10, 10000));
		list.add(new CartItem("김치", 5, 20000));
		list.add(new CartItem("만두", 20, 30000));
		
		// 반복문을 이용한 요소 출력; ArrayList가 2차원 배열을 대체할 수 있고, 데이터 추가, 변경, 삭제가 가능하므로 더 편리
		for(int i=0;i<list.size();i++) {
			CartItem c = list.get(i);
			System.out.println(c.getName() + ", " + c.getNum() + ", " + c.getPrice());
		}
		System.out.println();
		for(CartItem item : list) {
			System.out.println(item.getName() + ", " + item.getNum() + ", " + item.getPrice());
		}
	}
}