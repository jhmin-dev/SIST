package kr.s01.a;
public class MethodMain01 {
	// ��ȯ�ϴ� �����Ͱ� �ִ� ���
	public int add(int a, int b){
		return a + b;
	}
	
	// ��ȯ�ϴ� �����Ͱ� ���� ���
	public void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) { // main �޼���� ��ȯ�ϴ� �����Ͱ� ���� void�� �޼���
		// ��ü ���� �� ����
		MethodMain01 method = new MethodMain01(); // �����ڴ� ������� �ʾƵ� ȣ�� ����
		
		// ��ȯ�ϴ� �����Ͱ� �ִ� �޼��� ȣ��
		int result = method.add(5, 8);
		System.out.println("result = " + result);
		
		// ��ȯ�ϴ� �����Ͱ� ���� �޼��� ȣ��
		method.print("����"); // void�� �޼���� �����Ͱ� �����Ƿ� ������ ������ �� ����
	}
}