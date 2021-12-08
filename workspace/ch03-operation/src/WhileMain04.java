public class WhileMain04 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int a, total = 0;
		System.out.println("0 전까지 입력받은 정수로 합 구하기");
		System.out.print("누적할 정수 데이터 입력 : "); // 가이드 문자열
		
		// 증감식 없이 루프를 빠져나오는 방식
		while((a = input.nextInt()) != 0) { // 입력받은 값을 a에 저장하고, a의 값이 0이 아니면 true
			total += a; // 누적
			System.out.print("누적할 정수 데이터 입력 : "); // 가이드 문자열
		}
		
		System.out.println("total = " + total); // 누적한 데이터 출력
		
		input.close();
	}
}