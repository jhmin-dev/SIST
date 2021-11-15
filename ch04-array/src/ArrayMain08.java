public class ArrayMain08 {
	public static void main(String[] args) {
		// 클래스를 실행할 때 main의 인자인 args가 가리키는 배열에 데이터를 전달해서 활용할 수 있음
		System.out.println(args[0] + args[1]);

		// args의 자료형이 String이라 숫자를 전달해도 문자열로 변환해 저장하기 때문에 연산에 활용하려면 별도의 변환 작업이 필요함
		int num = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println("합계 : " + (num + num2));
	}
}