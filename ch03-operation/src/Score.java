public class Score {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int korean, english, math, sum;
		char grade;
		float avg;
		
		do {
			System.out.print("국어 : ");
			korean = input.nextInt();
		} while(korean < 0 || korean > 100); // 0부터 100 사이의 값 입력시 false가 되어 do~while문 블럭 탈출
		
		do {
			System.out.print("영어 : ");
			english = input.nextInt();
		} while(english < 0 || english > 100);
		
		do {
			System.out.print("수학 : ");
			math = input.nextInt();
		} while(math < 0 || math > 100);
		
		sum = korean + english + math;
		                                        
		avg = sum / 3.0f;
		
		switch((int)(avg / 10)) { // 0부터 100까지를 하나하나 case로 지정하기 번거롭고, 등급은 10 단위로 결정되므로 인자값도 /10한 값을 씀
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
		System.out.printf("총점 : %d\n평균 : %.2f\n등급 : %c", sum, avg, grade);
		
		input.close();
	}
}