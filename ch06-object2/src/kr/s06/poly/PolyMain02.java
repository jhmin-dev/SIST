package kr.s06.poly;
// �θ� Ŭ����
class A {
	public void make() {
		System.out.println("make �޼���");
	}
}
// �ڽ� Ŭ����
class B extends A {
	public void play() {
		System.out.println("play �޼���");
	}
}

public class PolyMain02 {
	public static void main(String[] args) {
		B bp = new B();
		bp.make();
		bp.play();
		
		A ap = bp; // bp�� �ּҸ� �����ؼ� ap�� ����; ��ĳ����
		ap.make(); // ap�� bp�� ����� ���� ����������, ȣ�� ������ �θ� �������� ���ѵ�
		// ap.play(); // ȣ�� ������ ��� ȣ�� �Ұ�
		
		B bp2 = (B)ap; // ap�� �ּҸ� �����ؼ� bp2�� ����; �ٿ�ĳ����
		bp2.make();
		bp2.play(); // �ڷ����� ���� ȣ�� ������ �ø��ų� ���� �� ����
	}
}