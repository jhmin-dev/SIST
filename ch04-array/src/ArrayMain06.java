public class ArrayMain06 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String[] course = {"국어", "영어", "수학"};
		int[] score = new int[course.length];
		
		int sum = 0;
		float avg = 0.0f;
		
		for(int i=0;i<course.length;i++) {
			do { // 점수를 올바르게 입력하도록 강제
				System.out.print(course[i] + " > "); // 가이드 문자열로 과목명 출력
				score[i] = input.nextInt();
			} while(score[i]<0 || score[i]>100);
			sum += score[i]; // 별도의 반복문을 만들지 않기 위해 입력받으면서 총점도 구함
		}
		
		input.close();
		
		avg = sum / (float)course.length;
		
		System.out.printf("총점 : %d\n", sum);
		System.out.printf("평균 : %.2f", avg);
	}
}