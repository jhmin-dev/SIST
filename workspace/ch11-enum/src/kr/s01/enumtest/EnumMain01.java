package kr.s01.enumtest;

public class EnumMain01 {
	// enum을 사용하지 않고 static 상수를 사용한 경우
	public static final String JAVA = "JAVA"; // 문자열 상수
	public static final String JSP = "JSP";
	public static final String SERVLET = "SERVLET";
	
	public static void main(String[] args) {
		System.out.println(JAVA);
		System.out.println(JSP);
		System.out.println(SERVLET);
	}	
}