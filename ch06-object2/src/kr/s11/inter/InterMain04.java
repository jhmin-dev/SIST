package kr.s11.inter;

interface I {
	// �߻� �޼���
	public abstract void play();
}

// �������̽� I�� Ŭ���� B�� ����
class B implements I {
	@Override public void play() {
		System.out.println("�ǾƳ븦 �����մϴ�.");
	}
	public void study() {
		System.out.println("�ܱ�� �����մϴ�.");
	}
}

public class InterMain04 {
	public static void main(String[] args) {
		B bp = new B();
		bp.play();
		bp.study();
		
		I i = bp; // Ŭ���� �ڷ������� �������̽� �ڷ������� �ڵ� ����ȯ
		i.play();
		// i.study(); // ȣ�� ������ ����Ƿ� ȣ�� �Ұ�
		
		B bp2 = (B)i; // �������̽� �ڷ������� Ŭ���� �ڷ������� ���� ����ȯ
		bp2.play();
		bp2.study();
	}
}