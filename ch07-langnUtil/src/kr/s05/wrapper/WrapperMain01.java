package kr.s05.wrapper;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true; // �⺻ �ڷ��� ������
		Boolean wrap_b = new Boolean(b); // ����� ��ü ����; deprecated��
		Boolean wrap_b2 = b; // �Ͻ��� ��ü ����
		System.out.println(wrap_b2); // ���� �ڷ��� ������
		
		Integer wrap_i = new Integer(200);
		Integer wrap_i2 = 200;
		System.out.println(wrap_i2);
	}
}