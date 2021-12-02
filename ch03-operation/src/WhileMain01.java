public class WhileMain01 {
	public static void main(String[] args) {
		int i=1; // 초기식 지정
		while(i<=10) { // 조건식 지정
			System.out.println(i++); // 증감식 지정; 증감식을 지정하지 않으면 무한 루프가 발생
		}
		System.out.println("========");
		int j=10;
		while(j>=0) {
			System.out.println(j--);
		}
	}
}