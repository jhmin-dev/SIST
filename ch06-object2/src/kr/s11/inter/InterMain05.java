package kr.s11.inter;

interface Inter {
	// �߻� �޼���
	public abstract void play();
}

class A implements Inter {
	@Override public void play() {
		System.out.println("�ǾƳ븦 �����մϴ�.");
	}
}

class C implements Inter {
	@Override public void play() {
		System.out.println("ÿ�θ� �����մϴ�.");
	}
}

class Admin {
	public void autoPlay(Inter i) {
		// i�� ���� ��ü�� �����ؼ� �޼��带 ȣ����; ���� �ڷ����� ������� ���ϸ� �޼��带 Ŭ���� �ڷ������� ������ ������ �ϸ�, Object �ڷ����� ��� play() �޼��� ȣ�� �Ұ�
		i.play();
	}
}

public class InterMain05 {
	public static void main(String[] args) {
		Admin ad = new Admin();
		ad.autoPlay(new A());
		ad.autoPlay(new C());
	}
}