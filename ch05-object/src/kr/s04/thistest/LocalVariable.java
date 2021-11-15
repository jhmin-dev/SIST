package kr.s04.thistest;

public class LocalVariable { // 클래스 영역 시작
	int b = 200; // 멤버 변수; 같은 객체의 메서드들에서 모두 호출 가능
	
	public void make() {
		int a = 100; // 지역 변수; make 메서드를 구동할 때만 호출 가능
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
	
	public void fun() {
		// System.out.println("a : " + a); // fun 메서드 안에서 a 변수가 정의되지 않아서 호출 불가
		System.out.println("b : " + b);
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) { // i는 for문 블럭 안의 지역 변수
			System.out.print(i+"\t");
		} // for문 블럭 종료시 i가 소멸하므로 이후 수행문에서 호출 불가
		// System.out.println(i);
		
		int a; // a는 main 블럭 안의 지역 변수
		for(a=1;a<=5;a++) {
			System.out.print(a + "\t");
		} // 반복문이 종료되어도 main 블럭 안에 a가 있어 이후 수행문에서 호출 가능
		System.out.println(a);
	} // main 블럭 종료시 a 소멸
} // 클래스 영역 끝
