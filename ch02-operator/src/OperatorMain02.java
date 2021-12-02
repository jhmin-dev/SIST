public class OperatorMain02 {
	public static void main(String[] args) {
		System.out.println("====산술 연산자====");
		
		System.out.println(1 + 1);
		System.out.println(10 - 2);
		System.out.println(10 * 3);
		// 5와 2는 정수 표현의 기본형인 int로 인식되기 때문에 연산 결과는 정수를 출력함
		System.out.println(5 / 2); // 몫을 출력
		System.out.println(5 % 2); // 나머지를 출력
		// 10f나 10.0 등 실수 자료형임을 명시하면 연산 결과도 실수를 출력함(3은 자동 형변환됨)
		System.out.println(10.0 / 3);
	}
}