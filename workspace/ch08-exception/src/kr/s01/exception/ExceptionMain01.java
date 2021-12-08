package kr.s01.exception;

public class ExceptionMain01 {
	public static void main(String[] args) {
		int[] array = {10,20,30};
		// 인위적으로 예외를 발생시키기 위해 없는 인덱스 3을 호출
		for(int i=0;i<=array.length;i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		} // for문 종료
		System.out.println("프로그램 정상 종료"); // 예외 발생으로 프로그램 비정상 종료되어 출력되지 않음
	}
}