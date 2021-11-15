public class ContinueMain {
	public static void main(String[] args) {
		for(int i=0;i<=10;i++) {
			if(i%3==0) { // 3의 배수일 때 건너뜀
				continue;
			}
			System.out.println(i);
		}
	}
}