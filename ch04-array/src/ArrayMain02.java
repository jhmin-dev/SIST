public class ArrayMain02 {
	public static void main(String[] args) {
		// �迭 ���� �� ����(�Ͻ��� �迭 ����), �ʱ�ȭ
		int[] score = {100,88,88,100,90}; // score.length�� 5�� �����
		int sum = 0;
		float avg = 0.0f;
		
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		avg = sum / (float)score.length; // �и� �迭�� ���̸� �̿��ϰ� �Ǹ�, �迭�� ��Ҹ� �߰��ϰų� �����ϴ��� �и� ������ �ʿ� ����
		
		System.out.printf("���� : %d\n��� : %.2f", sum, avg);
	}
}