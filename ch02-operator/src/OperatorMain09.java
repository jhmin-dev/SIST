public class OperatorMain09 {
	public static void main(String[] args) {
		System.out.println("====대입 연산자====");
		int a = 5, b = 7;
		
		a += b; // a = a + b
		System.out.println("a = " + a);
		
		a -= b; // a = a - b
		System.out.println("a = " + a);
		
		a *= b; // a = a * b; a&=b는 a = a & b와 같으며, 비트 단위의 AND 연산을 수행함
		System.out.println("a = " + a);
		
		a /= b; // a = a / b
		System.out.println("a = " + a);
		
		a %= b; // a = a % b
		System.out.println("a = " + a);
	}
}