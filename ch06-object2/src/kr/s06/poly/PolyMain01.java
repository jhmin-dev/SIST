package kr.s06.poly;
// 부모 클래스
class Parent {
	int a = 100;
}
// 자식 클래스
class Child extends Parent {
	 int b = 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		
		Parent p = ch; // 자식 클래스 타입에서 부모 클래스 타입으로 형변환(=업캐스팅); 자동적으로 형변환됨
		System.out.println(p.a);
		// System.out.println(p.b); // Parent 타입은 Parent 영역만 호출 가능(=Child 영역은 호출 범위를 벗어나 호출 불가); ch를 복사했기 때문에 p는 메모리에 있는 ch의 멤버에 접근 가능하지만, 자료형이 멤버 호출 범위를 설정하기 때문에 a에만 접근 가능하고 b에는 접근 못함

		// Child ch2 = p;
		Child ch2 = (Child)p; // 부모 클래스 타입에서 자식 클래스 타입으로 강제 형변환(=다운캐스팅); 캐스트 연산자를 이용하여 명시적 형변환 해야 함
		System.out.println(ch2.a);
		System.out.println(ch2.b);
	}
}