public class DoWhileMain {
	public static void main(String[] args) {
		String str = "Hello World";
		int su = 0;
		
		while(su++ < 5) { // 5ȸ ����
			System.out.println(str);
		}
		
		System.out.println("========");
		
		int su2 = 0;
		
		do { // 6ȸ ����; do~while���� while���� ������ ���ǽ� ����� ���, �׻� do~while���� while������ �� �� �� �����ϰ� ��
			System.out.println(str);
		} while(su2++ < 5);
	}
}