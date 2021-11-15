package kr.s02.mathtest;

public class MathMain {
	public static void main(String[] args) {
		int a = Math.abs(-10);
		System.out.println("-10의 절대값 : " + a);
		
		double b = Math.ceil(3.3);
		System.out.println("3.3의 올림 : " + b);
		
		double c = Math.floor(3.7);
		System.out.println("3.7의 버림 : " + c);
		
		int d = Math.round(3.7f); // round() 메서드의 경우 float 인자는 int로 반환하고 double 인자는 long으로 반환
		System.out.println("3.7의 반올림 : " + d);
		
		int e = Math.max(3, 5);
		System.out.println("3과 5 중 최댓값 : " + e);
		
		int f = Math.min(4, 7);
		System.out.println("4과 7 중 최솟값 : " + f);
	}
}