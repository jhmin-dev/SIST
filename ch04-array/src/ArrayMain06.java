public class ArrayMain06 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String[] course = {"����", "����", "����"};
		int[] score = new int[course.length];
		
		int sum = 0;
		float avg = 0.0f;
		
		for(int i=0;i<course.length;i++) {
			do { // ������ �ùٸ��� �Է��ϵ��� ����
				System.out.print(course[i] + " > "); // ���̵� ���ڿ��� ����� ���
				score[i] = input.nextInt();
			} while(score[i]<0 || score[i]>100);
			sum += score[i]; // ������ �ݺ����� ������ �ʱ� ���� �Է¹����鼭 ������ ����
		}
		
		input.close();
		
		avg = sum / (float)course.length;
		
		System.out.printf("���� : %d\n", sum);
		System.out.printf("��� : %.2f", avg);
	}
}