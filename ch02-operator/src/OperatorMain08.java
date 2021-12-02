public class OperatorMain08 {
	public static void main(String[] args) {
		System.out.println("====조건(삼항) 연산자====");
		int a = 5, b = 10;
		int max, min;
		
		max = a > b ? a : b;
		min = a < b ? a : b;
		
		System.out.println(a + "와 " + b + "의 최댓값은 " + max);
		System.out.println(a + "와 " + b + "의 최솟값은 " + min);
	}
}