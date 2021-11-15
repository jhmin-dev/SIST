package kr.s01.exception;

import java.util.Scanner;

class NegativeNumberUseException extends Exception { //사용자 정의 예외 클래스
	public NegativeNumberUseException(String str) { // 예외 문구를 지정할 수 있도록 인자를 명시
		super(str); // 인자를 Exception에 전달
	}
}

public class ExceptionMain07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("0 이상의 수를 입력 > ");
		try {
			int a = input.nextInt();
			if(a >= 0) {
				System.out.println("입력한 수 : " + a);
			}
			else { // 사용자가 정의한 예외를 인위적으로 발생
				throw new NegativeNumberUseException("음수를 사용할 수 없습니다.");
			}
		}
		catch(NegativeNumberUseException e) { // 사용자가 정의한 예외가 발생한 경우
			System.out.println(e.getMessage());
		}
		catch(Exception e) { // 그 외의 예외가 발생한 경우
			System.out.println("예외가 발생했습니다.");
		}
		finally {
			if(input!=null) input.close(); // 예외 발생 여부와 관계없이 자원 정리; input이 null인 경우 close할 수 없으므로 조건문 처리
		}
	}
}