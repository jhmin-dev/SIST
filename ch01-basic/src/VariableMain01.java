public class VariableMain01 {
	public static void main(String[] args) {
		// ����(Variable)�� ���� ������ �� �ִ� �޸��� ����

		// ���� ����
		int num; // �ڷ����� �����ؾ� ��; �������� ���� ������ ������ ����(num�̶�� �޸� ���� �Ҵ�)

		// ������ �ʱ�ȭ
		num = 17; // ������ ����(num�� ����Ű�� �� �޸� ����)�� 17�� ����(����)
		
		// ���
		System.out.println(num); // num�� ���� �޸� ������ ������ ���� ���
		
		// ���� ���� �� �ʱ�ȭ
		int number = 20; // �޸� ������ �Ҵ��ϰ� 20�� ����
		
		// ���
		System.out.println(number);
		
		// ������ �������� ����� ���� �߻�(�������� unique�ؾ� ��)
		// int number = 30;
		
		// ������ ������ ������ ����
		int number2 = 100;
		System.out.println(number2);
		number2 = 90;
		System.out.println(number2);
		
		System.out.println("========");
		
		// ������ �ڷ����� ���� ����� �� ��° ������ ���� �ڷ����� ���� ����
		// int a = 10;
		// int b = 20;
		int a = 10, b = 20;
		int result = a + b;
		System.out.printf("result = %d\n", result);
		
		// �� �����ڴ� ���ڿ��� ���� �ִ� ��� ������ �ƴ϶� ������ ������(������ ��� ���� ����)
		System.out.println("��� = " + a + b); // 1020 ���; ���ڿ� ������ ���ڰ� ���� ��� �����ؼ� �� ���ڿ� ����
		System.out.println("��� = " + (a + b)); // 30 ���; ���ڳ����� ���� ���� ���� �� ���ڿ� ����
		System.out.println(a + b + " = ���"); // 30 ���; ���ڵ��� ���ڿ� �տ� ���� ������ ���� ���� ���� �� ���ڿ� ����
		System.out.println(a + b); // 30 ���
		
		// ���� ���� �� �ʱ�ȭ���� ������ �����̳� ��� �Ұ�(���� �߻�)
		int no;
		// System.out.println(no);
	}
}