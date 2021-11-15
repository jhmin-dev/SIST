public class OperatorMain11 {
	public static void main(String[] args) {
		/*
		 * [실습] 성적 처리
		 * 국어, 영어, 수학 성적을 입력받아서 총점, 평균(double)을 구하고 각각을 출력
		 * [출력 예시] 
		 * 국어 = 
		 * 영어 = 
		 * 수학 = 
		 * 총점 = 
		 * 평균 = (소숫점 아래 둘째 자리까지 표시)
		 */
		java.util.Scanner input = new java.util.Scanner(System.in); // 입력 시작
		
		System.out.print("국어 : "); // 입력시의 가이드 문자열; println을 쓰면 다음 줄에 입력하게 됨
		int kor = input.nextInt(); // 정수를 입력받는 함수로 값을 받아 변수에 대입
		System.out.print("영어 : ");
		int eng = input.nextInt();
		System.out.print("수학 : ");
		int math = input.nextInt();
		
		System.out.printf("국어 = %d\n영어 = %d\n수학 = %d\n총점 = %d\n평균 = %.2f", kor, eng, math, kor+eng+math, (kor+eng+math)/3d); // 만약 (kor+eng+math)/3으로 연산 후에 그 결과를 double로 형변환하게 되면, 연산은 정수끼리의 나눗셈으로 몫을 구했기 때문에 소숫점 아래 정보가 부정확해짐.
		
		input.close(); // 입력 끝
	}
}