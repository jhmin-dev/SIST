package kr.s01.string;

public class StringMain01 {
	public static void main(String[] args) {
		// 암시적으로 객체 생성; 같은 문자열을 암시적으로 여러 번 만들 경우, 메모리에 각각 객체를 만들지 않고 여러 참조 변수가 하나의 객체를 공유함
		String str1 = "abc";
		String str2 = "abc";
		
		// ==를 사용하여 객체 비교; String 클래스의 경우 toString() 메서드가 재정의되어 있어 참조값을 확인할 수 없으며, hashCode() 메서드 역시 재정의되어 있어 같은 문자열이면 객체가 달라도 같은 값을 반환함
		if(str1 == str2) {
			System.out.println("str1과 str2는 같은 객체");
		}
		else {
			System.out.println("str1과 str2는 다른 객체");
		}
		
		// equals() 메서드를 사용하여 문자열 비교 
		if(str1.equals(str2)) {
			System.out.println("str1과 str2의 내용(=문자열)이 같음");
		}
		else {
			System.out.println("str1과 str2의 내용(=문자열)이 다름");
		}
		
		// 명시적으로 객체 생성; 같은 문자열을 명시적으로 여러 번 만들 경우, 메모리에 각각 객체가 올라감
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		// 객체 비교
		if(str3 == str4) {
			System.out.println("str3과 str4는 같은 객체");
		}
		else {
			System.out.println("str3과 str4는 다른 객체");
		}
		
		// 문자열 비교
		if(str3.equals(str4)) {
			System.out.println("str3과 str4의 내용(=문자열)이 같음");
		}
		else {
			System.out.println("str3과 str4의 내용(=문자열)이 다름");
		}
		
		// 문자열의 대소문자를 구분하지 않고 비교
		String str5 = "bus";
		String str6 = "Bus";
		if(str5.equalsIgnoreCase(str6)) {
			System.out.println("[대소문자 구분없이 비교] str5와 str6의 내용(=문자열)이 같음");
		}
		else {
			System.out.println("[대소문자 구분없이 비교] str5와 str6의 내용(=문자열)이 다름");
		}
	}
}