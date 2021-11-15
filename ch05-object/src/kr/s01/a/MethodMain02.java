package kr.s01.a;
public class MethodMain02 {
	// 정수형 데이터를 반환하는 멤버 메서드
	public int signOf(int a) {
		int sign = 0; // 동작 시작
		if(a>0)
			sign = 1;
		else if(a<0)
			sign = -1; //  동작 끝; 초기값을 선언했기 때문에 else 생략 가능
		return sign; // 결과값 반환
	}
	
	public static void main(String[] args) {
		/*
		 * [실습] 입력한 int형 정수가 음수이면 -1을, 0이면 0을, 양수이면 1을 반환하는 signOf 메서드를 작성하시오.
		 * [출력 예시]
		 * 정수 입력 > 5
		 * 결과값은 ?
		 */
		MethodMain02 method = new MethodMain02(); // 메서드는 객체에 포함되어 동작하기 때문에 반드시 객체를 생성해야 사용 가능
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("정수 입력 > ");
		int result = method.signOf(input.nextInt());
		input.close();
		System.out.println("결과값은 ? " + result);
	}
}