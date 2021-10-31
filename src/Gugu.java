public class Gugu {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("단을 입력하세요 : ");
		int dan = input.nextInt();
		
		while(dan<=0) { // 단을 잘못 입력한 경우 제대로 입력할 때까지 계속 입력 요청
			System.out.println("양의 정수를 입력하세요 : ");
			dan = input.nextInt();
		}

		input.close();

		System.out.println(dan + "단");
		System.out.println("========");
		
		if(dan<=9&&dan>=1) {
			for(int i=1;i<=9;i++) {
				System.out.println(dan + " * " + i + " = " + dan * i); // 곱셈은 덧셈보다 우선순위가 높기 때문에 소괄호 없어도 곱셈 먼저 실행하고 문자열로 연결함
			}
		}
		else { // 10단 이상인 경우 9행까지가 아니라 해당 단 끝까지 출력
			for(int i=1;i<=dan;i++) {
				if(i%3==1) { // 3열로 출력
					System.out.printf("%d * %d = %d\t", dan, i, dan*i);
					if(i+1<=dan){
						System.out.printf("%d * %d = %d\t", dan, i+1, dan*(i+1));
						if(i+2<=dan){
							System.out.printf("%d * %d = %d\n", dan, i+2, dan*(i+2));
						}
					}
				}
			}
		}
	}
}