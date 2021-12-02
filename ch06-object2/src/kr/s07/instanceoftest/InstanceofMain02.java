package kr.s07.instanceoftest;
// 부모 클래스
class Car {
	public void drive() {
		System.out.println("주행");
	}
	public void stop() {
		System.out.println("멈춤");
	}
}
// 자식 클래스
class FireEngine extends Car {
	public void getWater() {
		System.out.println("물 뿌리기");
	}
}

public class InstanceofMain02 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) { // fe는 FireEngine 타입 사용 가능
			System.out.println("This is a FireEngine instance");
		}
		
		if(fe instanceof Car) { // fe는 Car 타입 사용 가능
			System.out.println("This is a Car instance");
		}
		
		if(fe instanceof Object) { // fe는 Object 타입 사용 가능; 모든 클래스는 Object 타입으로 형변환 가능
			System.out.println("This is an Object instance");
		}
	}
}