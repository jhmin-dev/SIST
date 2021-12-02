package kr.s08.bank;

public class MinusAccount extends BankAccount {
	/*
	 * BankAccount 상속
	 * 마이너스 한도(minusLimit)
	 * 한도를 적용한 출금하기(withdraw) 재정의
	 * 마이너스 한도 정보가 포함된 계좌 정보 보기(printAccount) 재정의
	 */
	private int minusLimit; // printAccount가 get 메서드 역할을 대신하니 별도로 Getter & Setter 만들지 않아도 됨

	public MinusAccount(String number, String name, int balance, int minusLimit) {
		super(number, name, balance);
		if(minusLimit<0) {
			this.minusLimit=-minusLimit;
		}
		else {
			this.minusLimit=minusLimit;
		}
	}

	@Override public void withdraw(int money) {
		if(balance+minusLimit>=money) {
			balance-=money;
			System.out.printf("%,d원을 출금하였습니다.\n", money);
			return;
		}
		System.out.println("마이너스 한도 초과로 출금되지 않습니다.");
	}

	@Override public void printAccount() {
		System.out.println("계좌 번호 : 마이너스 "+number);
		System.out.println("예금주 : "+name);
		System.out.printf("계좌 잔액 : %,d원\n", balance);
		System.out.printf("마이너스 한도 : %,d원\n", minusLimit);
		System.out.println();
	}
}