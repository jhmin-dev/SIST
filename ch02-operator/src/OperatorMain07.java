public class OperatorMain07 {
	public static void main(String[] args) {
		System.out.println("====조건(삼항) 연산자====");
		
		int x = 10, y = -10;
		
		int absX = x >= 0 ? x : -x; // 연산자 우선순위로 인해 소괄호 없어도 동작하지만, 가독성을 위해 소괄호 사용해도 관계없음
		int absY = (y >= 0) ? y : -y;
		System.out.println("x = " + x + "일 때 x의 절대값은 = " + absX);
		System.out.println("x = " + y + "일 때 y의 절대값은 = " + absY);
	}
}