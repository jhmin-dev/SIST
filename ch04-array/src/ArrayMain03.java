public class ArrayMain03 {
	public static void main(String[] args) {
		// �迭�� ���� �� ����, �ʱ�ȭ
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		// ���� ���ذ��� �迭 ���� ���� �����; �迭�� ���ԵǾ� ���� ���� ������ �� ���� �ִ�, �ּڰ� �񱳰� ����� �������� ���� �� ����
		int max = score[0]; // �迭�� ù ��° ������ �ִ��� �ʱ�ȭ
		int min = score[0]; // �迭�� ù ��° ������ �ּڰ��� �ʱ�ȭ
		
		for(int i=1;i<score.length;i++) { // ���ذ��� �迭�� ù ��° ���̹Ƿ� �ڱ� �ڽŰ��� �񱳴� ����
			if(score[i] > max) {
				max = score[i];
			}
			if(score[i] < min) {
				min = score[i];
			}
		}
		
		System.out.println("�ִ� : " + max);
		System.out.println("�ּڰ� : " + min);
	}
}