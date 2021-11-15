package kr.s07.array;

public class Book {
	// 멤버 변수
	private String category; // 분류
	private String name; // 도서명
	private int price; // 가격
	private double discount; // 할인율
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
	// 배열에 넣는 것을 편리하게 하기 위해 생성자 명시
	public Book() {}
	public Book(String category, String name, int price, double discount) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
}