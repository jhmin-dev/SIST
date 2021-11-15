package kr.s01.string;

import java.util.Scanner;

public class StringMain04 {
	public static void main(String[] args) {
		/*
		 * [실습] 문자열을 한 문자씩 읽어서 역순으로 출력
		 * hello -> olleh
		 */
		Scanner input = new Scanner(System.in);
		
		System.out.print("문자열 > ");
		String s = input.nextLine();
	
		for(int i=s.length();i>0;i--) {
			System.out.print(s.charAt(i-1)); // i가 움직이는 범위(=s.length()부터 1까지)와 인덱스의 범위(=0부터 s.length()-1까지) 차이 유의
		}
		
		input.close();
	}
}