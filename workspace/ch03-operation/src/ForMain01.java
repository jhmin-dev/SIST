public class ForMain01 {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			System.out.println(i);
		}
		
		System.out.println("========");
		
		for(int i=1;i<=5;i++)
			System.out.println(i); // 수행문이 한 줄인 경우 {} 블럭 생략 가능
		
		System.out.println("프로그램 종료");
	}
}