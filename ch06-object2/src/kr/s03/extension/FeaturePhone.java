package kr.s03.extension;

public class FeaturePhone extends Phone {
	private int pixel; // 사진의 화소 수; 자바에서 일반적으로 멤버 변수의 접근 제한자는 public을 제외하고 사용하며, 지역 변수는 해당 변수가 정의된 메서드의 접근 제한자를 따라감
	
	public int getPixel() {
		return pixel;
	}
	
	public FeaturePhone(String number, String model, String color, int pixel) {
		this.number = number;
		this.model = model;
		this.color = color;
		this.pixel = pixel;
	}
}