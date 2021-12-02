package kr.s04.thistest;

public class ThisMain {
	public ThisMain() {
		System.out.println("객체 생성 : " + this); // this는 객체 내부의 참조 변수 역할; 객체의 참조값을 가지고 있으며 객체 내부에서 객체를 지칭할 때 사용
	}
	
	public static void main(String[] args) {
		ThisMain tt = new ThisMain(); // 생성된 객체 주소의 유니크한 참조값을 참조 변수 tt에 저장; 자바는 주소를 내부적으로만 처리하며, 프로그래머가 같은 객체인지를 판단할 수 있게끔 유니크한 16진수 해시 값만 제공함
		System.out.println("객체 생성 후 : " + tt);
	}
}