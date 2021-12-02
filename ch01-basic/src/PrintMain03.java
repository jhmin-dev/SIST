public class PrintMain03 {
	public static void main(String[] args) {
		// 문자: 한 문자
		System.out.println('A');
		System.out.println('가');
		// System.out.println('부산'); // 문자열을 '' 처리해서 오류 발생
		
		// 문자열 : 한 문자 이상의 문자들
		System.out.println("서울");
		System.out.println("Bus");
		System.out.println("Z");
		
		// 숫자(정수)
		System.out.println(23);
		
		// 숫자(실수)
		System.out.println(25.67);
		
		// 논리값(boolean)
		System.out.println(true); // "" 처리시 데이터 종류가 문자열로 바뀜, 대문자 사용시 오류
		System.out.println(false);
	}
}
