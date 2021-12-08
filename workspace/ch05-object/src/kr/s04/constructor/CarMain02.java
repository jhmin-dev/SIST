package kr.s04.constructor;

class Car2 { // 같은 패키지에 같은 클래스가 있으면 충돌
	String color;
	String gearType;
	int door;
	
	// 생성자 오버로딩
	public Car2() {} // 생성자를 하나 이상 명시하면 컴파일러는 명시된 생성자만 이용함; 생성자를 명시하면서 기본 생성자를 이용하려면 기본 생성자 역시 명시해야 함
	public Car2(String c, String g) { // 인자가 있는 생성자를 명시하면, 객체를 생성하면서 원하는 데이터로 초기화 가능
		color = c;
		gearType = g;
		door = 4;
	}
	public Car2(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
	
}

public class CarMain02 {
	public static void main(String[] args) {
		// Car2 c1 = new Car2();
		
		Car2 c2 = new Car2("blue", "auto");
		System.out.println(c2.color + ", " + c2.gearType + ", " + c2.door);
		
		Car2 c3 = new Car2("black", "auto", 2);
		System.out.println(c3.color + ", " + c3.gearType + ", " + c3.door);
		
	}
}
