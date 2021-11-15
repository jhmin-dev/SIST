package kr.s02.overloading;

public class OverloadingMain02 {
	// 전달되는 인자의 자료형을 String으로 변환하여 문자열의 길이를 구하는 메서드 만들기
	public void getLength(int n) {
		String s = String.valueOf(n);
		getLength(s); // println을 반복적으로 쓰는 대신, 이미 정의한 메서드를 호출; s가 String이기 때문에 인자가 String인 getLength를 호출하게 됨
	}
	void getLength(float n) {
		String s = String.valueOf(n);
		getLength(s);
	}
	private void getLength(String s) {
		System.out.println(s + "의 길이 : " + s.length());
	}
	
	public static void main(String[] args) {
		OverloadingMain02 om = new OverloadingMain02();
		om.getLength(1000); // 1, 0, 0, 0 각각이 문자로 취급되는 문자열의 길이를 구함
		om.getLength(3.14f); // 3, ., 1, 4 각각이 문자로 취급되는 문자열의 길이를 구함
		om.getLength("Hello");
	}
}