public class WhileMain02 {
	public static void main(String[] args) {
		int sum = 0, su = 1; // 초기식
		while(su<=100) { // 조건식
			sum+=su; // 누적
			su++; // 증감식
		}
		System.out.println("1부터 100까지의 합 = "+sum);
	}
}