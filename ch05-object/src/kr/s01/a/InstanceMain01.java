package kr.s01.a;
public class InstanceMain01 { // Ŭ������ �⺻ ����
	// �ʵ�
	int var1; // ��� ����
	String var2; // ��� ����
	
	// ������
	public InstanceMain01() {}
	
	// ��� �޼���
	public int sum(int a, int b) { // �޼��忡 ���ڰ��� �Է��ϸ�
		return a + b; // ���ǵ� ������ �����Ͽ� ������� ��ȯ
	}
	
	public static void main(String[] args) {
		// ��ü ����; �ּҰ� �� ���� ������ �����ϴ� ��
		InstanceMain01 me;

		// ��ü ����; Ŭ������� ������ �����ڸ� ȣ���� ��ü ������ ����
		me = new InstanceMain01();

		// ��ü�� ��� ������ ������ ����
		me.var1 = 10;
		me.var2 = "����";

		// ��ü�� ��� ������ ����� ������ �б�
		System.out.println(me.var1 + ", " + me.var2);

		// ��ü�� ��� �޼��忡 ������ �����ϰ� ������� ������ ����(=�޼��� ����)
		int result = me.sum(10, 20);
		System.out.println("result = " + result);
	}
}