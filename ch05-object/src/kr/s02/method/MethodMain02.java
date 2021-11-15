package kr.s02.method;

public class MethodMain02 {
	// Call by reference
	public void increase(int[] n) { // �迭(��ü)�� �ּҸ� n�� ����
		for(int i=0;i<n.length;i++) { // �ּҰ� ����� n�� ���� �迭�� ����; n�� ref1�� ������ �迭�� ����Ŵ
			n[i]++;
		}
	}
	
	public static void main(String[] args) {
		int[] ref1 = {100, 200, 300}; // �迭�� ����, ����, �ʱ�ȭ
		for(int i=0;i<ref1.length;i++) { // �޼��� ȣ�� ��
			System.out.println("ref1[" + i + "] : " + ref1[i]);
		}
		MethodMain02 me = new MethodMain02(); // ��ü�� ����, ����
		me.increase(ref1); // �޼��� ȣ��
		for(int i=0;i<ref1.length;i++) { // �޼��� ȣ�� ��
			System.out.println("ref1[" + i + "] : " + ref1[i]);
		}
	}
}