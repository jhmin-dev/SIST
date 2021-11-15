package kr.s04.constructor;

class Car {
	String color; // 색상
	String gearType; // 변속기 종류
	int door; // 문의 수
	
	// 기본 생성자; 생략 가능
	// 단 한 번만 호출; 이미 만들어진 객체 안에서 다시 생성자를 호출할 수 없음(멤버가 아니므로)
	// 멤버 변수 초기화
	public Car() {} // {} 블럭에 수행문을 넣어 초기화 작업을 수행할 수 있고, 인자 자료형도 설정할 수 있음
}

public class CarMain01 {
	public static void main(String[] args) {
		Car c1 = new Car(); // new 연산자 다음에 생성자가 와서 멤버 변수를 초기화함
		System.out.println("c1.color : " + c1.color);
		System.out.println("c1.gearType : " + c1.gearType);
		System.out.println("c1.door : " + c1.door);
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;		
		System.out.println(c1.color + ", " + c1.gearType + ", " + c1.door);
		
		// 새롭게 객체를 생성함
		Car c2 = new Car();
		c2.color = "red";
		c2.gearType = "manual";
		c2.door = 5;
		System.out.println(c2.color + ", " + c2.gearType + ", " + c2.door);
	}
}