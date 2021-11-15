package kr.s01.exception;

import java.io.IOException; // BufferedReader�� ���ܸ� ó���ϱ� ���� �ʿ�
import java.io.BufferedReader; // ���������� Scanner���� ���� ����
import java.io.InputStreamReader; // BufferedReader�� ����ϱ� ���� �ʿ�

public class ExceptionMain05 {
	// �޼��忡 throws ���� ����Ͽ� �߻��� ���ɼ��� �ִ� ���� Ŭ�������� ����ϸ�, �޼��� ���� try~catch ���� �����ϰ�, ���ܰ� �߻��ϸ� ���ܸ� �����ϰ� �޼��带 ȣ���� ������ try~catch ���� ����� �� ������ ���ܸ� �絵
	public void printData() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�� �Է� > ");
		int dan = Integer.parseInt(br.readLine()); // readLine() �޼���� \n, \r, \r\n�� ���ŵ� �� ���� �����͸� ���ڿ��� ��ȯ�ϹǷ� ���ڿ� parsing �ʿ�; readLine() �޼��� ���� IOException�� �߻��� �� �ְ�, IOException�� �Ϲ��� Exception�̶� throws Ȥ�� try~catch���� ������ ������ ���� �߻�
		System.out.println(dan + "��");
		System.out.println("========");
		for(int i=1;i<=9;i++) {
			System.out.println(dan + " * " + i + " = " + dan*i);
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain05 ex = new ExceptionMain05();
		// ex.printData(); // throws ����� ����� �޼��� ȣ��� �ǹ������� try~catch �� �ۼ��ؾ� ��
		try {
			ex.printData();
		}
		catch(NumberFormatException e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���ڸ� �Է��ϼ���.");
		}
		catch(IOException e) { // IOException�� �Է� ��� ���ε� ���α׷��� ���� �ߴ��ϰų�, �ý��� ȯ���� �Ҿ����ؼ� System.in�� �Է� ������ ������� �� �߻� �����ϸ� ���������� �߻��ϱ� ������ ���� ó���� �ǹ�ȭ�ϴ� ��; �� ���������� ���α׷� ���� �ߴܽ� parseInt()�� �Է¹��� ���� ���� ������ NumberFormatException�� �Բ� �߻�; ���� �Է¹ޱ� ���� br.close();�� �ڿ��� �����ϸ� IOException �߻�
			System.out.println("����� ���ܰ� �߻��߽��ϴ�.");
		}
	}
}