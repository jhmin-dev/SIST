package kr.s01.exception;

public class ExceptionMain03 {
	public static void main(String[] args) {
		int var = 50;
		// ���ܰ� �߻��ϸ� ���� ��ü�� �����ǰ�, ���� ��ü�� ���޵� catch ������ �̵��ؼ� ���๮�� ����
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
		}
		// ���� catch�� ���; Exception�� ���� ���� Ŭ������ ���ÿ� ����� ���, ���� ���� Ŭ������ ���� ����ϰ� �������� Exception�� ����ؾ� ���ۻ��� ������ �߻����� ����; �θ� Ŭ������ �ڽ� Ŭ������ ���� ��ü�� ��� ����� �� �ְ�, catch()���� ���������� Ȯ���ϱ� ����
		catch(NumberFormatException e) { // �����Ͱ� "100"�̸� 100���� parsing������ "100?"�̸� ���� �߻�
			System.out.println("���ڰ� �ƴմϴ�.");
		}
		catch(ArrayIndexOutOfBoundsException e) { // ���α׷� ����� ���ڸ� �������� ���� ���, �迭�� ��������� �ʾ� args[0] ȣ��� ���� �߻�
			System.out.println("�Է��� �����Ͱ� �����ϴ�.");
		}
		catch(ArithmeticException e) { // var/0 ����� ���� �߻�
			System.out.println("0���� ���� �� �����ϴ�.");
		}
		catch(Exception e) { // ���ܰ� �߻��� ������ ��������� ��Ȯ�� Ŭ�������� �� ���, �θ� Ŭ���� �ڷ������� �ڵ� ����ȯ�Ͽ� ���� ó�� ����
			System.out.println("���ܰ� �߻��߽��ϴ�.");
		}
		System.out.println("���α׷� ���� ����");
	}
}