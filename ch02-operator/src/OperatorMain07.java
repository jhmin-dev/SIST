public class OperatorMain07 {
	public static void main(String[] args) {
		System.out.println("====����(����) ������====");
		
		int x = 10, y = -10;
		
		int absX = x >= 0 ? x : -x; // ������ �켱������ ���� �Ұ�ȣ ��� ����������, �������� ���� �Ұ�ȣ ����ص� �������
		int absY = (y >= 0) ? y : -y;
		System.out.println("x = " + x + "�� �� x�� ���밪�� = " + absX);
		System.out.println("x = " + y + "�� �� y�� ���밪�� = " + absY);
	}
}