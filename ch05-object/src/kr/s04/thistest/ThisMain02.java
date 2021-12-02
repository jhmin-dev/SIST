package kr.s04.thistest;

class ThisTest {
	// 은닉화
	private int a;

	// 캡슐화
	public void setA(int a) { // 지역 변수 a 선언
		// a = a; // {} 블럭 내에서 a는 지역 변수로 인식됨
		this.a = a; // 멤버 변수명과 지역 변수명을 동일하게 명시(자바 표준)했기 때문에, 멤버 변수와 지역 변수를 구분하기 위해 this를 사용
	}
	public int getA() {
		return a;
	}	
}

public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		tt.setA(200);
		System.out.println(tt.getA());
	}
}