public class PrintMain05 {
	public static void main(String[] args) {
		// System.out.printf(���˹���, ������)�� �̿��� ���(�������� ������ ǥ���� �� �ִ� ���˹��� ����)
		
		// ����
		System.out.printf("%c", 'A'); // ���˹��ڴ� "" ó���ϸ�, �����Ͱ� ���˹��ڿ� ���޵Ǿ� ���˹��ڰ� ��µ�(println�� �����Ͱ� ��µ�)
		System.out.printf("%c%n", 'B'); // printf�� �⺻������ �ٹٲ޵��� ����, ���˹��ڿ� %n �߰��� �ٹٲ޵�
		System.out.printf("%6c%n", 'C'); // 6�ڸ� Ȯ���ϰ� ������ ����
		System.out.printf("%-6c%n", 'D'); // 6�ڸ� Ȯ���ϰ� ���� ����
		
		System.out.println("========");
		
		// ����
		System.out.printf("%d%n", 67);
		System.out.printf("%,d��%n", 10000); // 3�ڸ� ������ ��ǥ ǥ��+���� ���� ���� �� �߰�
		System.out.printf("%5d%n", 20); // 5�ڸ� Ȯ���ϰ� ������ ����
		System.out.printf("%-5d%n", 20); // 5�ڸ� Ȯ���ϰ� ���� ����
		
		System.out.println("========");

		// �Ǽ�
		System.out.printf("%f%n", 35.896); // %f�� �⺻������ �Ҽ��� �Ʒ� 6�ڸ��� ǥ��
		System.out.printf("%.2f%n", 35.896); // �Ҽ��� �Ʒ� 2�ڸ��� ǥ��(��° �ڸ����� �ݿø�)
		System.out.printf("%10.2f%n", 35.896); // 10�ڸ� Ȯ���ϰ� ������ ����, �Ҽ��� �Ʒ� 2�ڸ� ǥ��
		
		System.out.println("========");
		
		// ���ڿ�
		System.out.printf("%s\n", "����"); // �ٹٲ� ���ڷ� \n�� ��� ����, %n�� ���˹��ڶ� printf������ ���� \n�� print�� println ��� ��� ��� ����
		System.out.printf("%s�� %d���Դϴ�.%n", "����", 98); // ���˹��ڴ� ���� ���� �� ���� ����� �� �ְ�, �� ���˹��ڿ� �����ϴ� �����͸� ,�� ������ ������� �Է���

		// ����
		System.out.printf("%b", true);
	}
}