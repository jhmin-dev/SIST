package kr.s04.overriding;

class People {
	
}

class Animal {
	// Object�� �޼��带 �������̵�
	@Override public String toString() {
		return "Animal";
	}
}

public class OverridingMain03 {
	public static void main(String[] args) {
		People p = new People();
		System.out.println(p.toString()); // Object�� toString()
		
		Animal a = new Animal();
		System.out.println(a.toString()); // Object�� toString()�� ������
		System.out.println(a);
	}
}