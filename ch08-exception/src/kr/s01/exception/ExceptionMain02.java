package kr.s01.exception;

public class ExceptionMain02 {
	public static void main(String[] args) {
		// ���� ó��; ���ܰ� �߻��ص� ���� ����� �� �ֵ��� ���α׷������� ó��
		int[] array = {10, 20, 30};
		
		// ���������� ���� �߻�
		for(int i=0;i<=array.length;i++) {
			// ���� ó��; ���ܴ� ���� �ε����� ȣ���ϴ� ���� �߻�
			try { // ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���
				System.out.println("array[" + i + "] : " + array[i]);
			}
			catch(ArrayIndexOutOfBoundsException e) { // ���� �߻��� catch ������ �̵��Ͽ� ���ܰ� �߻��� ������ ����ϰų� ��ü �ڵ带 ����; catch()���� ���� �߻��� �����Ǵ� ���� ��ü�� �ڷ����� �����ؾ� ��
				System.out.println("���� �ε��� " + i + "��/�� ȣ����");
			}
		} // for�� ����
		System.out.println("���α׷� ���� ����"); // ���� ó���� �߱� ������ ���ܰ� �߻��ص� ��µ�
	}
}