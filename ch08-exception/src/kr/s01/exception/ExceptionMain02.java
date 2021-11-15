package kr.s01.exception;

public class ExceptionMain02 {
	public static void main(String[] args) {
		// 예외 처리; 예외가 발생해도 정상 종료될 수 있도록 프로그램적으로 처리
		int[] array = {10, 20, 30};
		
		// 인위적으로 예외 발생
		for(int i=0;i<=array.length;i++) {
			// 예외 처리; 예외는 없는 인덱스를 호출하는 순간 발생
			try { // 예외가 발생할 가능성이 있는 코드를 명시
				System.out.println("array[" + i + "] : " + array[i]);
			}
			catch(ArrayIndexOutOfBoundsException e) { // 예외 발생시 catch 블럭으로 이동하여 예외가 발생한 이유를 출력하거나 대체 코드를 실행; catch()에는 예외 발생시 생성되는 예외 객체의 자료형을 지정해야 함
				System.out.println("없는 인덱스 " + i + "을/를 호출함");
			}
		} // for문 종료
		System.out.println("프로그램 정상 종료"); // 예외 처리를 했기 때문에 예외가 발생해도 출력됨
	}
}