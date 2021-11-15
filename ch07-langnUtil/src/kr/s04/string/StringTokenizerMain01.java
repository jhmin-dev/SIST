package kr.s04.string;

import java.util.StringTokenizer;

public class StringTokenizerMain01 {
	public static void main(String[] args) {
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source, ","); // 문자열과 구분자를 인자로 받고, 구분자를 통해 만들어진 문자열을 내부에 보관하는 객체 생성; 반환형이 배열이 아니므로 for문으로 접근하지 않음
		while(st.hasMoreTokens()) { // hasMoreTokens() 메서드로 구분자를 통해 만들어진 문자열이 있는지 검증
			System.out.println(st.nextToken()); // nextToken() 메서드로 구분자를 통해 만들어진 문자열을 하나씩 반환
		}
	}
}