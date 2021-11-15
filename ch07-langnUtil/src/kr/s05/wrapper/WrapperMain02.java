package kr.s05.wrapper;

public class WrapperMain02 {
	public static void main(String[] args) {
		// 명시적으로 객체 생성
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		
		// 연산
		int result = obj1.intValue() + obj2.intValue(); // intVaule() 메서드를 이용해 객체의 데이터를 int로 반환
		System.out.println("result = " + result);
		
		// 암시적으로 객체 생성
		Integer obj3 = 10;
		Integer obj4 = 20;
		int result2 = obj3 + obj4; // 자동 Boxing, Unboxing이 일어나므로 별도의 메서드 필요 없이 Integer 객체끼리 바로 연산하고 그 결과를 int 변수에 저장 가능
		System.out.println("result2 = " + result2);
	}
}