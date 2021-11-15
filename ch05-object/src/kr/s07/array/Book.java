package kr.s07.array;

public class Book {
	// ��� ����
	private String category; // �з�
	private String name; // ������
	private int price; // ����
	private double discount; // ������
	// Getters and Setters
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	// �迭�� �ִ� ���� ���ϰ� �ϱ� ���� ������ ���
	public Book() {}
	public Book(String category, String name, int price, double discount) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
}