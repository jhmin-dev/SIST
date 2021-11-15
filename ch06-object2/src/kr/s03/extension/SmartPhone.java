package kr.s03.extension;

public class SmartPhone extends Phone {
	private String os;

	public String getOs() {
		return os;
	}
	// SmartPhone 객체를 생성하면 메모리에 먼저 Object 영역이 만들어지고(Object 클래스의 멤버가 메모리에 올라감), 다음으로 부모 클래스 영역이 만들어지며(부모 클래스의 멤버가 메모리에 올라감), 마지막으로 자식 클래스 영역이 생성됨(자식 클래스의 멤버가 메모리에 올라감); 세 영역은 별도의 객체가 아니라 하나의 객체이므로 주소는 하나임
	public SmartPhone(String number, String model, String color, String os) {
		this.number = number; // Phone의 number를 상속받았기 때문에 자신(=this)의 것처럼 인식
		this.model = model;
		this.color = color;
		this.os = os;
	}
}