package kr.s06.poly;
// �θ� Ŭ����
class Parent {
	int a = 100;
}
// �ڽ� Ŭ����
class Child extends Parent {
	 int b = 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		
		Parent p = ch; // �ڽ� Ŭ���� Ÿ�Կ��� �θ� Ŭ���� Ÿ������ ����ȯ(=��ĳ����); �ڵ������� ����ȯ��
		System.out.println(p.a);
		// System.out.println(p.b); // Parent Ÿ���� Parent ������ ȣ�� ����(=Child ������ ȣ�� ������ ��� ȣ�� �Ұ�); ch�� �����߱� ������ p�� �޸𸮿� �ִ� ch�� ����� ���� ����������, �ڷ����� ��� ȣ�� ������ �����ϱ� ������ a���� ���� �����ϰ� b���� ���� ����

		// Child ch2 = p;
		Child ch2 = (Child)p; // �θ� Ŭ���� Ÿ�Կ��� �ڽ� Ŭ���� Ÿ������ ���� ����ȯ(=�ٿ�ĳ����); ĳ��Ʈ �����ڸ� �̿��Ͽ� ����� ����ȯ �ؾ� ��
		System.out.println(ch2.a);
		System.out.println(ch2.b);
	}
}