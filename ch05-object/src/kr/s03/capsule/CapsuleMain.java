package kr.s03.capsule;

class Capsule {
	// 은닉화; 중요한 요소를 감춤
	private int a; // 변수를 같은 클래스에서만 접근 가능하도록 제한

	// 캡슐화; 은닉화된 요소를 대신할 수 있는 요소를 만드는 것
	public void setA(int n) { // 외부에서 데이터를 받아 오는 메서드
		if(n>=0) { // 데이터 검증
			a = n;
		}
		else {
			System.out.println("음수는 허용되지 않습니다.");
		}
	} 	
	public int getA() { // 외부에서 데이터를 읽게 하는 메서드
		return a;
	}
}

public class CapsuleMain {
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		// cap.a = -10; // 객체 cap의 멤버 필드 a는 접근 지정자(=접근 제한자)가 private이기 때문에 다른 클래스에서 호출 불가능
		cap.setA(100); // 메서드를 통해 변수에 데이터를 저장
		System.out.println(cap.getA()); // 메서드를 통해 변수의 데이터를 호출
		
		System.out.println("========");
		
		cap.setA(-10); // 잘못된 데이터 전달시 메서드에서 차단되므로 변수의 데이터는 보호됨
		System.out.println(cap.getA());
	}
}