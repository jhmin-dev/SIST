public class SwitchMain03 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수 2개를 입력 받고 산술 연산자(+,-,*,/,%)를 입력받아 연산을 수행한 결과를 출력하시오.
		 * [출력 예시]
		 * 첫 번째 수 : 7
		 * 연산자 : +
		 * 두 번째 수 : 5
		 * 7 + 5 = 12
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int result = 0;
			
		System.out.print("첫 번째 수를 입력하세요 : ");
		int first = input.nextInt();
		System.out.print("연산자를 입력하세요 : ");
		String operator = input.next();
		System.out.print("두 번째 수를 입력하세요 : ");
		int second = input.nextInt();
		
		switch(operator) {
		case "+":
			result = first + second; break; // 줄바꿈은 세미콜론으로 구분하기 때문에 수행문과 break가 한 줄이어도 됨
		case "-":
			result = first - second; break;
		case "*":
			result = first * second; break;
		case "/":
			if(second==0) { // 0으로 나누는 연산을 수행하려 하면 자바에서 오류가 발생하므로, 이를 안내하고 정상 종료시키기 위함
				System.out.println("\n0으로 나눌 수 없습니다.");
				System.exit(0); // 프로그램을 종료하지 않으면 출력문 수행시 변수 초기화가 안 되어 오류가 발생함
			}
			result = first / second; break;
		case "%":
			if(second==0) {
				System.out.println("\n0으로 나눌 수 없습니다.");
				System.exit(0);
			}
			result = first % second; break;
		default:
			System.out.println(); // 단순 줄바꿈
			System.out.println("연산자를 잘못 입력하였습니다.");
			System.exit(0); // 프로그램 종료; 잘못된 연산자 입력한 경우에 출력문이 수행되지 않도록 하기 위함
		}

		System.out.printf("\n%d %s %d = %d\n", first, operator, second, result);

		input.close();
	}
}