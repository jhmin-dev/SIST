package kr.s04.overriding;
// 부모 클래스
class Dad {
	public String getLunch() {
		return "밥";
	}
}
// 자식 클래스
class Son extends Dad {
	
}
// 자식 클래스
class Daughter extends Dad {
	@Override
	public String getLunch() {
		return "빵";
	}
}

public class OverridingMain02 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println("아들은 " + s.getLunch() + "을 먹는다.");
		
		Daughter d = new Daughter();
		System.out.println("딸은 " + d.getLunch() + "을 먹는다.");
	}
}