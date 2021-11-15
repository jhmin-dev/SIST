package kr.s04.constructor;

public class AccountMain {
	// 멤버 변수
	String accountNo; // 계좌 번호
	String ownerName; // 예금주명
	int balance; // 잔고
	
	// 생성자
	public AccountMain(String a, String o, int b) {
		accountNo = a;
		ownerName = o;
		balance = b;
		System.out.println("계좌 생성이 완료되었습니다.");
	}
	
	// 멤버 메서드
	public void deposit(int amount) { // 예금하기
		balance += amount;
		System.out.println("입금이 완료되었습니다.");
	}
	public void withdraw(int amount) { // 출금하기
		balance -= amount;
		System.out.println("출금이 완료되었습니다.");
	}
	public void printAccount() { // 계좌 정보 보기
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.printf("잔고 : %,d원\n", balance);
	}
	
	public static void main(String[] args) {
		// 계좌 생성
		AccountMain am = new AccountMain("100-123", "홍길동", 1000);
		// 계좌 정보
		am.printAccount();
		//입금
		am.deposit(1000);
		am.printAccount();
		//출금
		am.withdraw(2000);
		am.printAccount();
	}
}