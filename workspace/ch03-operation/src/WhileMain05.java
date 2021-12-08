public class WhileMain05 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int a, total = 0;
		System.out.println("0 전까지 입력받은 정수로 합 구하기");
		
		// 초기식 없이 루프를 빠져나오는 형태; 증감식 없는 형태의 경우 가이드 문자열을 2번 쓰지만 초기식 없는 형태는 1번만 쓰니 코드가 더 깔끔함
		while(true) {
			System.out.print("누적할 정수 입력 : ");
			a = input.nextInt();
			if(a == 0) {
				break; // while문 탈출
			}
			total += a; // 누적
		}
		
		System.out.println("total = " + total); // 누적한 데이터 출력
		
		input.close();
	}
}