public class OperatorMain11 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] ���� ó��
		 * ����, ����, ���� ������ �Է¹޾Ƽ� ����, ���(double)�� ���ϰ� ������ ���
		 * [��� ����] 
		 * ���� = 
		 * ���� = 
		 * ���� = 
		 * ���� = 
		 * ��� = (�Ҽ��� �Ʒ� ��° �ڸ����� ǥ��)
		 */
		java.util.Scanner input = new java.util.Scanner(System.in); // �Է� ����
		
		System.out.print("���� : "); // �Է½��� ���̵� ���ڿ�; println�� ���� ���� �ٿ� �Է��ϰ� ��
		int kor = input.nextInt(); // ������ �Է¹޴� �Լ��� ���� �޾� ������ ����
		System.out.print("���� : ");
		int eng = input.nextInt();
		System.out.print("���� : ");
		int math = input.nextInt();
		
		System.out.printf("���� = %d\n���� = %d\n���� = %d\n���� = %d\n��� = %.2f", kor, eng, math, kor+eng+math, (kor+eng+math)/3d); // ���� (kor+eng+math)/3���� ���� �Ŀ� �� ����� double�� ����ȯ�ϰ� �Ǹ�, ������ ���������� ���������� ���� ���߱� ������ �Ҽ��� �Ʒ� ������ ����Ȯ����.
		
		input.close(); // �Է� ��
	}
}