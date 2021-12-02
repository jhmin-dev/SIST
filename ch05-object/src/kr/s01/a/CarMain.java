package kr.s01.a;
class Car { // 부 클래스
	// 멤버 변수 역시 초기값을 지정해줄 수 있음
	String company = "현대자동차";
	String model = "아이오닉 5";
	String color = "은색";
	int maxSpeed = 350;
	int speed;
}

public class CarMain { // 주 클래스
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		Car myCar = new Car();
		
		// 객체의 멤버 변수에 저장된 데이터 읽기
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색상 : " + myCar.color);
		System.out.println("최대속력 : " + myCar.maxSpeed);
		System.out.println("현재속력 : " + myCar.speed); // 멤버 변수에 초기값을 지정해주지 않은 경우, 자료형의 기본값으로 초기화됨; 정수의 경우 0, String의 경우 null(객체를 만들지 않아 주소가 없다는 의미)
		
		// 멤버 변수의 값 변경
		myCar.speed = 60;
		System.out.println("수정된 현재속력 : " + myCar.speed);
	}
}