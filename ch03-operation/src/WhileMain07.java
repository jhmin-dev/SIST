public class WhileMain07 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		/*
		 * [실습] 
		 * 커피전문점에서 아메리카노가 4,000원입니다. 마실 커피 수량을 정하고 돈을 지불하세요.
		 * 지불한 돈에서 발생한 거스름돈을 출력하고, 상품의 총 비용보다 지불한 돈이 적어서 상품을 구매할 수 없을 경우 "금액이 부족합니다."라고 알려준 후 다시 지불할 수 있는 프로그램을 작성하세요.
		 * [출력 예시]
		 * 구매 수량 입력 > 2
		 * 내가 지불한 금액 > 10000
		 * 거스름돈 : 2,000원
		 * ---> 구매 종료
		 * ========
		 * 구매 수량 입력 > 2
		 * 내가 지불한 금액 > 5000
		 * 3,000원이 부족합니다.
		 * ---> 다시 구매할 수 있도록 처리
		 */
		int price=4000;
		int quantity; // 수량
		int balance; // 거스름돈
		int payment; // 지불한 금액
		int total; // 총 지불해야 할 금액
		quant: while(true) { // 수량 루프에 label 지정
			System.out.print("구매 수량 입력 > ");
			quantity=input.nextInt();
			if(quantity>0) {
				total=price*quantity;
				while(true) { // 금액 루프
					System.out.print("내가 지불한 금액 > ");
					payment=input.nextInt();
					balance=payment-total;
					if(balance>=0) {
						break; // 금액 루프 탈출
					}
					else {
						System.out.printf("%,d원이 부족합니다.\n", -balance);
						continue quant; // label이 지정된 수량 루프로 이동
					}
				}
				System.out.printf("거스름돈 : %,d원\n", balance);
				break; // 수량 루프 탈출
			}
			else {
				System.out.println("수량은 0 이하일 수 없습니다.");
			}
		}
		input.close();
	}
}