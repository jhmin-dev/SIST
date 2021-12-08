public class VariableMain01 {
	public static void main(String[] args) {
		// 변수(Variable)는 값을 저장할 수 있는 메모리의 공간

		// 변수 선언
		int num; // 자료형을 지정해야 함; 정수값만 저장 가능한 변수를 생성(num이라는 메모리 공간 할당)

		// 변수의 초기화
		num = 17; // 생성된 변수(num이 가리키는 빈 메모리 공간)에 17을 대입(저장)
		
		// 출력
		System.out.println(num); // num을 통해 메모리 공간에 접근해 값을 출력
		
		// 변수 선언 및 초기화
		int number = 20; // 메모리 공간을 할당하고 20을 대입
		
		// 출력
		System.out.println(number);
		
		// 동일한 변수명을 선언시 오류 발생(변수명은 unique해야 함)
		// int number = 30;
		
		// 변수에 저장한 데이터 변경
		int number2 = 100;
		System.out.println(number2);
		number2 = 90;
		System.out.println(number2);
		
		System.out.println("========");
		
		// 동일한 자료형의 변수 선언시 두 번째 변수명 앞의 자료형은 생략 가능
		// int a = 10;
		// int b = 20;
		int a = 10, b = 20;
		int result = a + b;
		System.out.printf("result = %d\n", result);
		
		// 합 연산자는 문자열이 섞여 있는 경우 덧셈이 아니라 연결을 수행함(문자의 경우 덧셈 수행)
		System.out.println("결과 = " + a + b); // 1020 출력; 문자열 다음에 숫자가 오는 경우 연결해서 새 문자열 생성
		System.out.println("결과 = " + (a + b)); // 30 출력; 숫자끼리의 덧셈 먼저 수행 후 문자열 연결
		System.out.println(a + b + " = 결과"); // 30 출력; 숫자들이 문자열 앞에 오기 때문에 덧셈 먼저 수행 후 문자열 연결
		System.out.println(a + b); // 30 출력
		
		// 변수 선언 후 초기화하지 않으면 연산이나 출력 불가(오류 발생)
		int no;
		// System.out.println(no);
	}
}