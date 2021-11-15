public class OperatorMain04 {
	public static void main(String[] args) {
		System.out.println("====비교 연산자====");
		boolean result;
		int a = 10;
		double b = 10.5;
		
		result = a < b; // int인 a가 double로 자동 형변환되어 연산이 수행됨
		System.out.println("a < b : " + result);
		
		result = a > b;
		System.out.println("a > b : " + result);
		
		result = a >= b;
		System.out.println("a >= b : " + result);
		
		result = a <= b;
		System.out.println("a <= b : " + result);
		
		result = a == b;
		System.out.println("a == b : " + result);
		
		result = a != b;
		System.out.println("a != b : " + result);
	}
}