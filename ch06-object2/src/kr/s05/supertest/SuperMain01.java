package kr.s05.supertest;
// 부모 클래스
class Dad {
	public String getLunch() {
		return "밥";
	}
}
// 자식 클래스
class Daughter extends Dad {
	@Override
	public String getLunch() {
		return "빵";
	}
	// 부모 클래스 영역의 getLunch 메서드를 호출
	public String getRice() {
		return super.getLunch();
	}
}

public class SuperMain01 {
	public static void main(String[] args) {
		Daughter d  = new Daughter();
		System.out.println("딸은 " + d.getLunch() + "을 먹는다.");
		System.out.println("딸은 월요일에는 " + d.getRice() + "을 먹는다.");
	}
}