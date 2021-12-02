public class ArrayMain10 {
	public static void main(String[] args) {
		/*
		 * [실습] 
		 * 단을 입력받아서 1부터 9까지 곱해서 결과값을 구하고 배열에 그 값을 저장한 후, 구구단 출력 형식(2 * 1 = 2)으로 배열에서 값을 불럴와 출력하시오.
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		int[] array = new int[9];
		int dan;
		while(true) {
			System.out.print("단을 입력하세요 > ");
			dan = input.nextInt();
			if(dan>=1&&dan<=9) {
				break;
			}
			System.out.println("단은 1부터 9까지만 가능합니다.");
		}
		for(int i=0;i<array.length;i++) {
			array[i] = dan*(i+1); // 배열의 인덱스와 구구단의 곱하는 수가 같지 않음 유의
			System.out.printf("%d * %d = %d\n", dan, i+1, array[i]);
		}
		input.close();
	}
}