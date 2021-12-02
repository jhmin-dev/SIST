public class OperatorMain06 {
	public static void main(String[] args) {
		// 증감 연산자, 비교 연산자, 논리 연산자
		int a, b;
		a = b = 10;
		
		boolean c = a++ >= ++b && ++a > b++; // 전건은 10>=11 연산 후 a를 11로 변경하며, 논리곱의 전건이 false이므로 후건은 실행하지 않음

		System.out.println(a + ", " + b);
		System.out.println("c = " + c);
		
		int d, e;
		d = e = 10;
		
		boolean f = ++d > e++ || d++ >= ++e; // 전건은 11>10 연산 후 e를 11로 변경하며, 논리합의 전건이 true이므로 후건은 실행하지 않음
		
		System.out.println(d + ", " + e);
		System.out.println("f = " + f);
	}
}