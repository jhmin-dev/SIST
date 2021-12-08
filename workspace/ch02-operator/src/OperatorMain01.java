public class OperatorMain01 {
	public static void main(String[] args) {
		System.out.println("====증감 연산자====");
		// 증가 연산자
		int i = 5;
		System.out.println(++i); // i를 1 증가시킨 후 증가된 값 6을 출력
		System.out.println(i++); // i의 현재 값 6을 출력한 후 값을 1 증가시켜 7을 메모리에 저장
		System.out.println(i); // 7을 출력

		// 감소 연산자
		int j = 10;
		System.out.println(--j);
		System.out.println(j--);
		System.out.println(j);
	}
}