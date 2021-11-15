package kr.s05.wrapper;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true; // 기본 자료형 데이터
		Boolean wrap_b = new Boolean(b); // 명시적 객체 생성; deprecated됨
		Boolean wrap_b2 = b; // 암시적 객체 생성
		System.out.println(wrap_b2); // 참조 자료형 데이터
		
		Integer wrap_i = new Integer(200);
		Integer wrap_i2 = 200;
		System.out.println(wrap_i2);
	}
}