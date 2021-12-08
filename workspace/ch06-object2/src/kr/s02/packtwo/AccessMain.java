package kr.s02.packtwo;

import kr.s02.packone.People; // import하지 않으면 패키지가 달라 People 클래스를 생성할 수 없음

public class AccessMain {
	public static void main(String[] args) {
		People p = new People();
		// System.out.println(p.a); // private; 같은 클래스가 아니기 때문에 호출 불가
		// System.out.println(p.b); // default; 같은 패키지가 아니기 때문에 호출 불가
		// System.out.println(p.c); // protected; 같은 패키지도 아니고 상속 관계도 아니기 때문에 호출 불가
		System.out.println(p.d); // public; 접근 제한이 없으므로 호출 가능
	}
}
