public class WhileMain02 {
	public static void main(String[] args) {
		int sum = 0, su = 1; // �ʱ��
		while(su<=100) { // ���ǽ�
			sum+=su; // ����
			su++; // ������
		}
		System.out.println("1���� 100������ �� = "+sum);
	}
}