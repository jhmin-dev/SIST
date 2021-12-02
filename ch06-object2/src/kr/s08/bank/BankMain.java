package kr.s08.bank;

public class BankMain {
	public static void main(String[] args) {
		/*
		 * 마이너스 계좌 생성
		 * 입출금 및 정보 출력
		 */
		/* 입력을 받아 마이너스 계좌를 생성
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("계좌 기본 정보를 입력하세요.");
		System.out.print("계좌 번호 > ");
		String number = input.nextLine();
		System.out.print("예금주명 > ");
		String name = input.nextLine();
		System.out.print("계좌 잔액 > ");
		int balance = input.nextInt();
		System.out.print("마이너스 한도 > ");
		int minusLimit = input.nextInt();
		
		input.close();
		
		MinusAccount ma = new MinusAccount(number, name, balance, minusLimit);
		*/
		MinusAccount ma = new MinusAccount("110-1234", "홍길동", 1000, 500);
		
		ma.printAccount();
		
		ma.deposit(2000);
		ma.printAccount();
		
		ma.withdraw(3100); // 계좌 잔고가 -500이 될 때까지는 출금 가능
		ma.printAccount();
		
		ma.withdraw(500); // 한도 초과로 출금 불가
		ma.printAccount();
	}
}