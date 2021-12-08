package kr.s02.packtwo;

import kr.s02.packone.People; // import하지 않으면 패키지가 달라 People 클래스를 상속받을 수 없음

class Student extends People {
	public void print() {
		// System.out.println("a = " + a); // private; 상속 관계라도 같은 클래스가 아니므로 호출 불가
		// System.out.println("b = " + b); // default; 상속 관계라도 같은 패키지가 아니므로 호출 불가
		System.out.println("c = " + c); // protected; 상속 관계이므로 다른 패키지라도 호출 가능
		System.out.println("d = " + d); // public; 접근 제한이 없으므로 호출 가능
	}
}

public class AccessMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		s.print();
	}
}