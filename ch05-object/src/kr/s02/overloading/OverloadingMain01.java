package kr.s02.overloading;

public class OverloadingMain01 {
	
	public void print(int n) {
		System.out.println("정수 n = " + n);
	}
	/*
	public void print(int a) { // 인자의 수를 점검하고, 자료형을 점검했으나 차이가 없어 동일한 메서드로 인식됨
		System.out.println("정수 a = " + a);
	}
	*/
	public void print(double a) { // 인자의 자료형이 다르기 때문에 다른 메서드로 인식됨
		System.out.println("실수 a = " + a);
	}
	public void print(double n, long a) {
		System.out.println("실수 n = " + n + ", 정수 a = " + a);
	}
	public void print(long a, double n) { // 인자 자료형들의 배치 순서가 다르기 때문에 다른 메서드로 인식됨
		System.out.println("실수 n = " + n + ", 정수 a = " + a);
	}
	public static void main(String[] args) {
		OverloadingMain01 ot = new OverloadingMain01();
		ot.print(1000);
		ot.print(20d);
		ot.print(20d, 1000l);
		ot.print(1000l, 20d);
	}
}