package kr.s01.string;

public class StringMain02 {
	public static void main(String[] args) {
		String s1 = "This is false";
		
		int index = s1.indexOf('s');
		System.out.println("문자 s가 처음으로 등장한 위치 : " + index);
		
		index = s1.indexOf("is"); // indexOf 메서드의 경우 반환값이 1개이므로, 문자열의 위치는 해당 문자열(=is)의 첫 번째 문자(=i)의 위치를 반환
		System.out.println("문자열 is의 위치 : " + index);
		
		index = s1.lastIndexOf('s');
		System.out.println("문자 s가 마지막으로 등장한 위치 : " + index);
		
		char c = s1.charAt(8); // 입력한 인덱스값에 해당하는 문자를 반환
		System.out.println("추출한 문자 : " + c);
		
		index = s1.indexOf('F'); // 대소문자를 구분하며, 문자열에 포함되지 않은 문자는 -1을 반환
		System.out.println(index);
		index = s1.indexOf('f');
		
		String str = s1.substring(index); // 지정한 인덱스부터 마지막 인덱스까지의 문자열을 추출
		System.out.println("소문자 f부터 끝까지의 문자열을 추출 : " + str);
		
		str = s1.substring(index, index+3); // 시작 인덱스부터 끝 인덱스 직전까지의 문자열을 추출(=끝 인덱스는 포함되지 않음)
		System.out.println("인덱스 8부터 인덱스 11 직전까지의 문자열 추출 : " + str);
		
		int length = s1.length();
		System.out.println("문자열 s1의 길이 : " + length);
		
		String[] array = s1.split(" "); // 공백을 구분자로 하여 문자열을 자르고 배열로 반환
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}
	}
}