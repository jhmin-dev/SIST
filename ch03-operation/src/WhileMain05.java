public class WhileMain05 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int a, total = 0;
		System.out.println("0 ������ �Է¹��� ������ �� ���ϱ�");
		
		// �ʱ�� ���� ������ ���������� ����; ������ ���� ������ ��� ���̵� ���ڿ��� 2�� ������ �ʱ�� ���� ���´� 1���� ���� �ڵ尡 �� �����
		while(true) {
			System.out.print("������ ���� �Է� : ");
			a = input.nextInt();
			if(a == 0) {
				break; // while�� Ż��
			}
			total += a; // ����
		}
		
		System.out.println("total = " + total); // ������ ������ ���
		
		input.close();
	}
}