public class BreakMain03 {
	public static void main(String[] args) {
		// ���� �ݺ������� break label ���
		exit_for: // label ����
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				if(j == 3)
					break exit_for; // break ������ label�� ����ϸ� label�� ������ for���� ��������
				System.out.println("i = " + i + ", j = " + j);
			}
		}
	}
}