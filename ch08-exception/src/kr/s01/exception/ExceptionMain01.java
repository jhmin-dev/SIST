package kr.s01.exception;

public class ExceptionMain01 {
	public static void main(String[] args) {
		int[] array = {10,20,30};
		// ���������� ���ܸ� �߻���Ű�� ���� ���� �ε��� 3�� ȣ��
		for(int i=0;i<=array.length;i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		} // for�� ����
		System.out.println("���α׷� ���� ����"); // ���� �߻����� ���α׷� ������ ����Ǿ� ��µ��� ����
	}
}