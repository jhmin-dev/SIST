public class OperatorMain04 {
	public static void main(String[] args) {
		System.out.println("====�� ������====");
		boolean result;
		int a = 10;
		double b = 10.5;
		
		result = a < b; // int�� a�� double�� �ڵ� ����ȯ�Ǿ� ������ �����
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