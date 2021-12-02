package kr.s01.exception;

public class ExceptionMain04 {
	public static void main(String[] args) {
		// try~catch~finally
		System.out.println("예외가 발생하지 않는 경우");
		try {
			System.out.println("1");
			System.out.println("2");
		}
		catch(Exception e) {
			System.out.println("3");
		}
		finally {
			System.out.println("4");
		}
		System.out.println("========");
		System.out.println("예외가 발생하는 경우");
		try {
			System.out.println("1");
			System.out.println(10/0); // 인위적으로 ArithmeticException 발생
			System.out.println("2");
		}
		catch(Exception e) {
			System.out.println("3");
		}
		finally {
			System.out.println("4");
		}
		System.out.println("========");
	}
}