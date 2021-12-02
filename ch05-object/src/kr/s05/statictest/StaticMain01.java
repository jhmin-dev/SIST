package kr.s05.statictest;

public class StaticMain01 {
	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("c : " + sc1.c + ", count : " + StaticCount.count); // static 변수는 객체에 포함되어 있지 않으므로, 호출시 객체가 아니라 클래스를 통해 접근
		StaticCount sc2 = new StaticCount();
		System.out.println("c : " + sc2.c + ", count : " + sc2.count); // static 변수를 객체를 통해 접근할 경우 오류가 발생하지는 않지만, 정상적으로 호출하는 방법이 아님
		StaticCount sc3 = new StaticCount();
		System.out.println("c : " + sc3.c + ", count : " + StaticCount.count); // 객체의 멤버 변수 c는 객체가 새로 생성될 때마다 초기값 0으로 새로 만들어지고 생성자에 의해 값이 1이 됨; static 변수 count는 한 번만 만들어지고 그 변수를 계속 가져다 쓰기 때문에 생성자가 실행될 때마다 1씩 값이 증가하게 됨
	}
}