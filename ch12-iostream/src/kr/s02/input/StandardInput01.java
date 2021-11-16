package kr.s02.input;

import java.io.IOException;

public class StandardInput01 {
	public static void main(String[] args) {
		// 자바의 기본 입력 처리
		try { // InputStream의 메서드 사용시, try~catch를 작성하지 않으면 컴파일 에러
			System.out.print("영문자 1개 입력 > ");
			int a = System.in.read(); // read() 메서드는 문자 하나를 입력받아 ASCII 코드로 반환
			System.out.println(a + ", " + (char)a); // ASCII 코드와 ASCII 코드를 char로 캐스팅한 결과 출력
			
			System.in.read(); // 앞선 입력에서 엔터를 입력하여 전달된 \r을 흡수
			System.in.read(); // 앞선 입력에서 엔터를 입력하여 전달된 \n을 흡수
			
			System.out.print("숫자 1개 입력 > ");
			int b = System.in.read();
			System.out.println(b-48); // ASCII 코드의 경우 숫자 0이 48의 값을 가지므로, 입력한 숫자를 그대로 출력하고 싶을 경우 값 보정 필요
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}