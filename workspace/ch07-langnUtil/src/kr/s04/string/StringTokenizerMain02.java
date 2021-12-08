package kr.s04.string;

import java.util.StringTokenizer;

public class StringTokenizerMain02 {
	public static void main(String[] args) {
		String source = "2021-11-10 11:21:50";
		StringTokenizer st = new StringTokenizer(source, "-: "); // 복수의 구분자 지정 가능
		while(st.hasMoreTokens()) { // 구분자를 통해 만들어진 문자열이 있는지 검증
			System.out.println(st.nextToken()); // 구분자를 통해 만들어진 문자열을 하나씩 반환
		}
	}
}