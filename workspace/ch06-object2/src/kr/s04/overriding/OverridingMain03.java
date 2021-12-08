package kr.s04.overriding;

class People {
	
}

class Animal {
	// Object의 메서드를 오버라이딩
	@Override public String toString() {
		return "Animal";
	}
}

public class OverridingMain03 {
	public static void main(String[] args) {
		People p = new People();
		System.out.println(p.toString()); // Object의 toString()
		
		Animal a = new Animal();
		System.out.println(a.toString()); // Object의 toString()을 재정의
		System.out.println(a);
	}
}