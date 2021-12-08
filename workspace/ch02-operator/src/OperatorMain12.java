public class OperatorMain12 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		/*
		 * [실습] A전자 대리점에서는 그날 물건 판매액의 15%를 할인해 주기로 했습니다.
		 * 판매한 상품명과 상품의 단가와 수량을 키보드로부터 입력받아 지불 금액을 출력하는 프로그램을 작성하세요.
		 * (단, 출력시에는 소숫점 아래 자리를 절삭)
		 * [출력 예시]
		 * 상품명 입력 : 냉장고
		 * 단가 입력 : 500000
		 * 판매 수량 입력 : 3
		 * 냉장고 3대의 가격은 1,275,000원
		 */
		System.out.print("상품명 입력 : ");
		String item = input.next();
		System.out.print("단가 입력 : ");
		int price = input.nextInt();
		System.out.print("판매 수량 입력 : ");
		int quantity = input.nextInt();
		System.out.printf("%s %d대의 가격은 %,d원", item, quantity, (int)(price*quantity*0.85));
		input.close();
	}
}