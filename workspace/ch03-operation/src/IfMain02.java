public class IfMain02 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in); // 입력 시작
		
		System.out.print("정수형 데이터 한 개 입력 : ");
		int a = input.nextInt();
		
		if(a%2==1)
			System.out.println("홀수입니다!!");
		else
			System.out.println("짝수입니다!!");

		input.close(); // 입력 종료
	}
}