package kr.s04.thistest;

public class LocalVariable { // Ŭ���� ���� ����
	int b = 200; // ��� ����; ���� ��ü�� �޼���鿡�� ��� ȣ�� ����
	
	public void make() {
		int a = 100; // ���� ����; make �޼��带 ������ ���� ȣ�� ����
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
	
	public void fun() {
		// System.out.println("a : " + a); // fun �޼��� �ȿ��� a ������ ���ǵ��� �ʾƼ� ȣ�� �Ұ�
		System.out.println("b : " + b);
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) { // i�� for�� �� ���� ���� ����
			System.out.print(i+"\t");
		} // for�� �� ����� i�� �Ҹ��ϹǷ� ���� ���๮���� ȣ�� �Ұ�
		// System.out.println(i);
		
		int a; // a�� main �� ���� ���� ����
		for(a=1;a<=5;a++) {
			System.out.print(a + "\t");
		} // �ݺ����� ����Ǿ main �� �ȿ� a�� �־� ���� ���๮���� ȣ�� ����
		System.out.println(a);
	} // main �� ����� a �Ҹ�
} // Ŭ���� ���� ��
