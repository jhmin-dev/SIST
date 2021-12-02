public class IfMain06 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수 두 개를 입력받아서 변수에 저장하고 두 값 중 최댓값과 최솟값을 구하여 출력하시오.
		 * 단, 입력받은 두 수가 같을 경우 "두 수는 같다."라고 출력하시오.
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int a = input.nextInt();
		System.out.print("두 번째 정수 : ");
		int b = input.nextInt();
		
		input.close();
		
		if(a>b)
			System.out.printf("최댓값 : %d, 최솟값 : %d\n", a, b);
		else if(a<b)
			System.out.printf("최댓값 : %d, 최솟값 : %d\n", b, a);
		else
			System.out.println("두 수는 같다.");
	}
}