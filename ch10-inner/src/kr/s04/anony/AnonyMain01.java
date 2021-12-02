package kr.s04.anony;

class Inner6 {
	int y = 200;
	public void disp() {
		System.out.println("Inner6의 disp 메서드");
	}	
}

public class AnonyMain01 {
	// 멤버 메서드
	public void fun() {
		// 로컬 내부 클래스 정의
		class InnerTest extends Inner6 {
			int x = 300;
			public void make() {
				System.out.println("make 메서드");
			}
			@Override
			public void disp() {
				System.out.println("InnerTest의 disp 메서드");
			}
		}
		// 로컬 내부 클래스의 객체 생성
		InnerTest inner = new InnerTest();
		// 로컬 내부 클래스의 멤버 호출
		System.out.println(inner.y); // 상속받은 변수 호출
		inner.disp(); // 재정의된 메서드 호출
		System.out.println(inner.x);
		inner.make();	
		Inner6 i6 = inner; // 부모 클래스 자료형으로 업캐스팅
		System.out.println(i6.y);
		i6.disp(); // 재정의된 메서드 호출
		// System.out.println(i6.x); // 자식 클래스 영역의 변수 호출 불가
		// i6.make(); // 자식 클래스 영역의 메서드 호출 불가
	}
	
	public static void main(String[] args) {
		AnonyMain01 an = new AnonyMain01();
		an.fun();
	}
}