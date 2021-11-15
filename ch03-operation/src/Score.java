public class Score {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int korean, english, math, sum;
		char grade;
		float avg;
		
		do {
			System.out.print("���� : ");
			korean = input.nextInt();
		} while(korean < 0 || korean > 100); // 0���� 100 ������ �� �Է½� false�� �Ǿ� do~while�� �� Ż��
		
		do {
			System.out.print("���� : ");
			english = input.nextInt();
		} while(english < 0 || english > 100);
		
		do {
			System.out.print("���� : ");
			math = input.nextInt();
		} while(math < 0 || math > 100);
		
		sum = korean + english + math;
		                                        
		avg = sum / 3.0f;
		
		switch((int)(avg / 10)) { // 0���� 100������ �ϳ��ϳ� case�� �����ϱ� ���ŷӰ�, ����� 10 ������ �����ǹǷ� ���ڰ��� /10�� ���� ��
		case 10:
		case 9:
			grade = 'A'; break;
		case 8:
			grade = 'B'; break;
		case 7:
			grade = 'C'; break;
		case 6:
			grade = 'D'; break;
		default:
			grade = 'F';
		}
		
		System.out.println();
		System.out.printf("���� : %d\n��� : %.2f\n��� : %c", sum, avg, grade);
		
		input.close();
	}
}