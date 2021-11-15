package kr.s01.exception;

public class ExceptionMain03 {
	public static void main(String[] args) {
		int var = 50;
		// 예외가 발생하면 예외 객체가 생성되고, 예외 객체가 전달된 catch 블럭으로 이동해서 수행문을 실행
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
		}
		// 다중 catch문 사용; Exception과 하위 예외 클래스를 동시에 명시할 경우, 하위 예외 클래스를 먼저 명시하고 마지막에 Exception을 명시해야 동작상의 문제가 발생하지 않음; 부모 클래스는 자식 클래스의 예외 객체를 모두 흡수할 수 있고, catch()문은 순차적으로 확인하기 때문
		catch(NumberFormatException e) { // 데이터가 "100"이면 100으로 parsing하지만 "100?"이면 예외 발생
			System.out.println("숫자가 아닙니다.");
		}
		catch(ArrayIndexOutOfBoundsException e) { // 프로그램 실행시 인자를 전달하지 않은 경우, 배열이 만들어지지 않아 args[0] 호출시 예외 발생
			System.out.println("입력한 데이터가 없습니다.");
		}
		catch(ArithmeticException e) { // var/0 연산시 예외 발생
			System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(Exception e) { // 예외가 발생할 것으로 예상되지만 정확한 클래스명을 모를 경우, 부모 클래스 자료형으로 자동 형변환하여 예외 처리 가능
			System.out.println("예외가 발생했습니다.");
		}
		System.out.println("프로그램 정상 종료");
	}
}