package kr.s01.string;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "  aBa  ";
		String s2 = "abc";
		int a = 100;
		String msg = null;
		
		msg = s1.toUpperCase(); // 문자열 내 소문자를 모두 대문자로 변환
		System.out.println("msg : " + msg);
		
		msg = s1.toLowerCase(); // 문자열 내 대문자를 모두 소문자로 변환
		System.out.println("msg : " + msg);
		
		msg = s1.replace("aB", "b"); // 특정 문자열을 새로운 문자열로 치환
		System.out.println("msg : " + msg);
		
		msg = s1.trim(); // 문자열 내의 공백을 제거; 자바에서 공백은 데이터로 인정되지만 프로그래머의 필요에 따라 trim() 메서드 활용 가능
		System.out.println("msg : " + msg);
		
		boolean f= s1.contains("aB"); // 문자열 내에 인자로 전달받은 문자열이 포함되어 있으면 true, 그렇지 않으면 false를 반환; 검색 용도로 사용 가능
		System.out.println("f : " + f);
		
		f = s2.startsWith("ab"); // 문자열이 인자에 전달된 문자열로 시작하면 true, 그렇지 않으면 false를 반환; 검색 용도로 사용 가능
		System.out.println("f : " + f);
		
		f = s2.endsWith("bc"); // 문자열이 인자에 전달된 문자열로 끝나면 true, 그렇지 않으면 false를 반환; 검색 용도로 사용 가능
		System.out.println("f : " + f);
		
		String msg2 = String.valueOf(a); // valueOf() 메서드를 이용하여 int를 String으로 변환(=parsing)
		System.out.println("msg2 : " + msg2);
		String msg3 = a + ""; // 빈 문자열을 연결하여 int를 String으로 변환(=parsing)
		System.out.println(msg3.equals(msg2));
	}
}