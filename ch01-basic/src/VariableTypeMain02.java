public class VariableTypeMain02 {
	public static void main(String[] args) {
		// '을 일반 문자처럼 출력하기 위해 앞에 \를 붙임
		char single = '\'';
		System.out.println(single);
		
		// "을 일반 문자처럼 출력하기 위해 앞에 \를 붙임
		String str = "오늘은 \"서울\"에 비가 와요";
		System.out.println(str);
		
		// 문자열 안의 '는 \를 붙이지 않아도 일반 문자로 변환되어 출력되며, \ 붙여도 동일한 결과
		String str2 = "오늘은 '목요일'입니다.";
		System.out.println(str2);
		
		// 경로 구분자 \를 일반 문자처럼 출력하기 위해 앞에 \를 붙임
		String dir = "C:\\Program Files\\Java";
		System.out.println(dir);

		String str3 = "내일은 금요일\n모레는 토요일";
		System.out.println(str3);
		
		String str4 = "이름\t나이\t취미";
		System.out.println(str4);
	}
}