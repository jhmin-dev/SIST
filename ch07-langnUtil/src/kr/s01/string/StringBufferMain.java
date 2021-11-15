package kr.s01.string;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("���� ����!!");
		System.out.println("1 : " + sb);
		
		sb.insert(2, '��'); // insert() �޼��带 �̿��� ���ϴ� �ε����� ���ϴ� ���ڸ� ����; �ε��� ���� �߻�
		System.out.println("2 : " + sb);
		
		sb.append("������ "); // append() �޼��带 �̿��� ���� ���ڿ� �������� ���ϴ� ���ڿ��� ����
		System.out.println("3 : " + sb);
		sb.append("�ÿ��ϴ�!");
		System.out.println("4 : " + sb);

		sb.replace(0, 3, "���డ��!!"); // replace() �޼��带 �̿��� ���� �ε������� �� �ε��� ���������� ���ڿ��� ���ϴ� ���ڿ��� ��ü
		System.out.println("5 : " + sb);
		
		sb.deleteCharAt(0); // deleteCharAt() �޼��带 �̿��� ������ �ε����� ���ڸ� ����; �ε��� ���� �߻�
		System.out.println("6 : " + sb);
		sb.delete(0, 3); // delete() �޼��带 �̿��� ���� �ε������� �� �ε��� ���������� ���ڿ��� ����; �ε��� ���� �߻�
		System.out.println("7 : " + sb);
		
		String str = sb.toString(); // StringBuffer���� String���� ��ȯ; �� Ŭ������ ��� ���谡 �ƴϱ� ������ toString() �޼��带 �̿�
		System.out.println(str);
	}
}