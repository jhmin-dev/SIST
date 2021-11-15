package kr.s01.list;

import java.util.ArrayList;

class CartItem { // ���ڿ��� int�� ���� �����ϱ� ���� Ŭ���� ����
	private String name; // ��ǰ��
	private int num; // ����
	private int price; // ����
	
	public CartItem() {} // �⺻ ������
	public CartItem(String name, int num, int price) { // ���ڰ� �ִ� ������
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
		list.add(new CartItem("���", 10, 10000));
		list.add(new CartItem("��ġ", 5, 20000));
		list.add(new CartItem("����", 20, 30000));
		
		// �ݺ����� �̿��� ��� ���; ArrayList�� 2���� �迭�� ��ü�� �� �ְ�, ������ �߰�, ����, ������ �����ϹǷ� �� ��
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