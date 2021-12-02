package kr.s08.bank;

public class BankAccount { // 일반 계좌
	/*
	 * [실습]
	 * 계좌번호(number), 예금주(name), 잔고(balance)
	 * 생성자를 이용하여 계좌 번호, 예금주, 잔고를 세팅
	 * 입금하기(deposit), 출금하기(withdraw : 잔고 부족 확인), 계좌 정보 보기(printAccount : 일반 계좌 번호, 예금주, 계좌 잔액)
	 */
	protected String number; // 상속을 고려하여 접근 제한자를 protected로 지정
	protected String name;
	protected int balance; // 은행 프로그램은 long을 쓰지만 예제에서 큰 수를 사용하지 않으므로 int 자료형 사용
	
	public BankAccount(String number, String name, int balance) {
		this.number=number;
		this.name=name;
		this.balance=balance;
		System.out.println(number+" 계좌가 개설되었습니다.\n");
	}
	
	public void deposit(int money) {
		if(money>=0) {
			balance+=money;
			System.out.printf("%,d원을 예금하였습니다.\n", money);
			return;
		}
		System.out.println("0원 이상을 예금하세요.");
	}
	
	public void withdraw(int money) {
		if(balance>=money) {
			balance-=money;
			System.out.printf("%,d원을 출금하였습니다.\n", money);
			return;
		}
		System.out.println("잔고가 부족합니다.");
	}
	
	public void printAccount() {
		System.out.println("계좌 번호 : 일반 "+number);
		System.out.println("예금주 : "+name);
		System.out.printf("계좌 잔액 : %,d원\n", balance);
		System.out.println();
	}
}