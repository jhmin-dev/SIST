public class IfMain04 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int score;
		char grade;
		
		System.out.print("���� �Է� : ");
		score = input.nextInt();
		
		if(score>100||score<0)
			grade = '?';
		else if(score>=90)
			grade = 'A';
		else if(score>=80)
			grade = 'B';
		else if (score>=70)
			grade = 'C';
		else if (score>=60)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.printf("���� : %d\n��� : %c\n", score, grade);		
		
		input.close();
	}
}