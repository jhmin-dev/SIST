public class WhileMain06 {
	public static void main(String[] args) {
		// 은행 프로그램
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int balance = 0; // 잔고 선언
		
		while(true) {
			System.out.println("========");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔금 | 4. 종료"); // 메뉴 출력
			System.out.println("========");
			
			System.out.print("메뉴 선택 > ");
			int num = input.nextInt(); // while문 블럭 내에서만 생존하는 지역 변수로, 반복 실행되더라도 한 번만 선언한 것으로 인식함
			if(num == 1) {
				System.out.print("예금액 > ");
				balance += input.nextInt();
			}
			else if(num == 2) {
				while(true) {
					System.out.print("출금액 > ");
					int withdraw = input.nextInt();
					if(withdraw>balance) {
						System.out.println("잔금보다 더 많이 출금할 수 없습니다.");
					}
					else {
						balance -= withdraw;
						break;
					}
				}
			}
			else if(num == 3) {
				System.out.printf("잔고 : %,d원\n", balance);
			}
			else if(num == 4) {
				System.out.println("프로그램 종료");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		input.close();
	}
}