public class ArrayMain10 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] 
		 * ���� �Է¹޾Ƽ� 1���� 9���� ���ؼ� ������� ���ϰ� �迭�� �� ���� ������ ��, ������ ��� ����(2 * 1 = 2)���� �迭���� ���� �ҷ��� ����Ͻÿ�.
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		int[] array = new int[9];
		int dan;
		while(true) {
			System.out.print("���� �Է��ϼ��� > ");
			dan = input.nextInt();
			if(dan>=1&&dan<=9) {
				break;
			}
			System.out.println("���� 1���� 9������ �����մϴ�.");
		}
		for(int i=0;i<array.length;i++) {
			array[i] = dan*(i+1); // �迭�� �ε����� �������� ���ϴ� ���� ���� ���� ����
			System.out.printf("%d * %d = %d\n", dan, i+1, array[i]);
		}
		input.close();
	}
}