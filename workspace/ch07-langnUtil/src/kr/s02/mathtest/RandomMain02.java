package kr.s02.mathtest;

import java.util.Scanner;

public class RandomMain02 {
	public static void main(String[] args) {
		/*
		 * [실습] 가위바위보 게임
		 * 컴퓨터가 난수를 발생시켜 0=가위, 1=바위, 2=보를 낸다.
		 * 메뉴 > 1. 게임하기, 2. 종료
		 * [출력 예시]
		 * 가위바위보 입력 > 0. 가위, 1. 바위, 2. 보
		 * 경우 1) 무승부! (컴퓨터 : 가위, 당신 : 가위)
		 * 경우 2) 컴퓨터 승리! (컴퓨터 : 가위, 당신 : 보)
		 * 경우 3) 당신 승리! (컴퓨터 : 가위, 당신 : 바위)
		 */
		String[] item = {"가위", "바위", "보"};

		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("========");
			System.out.println("1. 게임하기, 2. 종료하기");
			System.out.println("========");
			System.out.print("메뉴 > ");
			int num = input.nextInt();
			if(num == 1) {
				System.out.print("가위바위보 입력(0. 가위, 1. 바위, 2. 보) > ");
				int user = input.nextInt();
				// 배열의 인덱스로 사용할 것이므로 범위에 맞는지 검사
				if(user <0 || user > 2) {
					System.out.println("잘못 입력했습니다.");
					continue;
				}
				// 난수 생성하고 결과 판정
				int computer = (int)(Math.random()*3);
				/*
				 * 컴퓨터 - 사용자 = 결과 판정
				 * 0 - 0 = 0 무승부
				 * 0 - 1 = -1 사용자 승리
				 * 0 - 2 = -2 컴퓨터 승리
				 * 1 - 0 = 1 컴퓨터 승리
				 * 1 - 1 = 0 무승부
				 * 1 - 2 = -1 사용자 승리
				 * 2 - 0 = 2 사용자 승리
				 * 2 - 1 = 1 컴퓨터 승리
				 * 2 - 2 = 0 무승부
				 */
				int result = computer - user;
				if(result == 0) {
					System.out.println("무승부! 컴퓨터 : " + item[computer] + ", 사람 : " + item[user]);
				} else if(result == -1 || result == 2) {
					System.out.println("사람 승리! 컴퓨터 : " + item[computer] + ", 사람 : " + item[user]);
				} else { // result == -2 || result == 1
					System.out.println("컴퓨터 승리! 컴퓨터 : " + item[computer] + ", 사람 : " + item[user]);
				}
			}
			else if(num == 2) {
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