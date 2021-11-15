package kr.s06.poly;
// 부모 클래스
class A {
	public void make() {
		System.out.println("make 메서드");
	}
}
// 자식 클래스
class B extends A {
	public void play() {
		System.out.println("play 메서드");
	}
}

public class PolyMain02 {
	public static void main(String[] args) {
		B bp = new B();
		bp.make();
		bp.play();
		
		A ap = bp; // bp의 주소를 복사해서 ap에 전달; 업캐스팅
		ap.make(); // ap는 bp의 멤버에 접근 가능하지만, 호출 범위가 부모 영역으로 제한됨
		// ap.play(); // 호출 범위를 벗어나 호출 불가
		
		B bp2 = (B)ap; // ap의 주소를 복사해서 bp2에 전달; 다운캐스팅
		bp2.make();
		bp2.play(); // 자료형을 통해 호출 범위를 늘리거나 줄일 수 있음
	}
}