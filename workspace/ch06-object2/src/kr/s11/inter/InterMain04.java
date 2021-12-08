package kr.s11.inter;

interface I {
	// 추상 메서드
	public abstract void play();
}

// 인터페이스 I를 클래스 B에 구현
class B implements I {
	@Override public void play() {
		System.out.println("피아노를 연주합니다.");
	}
	public void study() {
		System.out.println("외국어를 공부합니다.");
	}
}

public class InterMain04 {
	public static void main(String[] args) {
		B bp = new B();
		bp.play();
		bp.study();
		
		I i = bp; // 클래스 자료형에서 인터페이스 자료형으로 자동 형변환
		i.play();
		// i.study(); // 호출 범위를 벗어나므로 호출 불가
		
		B bp2 = (B)i; // 인터페이스 자료형에서 클래스 자료형으로 강제 형변환
		bp2.play();
		bp2.study();
	}
}