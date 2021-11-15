package kr.s06.animal;

public class AnimalMain {
	public static void main(String[] args) {
		// �⺻ �����ڸ� �̿��Ͽ� ��ü ����
		Animal a1 = new Animal();
		// �⺻ ���� ����
		a1.setName("�⸰");
		a1.setAge(10);
		a1.setFly(false);
		// ���� ���
		System.out.println("�̸� : " + a1.getName());
		System.out.println("���� : " + a1.getAge());
		System.out.println("���� ���� : " + (a1.isFly() ? "����" : "�Ұ���")); // ���� �����ڸ� �̿��ؼ� true�� �� ����, false�� �� �Ұ��� ���; �켱���� ������ ������ �Ұ�ȣ �ʿ�
		
		System.out.println();
		
		// �����ڷ� �⺻ ���� ����
		Animal a2 = new Animal("�ⷯ��", 3, true);
		// ���� ���
		System.out.println("�̸� : " + a2.getName());
		System.out.println("���� : " + a2.getAge());
		System.out.println("���� ���� : " + printFly(a2.isFly())); // ���� Ŭ������ static �޼���� Ŭ������ ������� �ʰ� ȣ�� ����
	}
	// ���� ������ �̿��ϴ� �޼��� �����; �޼��� ��ġ�� main ��, �Ʒ� ����
	private static String printFly(boolean fly) { // ��ü ���� ���� ȣ�� ����
		return fly ? "����" : "�Ұ���";
	}
}