public class OperatorMain03 {
	public static void main(String[] args) {
		int korean = 90;
		int english = 95;
		int math = 88;
		
		// ���� ���ϱ�
		int sum = korean + english + math;
		// ��� ���ϱ�
		int avg = sum / 3;
		
		System.out.printf("���� : %d��\n���� : %d��\n���� : %d��\n���� : %d��\n��� : %d��\n", korean, english, math, sum, avg);
	}
}