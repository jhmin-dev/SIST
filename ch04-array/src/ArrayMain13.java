public class ArrayMain13 {
	public static void main(String[] args) {
		// 2���� �迭 ���� �� ����
		int[][] score = {
			{98, 99, 80}, 
			{97, 85, 70}, 
			{84, 88, 95},
			{79, 95, 90},
			{88, 85, 80},
		};
		
		System.out.println("��ȣ\t����\t����\t����\t����\t���");
		for(int i=0;i<score.length;i++) { // ��
			int sum = 0; // ������ �� �ึ�� �ʱ�ȭ �� ������Ű�� ����
			System.out.print(i + 1 + "\t"); // ��ȣ ���
			for(int j=0;j<score[i].length;j++) { // ��
				sum += score[i][j]; // ����
				System.out.print(score[i][j] + "\t"); // ���� ���� ���
			}
			System.out.println(sum + "\t" + sum / score[i].length); // ����, ��� ���
		}
	}
}