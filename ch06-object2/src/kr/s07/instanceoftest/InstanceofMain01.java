package kr.s07.instanceoftest;

class Parent {
	@Override
	public String toString() {
		return "Parent 클래스";
	}
}

class Child extends Parent {
	@Override
	public String toString() {
		return "Child 클래스";
	}
}

public class InstanceofMain01 {
	public static void main(String[] args) {
		Parent p = new Parent();
		
		// 컴파일시에는 오류가 없으나, 실행시 오류 발생
		// Child ch = (Child)p;
		
		// 객체 p가 Child 자료형으로 캐스트할 수 있는지를 instanceof 연산자로 검증
		if(p instanceof Child) {
			Child ch2 = (Child)p;
			System.out.println(ch2);
		}
		else {
			System.out.println(p);
		}
	}
}