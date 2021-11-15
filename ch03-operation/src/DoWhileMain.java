public class DoWhileMain {
	public static void main(String[] args) {
		String str = "Hello World";
		int su = 0;
		
		while(su++ < 5) { // 5회 실행
			System.out.println(str);
		}
		
		System.out.println("========");
		
		int su2 = 0;
		
		do { // 6회 실행; do~while문에 while문과 동일한 조건식 사용할 경우, 항상 do~while문이 while문보다 한 번 더 실행하게 됨
			System.out.println(str);
		} while(su2++ < 5);
	}
}