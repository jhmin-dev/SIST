public class OperatorMain03 {
	public static void main(String[] args) {
		int korean = 90;
		int english = 95;
		int math = 88;
		
		// 총점 구하기
		int sum = korean + english + math;
		// 평균 구하기
		int avg = sum / 3;
		
		System.out.printf("국어 : %d점\n영어 : %d점\n수학 : %d점\n총점 : %d점\n평균 : %d점\n", korean, english, math, sum, avg);
	}
}