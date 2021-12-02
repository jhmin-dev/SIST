public class ArrayMain01 {
	public static void main(String[] args) {
		// 배열 선언
		char[] ch;
		// 배열 생성
		ch = new char[4]; // 배열의 주소가 저장되는 ch를 배열명이라고 함
		// 배열의 초기화
		ch[0] = 'J'; // 배열에 저장된 데이터를 배열의 요소라고 함
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';
		
		// 배열의 요소 출력
		System.out.print(ch[0]);
		System.out.print(ch[1]);
		System.out.print(ch[2]);
		System.out.print(ch[3]);
		System.out.println();
		
		// 반복문을 이용한 배열의 요소 출력
		for(int i=0;i<ch.length;i++) { // 배열의 길이는 배열명.length로 호출함
			System.out.println("ch[" + i + "] : " + ch[i]);
		}
		
		// 배열의 선언 및 생성
		int[] it = new int[6]; // 정수형 배열의 경우 요소는 0으로 초기화되어 있음
		for(int i=0;i<it.length;i++) {
			System.out.println(it[i]);
		}
		
		// 배열 선언 및 생성(명시적 배열 생성), 초기화
		char[] ch2 = new char[] {'J', 'a', 'v', 'a'}; // 길이의 경우 입력한 데이터 수에 의해 자동으로 결정되며, 오히려 길이 명시하면 오류 발생
		for (int i=0;i<ch2.length;i++) {
			System.out.println(ch2[i]);
		}
		
		// 배열 선언 및 생성(암시적 배열 생성), 초기화
		char[] ch3 = {'자','바'};
		System.out.println(ch3[0]);
		System.out.println(ch3[1]);
	}
}