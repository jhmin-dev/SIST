package kr.s01.string;

public class StringMain02 {
	public static void main(String[] args) {
		String s1 = "This is false";
		
		int index = s1.indexOf('s');
		System.out.println("���� s�� ó������ ������ ��ġ : " + index);
		
		index = s1.indexOf("is"); // indexOf �޼����� ��� ��ȯ���� 1���̹Ƿ�, ���ڿ��� ��ġ�� �ش� ���ڿ�(=is)�� ù ��° ����(=i)�� ��ġ�� ��ȯ
		System.out.println("���ڿ� is�� ��ġ : " + index);
		
		index = s1.lastIndexOf('s');
		System.out.println("���� s�� ���������� ������ ��ġ : " + index);
		
		char c = s1.charAt(8); // �Է��� �ε������� �ش��ϴ� ���ڸ� ��ȯ
		System.out.println("������ ���� : " + c);
		
		index = s1.indexOf('F'); // ��ҹ��ڸ� �����ϸ�, ���ڿ��� ���Ե��� ���� ���ڴ� -1�� ��ȯ
		System.out.println(index);
		index = s1.indexOf('f');
		
		String str = s1.substring(index); // ������ �ε������� ������ �ε��������� ���ڿ��� ����
		System.out.println("�ҹ��� f���� �������� ���ڿ��� ���� : " + str);
		
		str = s1.substring(index, index+3); // ���� �ε������� �� �ε��� ���������� ���ڿ��� ����(=�� �ε����� ���Ե��� ����)
		System.out.println("�ε��� 8���� �ε��� 11 ���������� ���ڿ� ���� : " + str);
		
		int length = s1.length();
		System.out.println("���ڿ� s1�� ���� : " + length);
		
		String[] array = s1.split(" "); // ������ �����ڷ� �Ͽ� ���ڿ��� �ڸ��� �迭�� ��ȯ
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}
	}
}