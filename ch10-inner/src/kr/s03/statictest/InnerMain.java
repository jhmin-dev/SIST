package kr.s03.statictest;

public class InnerMain {
	// static 내부 클래스
	public static class StaticInner {
		int iv = 100;
		static int cv = 200; // 내부 클래스를 static으로 지정하지 않으면 컴파일 에러
		public void fun() {
			System.out.println("fun 메서드");
		}
		public static void make() { // 내부 클래스를 static으로 지정하지 않으면 컴파일 에러
			System.out.println("make 메서드");
		}
	}
	
	public static void main(String[] args) {
		// static 내부 클래스의 static 변수나 static 메서드에 접근시 .으로 외부 클래스명을 함께 명시해야 함
		System.out.println(InnerMain.StaticInner.cv);
		InnerMain.StaticInner.make();
		// static 내부 클래스의 객체는 (외부 클래스 객체 생성을 거치지 않고) 단독으로 생성
		InnerMain.StaticInner si = new InnerMain.StaticInner();
		// static 내부 클래스의 인스턴스 변수나 인스턴스 메서드는 객체 생성 후 호출 가능
		System.out.println(si.iv);
		si.fun();
	}
}