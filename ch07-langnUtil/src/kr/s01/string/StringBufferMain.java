package kr.s01.string;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("여름 덥다!!");
		System.out.println("1 : " + sb);
		
		sb.insert(2, '이'); // insert() 메서드를 이용해 원하는 인덱스에 원하는 문자를 삽입; 인덱스 변동 발생
		System.out.println("2 : " + sb);
		
		sb.append("가을은 "); // append() 메서드를 이용해 기존 문자열 마지막에 원하는 문자열을 연결
		System.out.println("3 : " + sb);
		sb.append("시원하다!");
		System.out.println("4 : " + sb);

		sb.replace(0, 3, "여행가자!!"); // replace() 메서드를 이용해 시작 인덱스부터 끝 인덱스 직전까지의 문자열을 원하는 문자열로 대체
		System.out.println("5 : " + sb);
		
		sb.deleteCharAt(0); // deleteCharAt() 메서드를 이용해 지정한 인덱스의 문자를 삭제; 인덱스 변동 발생
		System.out.println("6 : " + sb);
		sb.delete(0, 3); // delete() 메서드를 이용해 시작 인덱스부터 끝 인덱스 직전까지의 문자열을 삭제; 인덱스 변동 발생
		System.out.println("7 : " + sb);
		
		String str = sb.toString(); // StringBuffer에서 String으로 변환; 두 클래스는 상속 관계가 아니기 때문에 toString() 메서드를 이용
		System.out.println(str);
	}
}