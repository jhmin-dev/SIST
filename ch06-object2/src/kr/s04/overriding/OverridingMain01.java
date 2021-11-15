package kr.s04.overriding;
// 부모 클래스
class GrandParent {
	public String getCar() {
		return "구형 자동차";
	}
}
// 자식 클래스
class Father extends GrandParent {
	// 메서드 오버라이딩; 메서드의 형식은 같고 내용만 교체
	@Override
	public String getCar() {
		return "신형 자동차";
	}
}
// 자식 클래스
class Uncle extends GrandParent {
	
}

public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(ft.getCar()); // GrandParent에서 상속받은 메서드 대신 Father에서 재정의한 메서드가 호출됨
		
		Uncle uc = new Uncle();
		System.out.println(uc.getCar()); // GrandParent에서 상속받은 메서드가 호출됨
	}
}