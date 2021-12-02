package kr.s02.method;

import java.util.Scanner;
/*
 * [실습] 
 * Account
 * 1) 멤버 변수 : 계좌 번호(account_num), 예금주(name), 잔고(balance)
 * 2) 멤버 메서드 : 
 * 1. 예금하기(deposit): balance 값 누적 후, 입금이 완료되었습니다. 출력
 * 2. 출금하기(withdraw): balance 값 차감 후, 출금이 완료되었습니다. 출력
 * 3. 계좌정보(printAccount): 계좌 번호, 예금주, 잔고 출력
 * MethodMain04
 * 1) Account 생성
 * 2) 계좌 기본 정보 입력: 계좌 번호, 예금주, 잔고
 * 3) 계좌 정보 출력
 * 4) 입금하기
 * 5) 계좌 정보 출력
 * 6) 출금하기
 * 7) 계좌 정보 출력
 */
class Account {
	String account_num, name;
	int balance;
	
	public void deposit(int n) {
		balance+=n;
		System.out.println("입금이 완료되었습니다.");
	}
	public void withdraw(int n) {
		balance-=n;
		System.out.println("출금이 완료되었습니다.");
	}
	public void printAccount() {
		System.out.println("====계좌 정보====");
		System.out.println("계좌 번호 : "+account_num);
		System.out.println("예금주 : "+name);
		System.out.printf("잔고 : %,d원\n", balance);
	}
}

public class MethodMain04 {
	public static void main(String[] args) {
		Account bank=new Account();
		Scanner input=new Scanner(System.in);
		
		System.out.println("계좌 기본 정보를 입력하세요.");
		System.out.print("계좌번호 > ");
		bank.account_num=input.nextLine(); // 한 줄 전체를 입력받는 메서드
		System.out.print("예금주 > ");
		bank.name=input.next(); // 공백 전까지를 입력받는 메서드
		System.out.print("잔고 > ");
		bank.balance=input.nextInt();
		/*
		bank.printAccount();

		System.out.println("====입금====");
		System.out.print("입금할 금액을 입력하세요 > ");
		bank.deposit(input.nextInt());
		bank.printAccount();
		
		System.out.println("====출금====");
		System.out.print("출금할 금액을 입력하세요 > ");
		bank.withdraw(input.nextInt());
		bank.printAccount();
		*/
		while(true) { // 메뉴 만들기; 기본 정보는 while문 밖에서 먼저 입력해야 함
			System.out.println("========");
			System.out.println("1. 예금|2. 출금|3. 잔고|4. 종료");
			System.out.println("========");
			
			System.out.print("메뉴 선택 > ");
			int num=input.nextInt();
			if(num==1) {
				System.out.print("예금액 > ");
				bank.deposit(input.nextInt());
			}
			else if(num==2) {
				System.out.print("출금액 > ");
				bank.withdraw(input.nextInt());
			}
			else if(num==3) {
				bank.printAccount();
			}
			else if(num==4) {
				System.out.println("프로그램 종료");
				break;
			}
			else {
				System.out.println("메뉴를 잘못 선택하셨습니다.");
			}
		}
		input.close();
	}
}