package kr.s02.overloading;

public class OverloadingMain01 {
	
	public void print(int n) {
		System.out.println("���� n = " + n);
	}
	/*
	public void print(int a) { // ������ ���� �����ϰ�, �ڷ����� ���������� ���̰� ���� ������ �޼���� �νĵ�
		System.out.println("���� a = " + a);
	}
	*/
	public void print(double a) { // ������ �ڷ����� �ٸ��� ������ �ٸ� �޼���� �νĵ�
		System.out.println("�Ǽ� a = " + a);
	}
	public void print(double n, long a) {
		System.out.println("�Ǽ� n = " + n + ", ���� a = " + a);
	}
	public void print(long a, double n) { // ���� �ڷ������� ��ġ ������ �ٸ��� ������ �ٸ� �޼���� �νĵ�
		System.out.println("�Ǽ� n = " + n + ", ���� a = " + a);
	}
	public static void main(String[] args) {
		OverloadingMain01 ot = new OverloadingMain01();
		ot.print(1000);
		ot.print(20d);
		ot.print(20d, 1000l);
		ot.print(1000l, 20d);
	}
}