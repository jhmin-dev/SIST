public class ArrayMain11 {
	public static void main(String[] args) {
		// 2���� �迭 ����
		int test[][];
		
		// 2���� �迭 ����
		test = new int[2][3]; // 2�� 3��
		
		// 2���� �迭�� �ʱ�ȭ
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
		
		// �迭�� ��� ���
		System.out.println(test[0][0]);
		System.out.println(test[0][1]);
		System.out.println(test[0][2]);
		System.out.println(test[1][0]);
		System.out.println(test[1][1]);
		System.out.println(test[1][2]);
		
		System.out.println("========");
		
		for(int i=0;i<test.length;i++) { // ��
			for(int j=0;j<test[i].length;j++) { // ��
				System.out.println("test[" + i + "][" + j + "]: " + test[i][j]);
			}
		}
		
		// 2���� �迭 ���� �� ����
		int[][] test2 = new int[3][5]; // 3�� 5
		
		// 2���� �迭 ���� �� ����(�����), �ʱ�ȭ
		int[][] test3 = new int[][] {{100, 200, 300}, {400, 500, 600}};
		int[][] test4 = new int[][] { // �������� ����
			{100, 200, 300}, 
			{400, 500, 600}
		};
	}
}