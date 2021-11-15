package kr.s02.mathtest;

public class MathMain {
	public static void main(String[] args) {
		int a = Math.abs(-10);
		System.out.println("-10�� ���밪 : " + a);
		
		double b = Math.ceil(3.3);
		System.out.println("3.3�� �ø� : " + b);
		
		double c = Math.floor(3.7);
		System.out.println("3.7�� ���� : " + c);
		
		int d = Math.round(3.7f); // round() �޼����� ��� float ���ڴ� int�� ��ȯ�ϰ� double ���ڴ� long���� ��ȯ
		System.out.println("3.7�� �ݿø� : " + d);
		
		int e = Math.max(3, 5);
		System.out.println("3�� 5 �� �ִ� : " + e);
		
		int f = Math.min(4, 7);
		System.out.println("4�� 7 �� �ּڰ� : " + f);
	}
}