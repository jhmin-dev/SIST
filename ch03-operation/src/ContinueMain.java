public class ContinueMain {
	public static void main(String[] args) {
		for(int i=0;i<=10;i++) {
			if(i%3==0) { // 3�� ����� �� �ǳʶ�
				continue;
			}
			System.out.println(i);
		}
	}
}