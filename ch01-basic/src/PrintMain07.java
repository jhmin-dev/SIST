public class PrintMain07 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 유재석은 은행계좌를 가지고 있다. 계좌에 1,000원이 예금되어 있는데
		 * 오늘 325원을 송금받아서 잔고가 1,325원이 되었다.
		 * 특별이자율은 0.3이 적용되어 내일 이자 397.5원을 받는다.
		 * 
		 * 예금자, 송금되기 전 잔금, 송금된 금액, 송금 이후 잔금,
		 * 내일 입금될 이자를 출력하시오.
		 */
		String who = "유재석";
		int before = 1000, trans = 325;
		double plus = 397.5;
		System.out.printf("예금자 : %s\n송금되기 전 잔금 : %,d원\n송금된 금액 : %,d원\n송금 이후 잔금: %,d원\n내일 입금될 이자 : %,.1f원\n", who, before, trans, before + trans, plus);
	}
}