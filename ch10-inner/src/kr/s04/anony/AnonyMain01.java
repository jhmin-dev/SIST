package kr.s04.anony;

class Inner6 {
	int y = 200;
	public void disp() {
		System.out.println("Inner6�� disp �޼���");
	}	
}

public class AnonyMain01 {
	// ��� �޼���
	public void fun() {
		// ���� ���� Ŭ���� ����
		class InnerTest extends Inner6 {
			int x = 300;
			public void make() {
				System.out.println("make �޼���");
			}
			@Override
			public void disp() {
				System.out.println("InnerTest�� disp �޼���");
			}
		}
		// ���� ���� Ŭ������ ��ü ����
		InnerTest inner = new InnerTest();
		// ���� ���� Ŭ������ ��� ȣ��
		System.out.println(inner.y); // ��ӹ��� ���� ȣ��
		inner.disp(); // �����ǵ� �޼��� ȣ��
		System.out.println(inner.x);
		inner.make();	
		Inner6 i6 = inner; // �θ� Ŭ���� �ڷ������� ��ĳ����
		System.out.println(i6.y);
		i6.disp(); // �����ǵ� �޼��� ȣ��
		// System.out.println(i6.x); // �ڽ� Ŭ���� ������ ���� ȣ�� �Ұ�
		// i6.make(); // �ڽ� Ŭ���� ������ �޼��� ȣ�� �Ұ�
	}
	
	public static void main(String[] args) {
		AnonyMain01 an = new AnonyMain01();
		an.fun();
	}
}