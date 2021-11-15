package kr.s01.extension;
// 부모 클래스
class A {
	int x = 100; // 접근 제한자를 생략시 default로 설정되며, 같은 패키지 내에서 호출 가능
	private int y = 200; // 같은 클래스 내에서만 호출 가능하도록 은닉화
	
	public int getY() {
		return y;
	}
}
// 자식 클래스
class B extends A {
	int z = 300;
}

public class ExtensionMain03 {
	public static void main(String[] args) {
		B bp = new B();
		System.out.println(bp.x);
		// System.out.println(bp.y); // private 멤버 변수는 상속 관계를 맺어도 같은 클래스가 아니기 때문에 호출 불가
		System.out.println(bp.getY()); // 부모 클래스에서 public 메서드를 만들어두면 은닉화된 y의 값을 복사해서 전달받을 수 있음
		System.out.println(bp.z);
	}
}