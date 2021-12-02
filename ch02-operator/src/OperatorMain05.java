public class OperatorMain05 {
	public static void main(String[] args) {
		System.out.println("====논리 연산자====");
		boolean a, b, result;
		a = true;
		b = false;
		
		result = a && b;
		System.out.println("a && b = " + result);
		
		result = a || b;
		System.out.println("a || b = " + result);
		
		result = !a;
		System.out.println("!a = " + result);
	}
}