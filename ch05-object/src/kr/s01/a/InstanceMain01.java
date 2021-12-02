package kr.s01.a;
public class InstanceMain01 { // 클래스의 기본 구조
	// 필드
	int var1; // 멤버 변수
	String var2; // 멤버 변수
	
	// 생성자
	public InstanceMain01() {}
	
	// 멤버 메서드
	public int sum(int a, int b) { // 메서드에 인자값을 입력하면
		return a + b; // 정의된 연산을 수행하여 결과값을 반환
	}
	
	public static void main(String[] args) {
		// 객체 선언; 주소가 들어갈 참조 변수를 선언하는 것
		InstanceMain01 me;

		// 객체 생성; 클래스명과 동일한 생성자를 호출해 객체 생성을 유도
		me = new InstanceMain01();

		// 객체의 멤버 변수에 데이터 저장
		me.var1 = 10;
		me.var2 = "가을";

		// 객체의 멤버 변수에 저장된 데이터 읽기
		System.out.println(me.var1 + ", " + me.var2);

		// 객체의 멤버 메서드에 데이터 전달하고 결과값을 변수에 저장(=메서드 동작)
		int result = me.sum(10, 20);
		System.out.println("result = " + result);
	}
}