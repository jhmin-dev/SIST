public class OperatorMain09 {
	public static void main(String[] args) {
		System.out.println("====���� ������====");
		int a = 5, b = 7;
		
		a += b; // a = a + b
		System.out.println("a = " + a);
		
		a -= b; // a = a - b
		System.out.println("a = " + a);
		
		a *= b; // a = a * b; a&=b�� a = a & b�� ������, ��Ʈ ������ AND ������ ������
		System.out.println("a = " + a);
		
		a /= b; // a = a / b
		System.out.println("a = " + a);
		
		a %= b; // a = a % b
		System.out.println("a = " + a);
	}
}