package kr.s04.constructor;

public class CarMain03 {
	// 생성자 오버로딩
	public CarMain03(int n) {
		this(String.valueOf(n)); // 생성자 내에서 또 다른 생성자를 호출할 때는 생성자명을 쓸 수 없고 this를 사용; 생성자명으로 호출하는 것은 객체 생성시에, new 연산자 다음에만 허용됨  
	}
	public CarMain03(float n) {
		// System.out.println("float 데이터 변환"); // 생성자 내에서 또 다른 생성자를 호출하기 전에 수행문을 배치하면 오류 발생; 다른 생성자 호출을 우선적으로 처리해야 할 중요한 초기화 작업으로 간주하기 때문
		this(String.valueOf(n));
		System.out.println("float 데이터 변환");
	}
	public CarMain03(String s) {
		System.out.println(s + "의 길이 : " + s.length());		
	}

	public static void main(String[] args) {
		CarMain03 cm1 = new CarMain03(2000); // 메서드에서 했던 문자열로 만들어 길이 구하는 작업을 수행할 수 있지만, 객체 생성시의 1회만 수행 가능
		CarMain03 cm2 = new CarMain03(3.141592f);
		CarMain03 cm3 = new CarMain03("Hello");
	}
}