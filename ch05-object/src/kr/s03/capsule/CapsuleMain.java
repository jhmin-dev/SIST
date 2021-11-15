package kr.s03.capsule;

class Capsule {
	// ����ȭ; �߿��� ��Ҹ� ����
	private int a; // ������ ���� Ŭ���������� ���� �����ϵ��� ����

	// ĸ��ȭ; ����ȭ�� ��Ҹ� ����� �� �ִ� ��Ҹ� ����� ��
	public void setA(int n) { // �ܺο��� �����͸� �޾� ���� �޼���
		if(n>=0) { // ������ ����
			a = n;
		}
		else {
			System.out.println("������ ������ �ʽ��ϴ�.");
		}
	} 	
	public int getA() { // �ܺο��� �����͸� �а� �ϴ� �޼���
		return a;
	}
}

public class CapsuleMain {
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		// cap.a = -10; // ��ü cap�� ��� �ʵ� a�� ���� ������(=���� ������)�� private�̱� ������ �ٸ� Ŭ�������� ȣ�� �Ұ���
		cap.setA(100); // �޼��带 ���� ������ �����͸� ����
		System.out.println(cap.getA()); // �޼��带 ���� ������ �����͸� ȣ��
		
		System.out.println("========");
		
		cap.setA(-10); // �߸��� ������ ���޽� �޼��忡�� ���ܵǹǷ� ������ �����ʹ� ��ȣ��
		System.out.println(cap.getA());
	}
}