public class WhileMain04 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int a, total = 0;
		System.out.println("0 ������ �Է¹��� ������ �� ���ϱ�");
		System.out.print("������ ���� ������ �Է� : "); // ���̵� ���ڿ�
		
		// ������ ���� ������ ���������� ���
		while((a = input.nextInt()) != 0) { // �Է¹��� ���� a�� �����ϰ�, a�� ���� 0�� �ƴϸ� true
			total += a; // ����
			System.out.print("������ ���� ������ �Է� : "); // ���̵� ���ڿ�
		}
		
		System.out.println("total = " + total); // ������ ������ ���
		
		input.close();
	}
}