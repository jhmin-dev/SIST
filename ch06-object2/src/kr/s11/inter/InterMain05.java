package kr.s11.inter;

interface Inter {
	// 추상 메서드
	public abstract void play();
}

class A implements Inter {
	@Override public void play() {
		System.out.println("피아노를 연주합니다.");
	}
}

class C implements Inter {
	@Override public void play() {
		System.out.println("첼로를 연주합니다.");
	}
}

class Admin {
	public void autoPlay(Inter i) {
		// i를 통해 객체에 접근해서 메서드를 호출함; 공통 자료형을 사용하지 못하면 메서드를 클래스 자료형마다 별도로 만들어야 하며, Object 자료형의 경우 play() 메서드 호출 불가
		i.play();
	}
}

public class InterMain05 {
	public static void main(String[] args) {
		Admin ad = new Admin();
		ad.autoPlay(new A());
		ad.autoPlay(new C());
	}
}