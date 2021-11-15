package kr.s01.string;

public class StringMain05 {
	public static void main(String[] args) {
		String str = "abcMDye-4W?EWzz";
		String result = ""; // 빈 문자열로 초기화
		/*
		 * [실습] str에 저장된 문자열에서 소문자는 대문자로 변경, 대문자는 소문자로 변경해서 출력하시오.
		 * ABCmdYE-4w?ewZZ
		 * (힌트: ASCII 코드에서 65~90은 대문자, 97~122는 소문자)
		 */
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>=65&&c<=90) { // 대문자
				result+=(char)(c+97-65); // 대문자를 소문자로 변경하고 result에 연결
				// result+=String.valueOf(c).toLowerCase();
			}
			else if(c>=97&&c<=122) { // 소문자
				result+=(char)(c-97+65); // 소문자를 대문자로 변경하고 result에 연결
				// result+=String.valueOf(c).toUpperCase();
			}
			else {
				result+=c;
			}
		}
		System.out.println(result);
	}
}