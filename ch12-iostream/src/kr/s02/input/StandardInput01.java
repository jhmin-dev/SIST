package kr.s02.input;

import java.io.IOException;

public class StandardInput01 {
	public static void main(String[] args) {
		// �ڹ��� �⺻ �Է� ó��
		try { // InputStream�� �޼��� ����, try~catch�� �ۼ����� ������ ������ ����
			System.out.print("������ 1�� �Է� > ");
			int a = System.in.read(); // read() �޼���� ���� �ϳ��� �Է¹޾� ASCII �ڵ�� ��ȯ
			System.out.println(a + ", " + (char)a); // ASCII �ڵ�� ASCII �ڵ带 char�� ĳ������ ��� ���
			
			System.in.read(); // �ռ� �Է¿��� ���͸� �Է��Ͽ� ���޵� \r�� ���
			System.in.read(); // �ռ� �Է¿��� ���͸� �Է��Ͽ� ���޵� \n�� ���
			
			System.out.print("���� 1�� �Է� > ");
			int b = System.in.read();
			System.out.println(b-48); // ASCII �ڵ��� ��� ���� 0�� 48�� ���� �����Ƿ�, �Է��� ���ڸ� �״�� ����ϰ� ���� ��� �� ���� �ʿ�
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}