package kr.s01.exception;

import java.io.IOException; // BufferedReader의 예외를 처리하기 위해 필요
import java.io.BufferedReader; // 범용적으로 Scanner보다 많이 사용됨
import java.io.InputStreamReader; // BufferedReader를 사용하기 위해 필요

public class ExceptionMain05 {
	// 메서드에 throws 예약어를 사용하여 발생할 가능성이 있는 예외 클래스들을 명시하면, 메서드 내에 try~catch 블럭을 생략하고, 예외가 발생하면 예외를 보관하고 메서드를 호출한 곳에서 try~catch 블럭을 만들고 그 곳으로 예외를 양도
	public void printData() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단 입력 > ");
		int dan = Integer.parseInt(br.readLine()); // readLine() 메서드는 \n, \r, \r\n이 제거된 한 줄의 데이터를 문자열로 반환하므로 문자열 parsing 필요; readLine() 메서드 사용시 IOException이 발생할 수 있고, IOException은 일반적 Exception이라 throws 혹은 try~catch하지 않으면 컴파일 오류 발생
		System.out.println(dan + "단");
		System.out.println("========");
		for(int i=1;i<=9;i++) {
			System.out.println(dan + " * " + i + " = " + dan*i);
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain05 ex = new ExceptionMain05();
		// ex.printData(); // throws 예약어 사용한 메서드 호출시 의무적으로 try~catch 블럭 작성해야 함
		try {
			ex.printData();
		}
		catch(NumberFormatException e) {
			System.out.println("잘못 입력하셨습니다. 숫자만 입력하세요.");
		}
		catch(IOException e) { // IOException은 입력 대기 중인데 프로그램을 강제 중단하거나, 시스템 환경이 불안정해서 System.in의 입력 정보를 상실했을 때 발생 가능하며 돌발적으로 발생하기 때문에 예외 처리를 의무화하는 것; 이 예제에서는 프로그램 강제 중단시 parseInt()가 입력받은 것이 없기 때문에 NumberFormatException도 함께 발생; 만약 입력받기 전에 br.close();로 자원을 정리하면 IOException 발생
			System.out.println("입출력 예외가 발생했습니다.");
		}
	}
}