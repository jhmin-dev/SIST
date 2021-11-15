public class IfMain01 {
	public static void main(String[] args) {
		int n = 10;
		// 단일 if문
		if(n > 5) { // 소괄호 안에는 boolean 데이터가 들어감
			System.out.println("n은 5보다 크다");
		}
		
		// if문 블럭 내의 수행문이 한 줄이면 {} 블럭 생략 가능
		if(n < 5)
			System.out.println("n은 5보다 작다");
		
		System.out.println("프로그램 종료");
	}
}