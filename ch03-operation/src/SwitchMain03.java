public class SwitchMain03 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * ���� 2���� �Է� �ް� ��� ������(+,-,*,/,%)�� �Է¹޾� ������ ������ ����� ����Ͻÿ�.
		 * [��� ����]
		 * ù ��° �� : 7
		 * ������ : +
		 * �� ��° �� : 5
		 * 7 + 5 = 12
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int result = 0;
			
		System.out.print("ù ��° ���� �Է��ϼ��� : ");
		int first = input.nextInt();
		System.out.print("�����ڸ� �Է��ϼ��� : ");
		String operator = input.next();
		System.out.print("�� ��° ���� �Է��ϼ��� : ");
		int second = input.nextInt();
		
		switch(operator) {
		case "+":
			result = first + second; break; // �ٹٲ��� �����ݷ����� �����ϱ� ������ ���๮�� break�� �� ���̾ ��
		case "-":
			result = first - second; break;
		case "*":
			result = first * second; break;
		case "/":
			if(second==0) { // 0���� ������ ������ �����Ϸ� �ϸ� �ڹٿ��� ������ �߻��ϹǷ�, �̸� �ȳ��ϰ� ���� �����Ű�� ����
				System.out.println("\n0���� ���� �� �����ϴ�.");
				System.exit(0); // ���α׷��� �������� ������ ��¹� ����� ���� �ʱ�ȭ�� �� �Ǿ� ������ �߻���
			}
			result = first / second; break;
		case "%":
			if(second==0) {
				System.out.println("\n0���� ���� �� �����ϴ�.");
				System.exit(0);
			}
			result = first % second; break;
		default:
			System.out.println(); // �ܼ� �ٹٲ�
			System.out.println("�����ڸ� �߸� �Է��Ͽ����ϴ�.");
			System.exit(0); // ���α׷� ����; �߸��� ������ �Է��� ��쿡 ��¹��� ������� �ʵ��� �ϱ� ����
		}

		System.out.printf("\n%d %s %d = %d\n", first, operator, second, result);

		input.close();
	}
}