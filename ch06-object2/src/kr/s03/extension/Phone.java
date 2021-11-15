package kr.s03.extension;

public class Phone {
	// 패키지가 달라질 것을 염두에 두고 접근 제한자를 지정
	protected String number;
	protected String model;
	protected String color;
	// Getters; Setters를 만들지 않고 생성자로 기능 대체
	public String getNumber() {
		return number;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
}