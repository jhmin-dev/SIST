public class ArrayMain01 {
	public static void main(String[] args) {
		// �迭 ����
		char[] ch;
		// �迭 ����
		ch = new char[4]; // �迭�� �ּҰ� ����Ǵ� ch�� �迭���̶�� ��
		// �迭�� �ʱ�ȭ
		ch[0] = 'J'; // �迭�� ����� �����͸� �迭�� ��Ҷ�� ��
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';
		
		// �迭�� ��� ���
		System.out.print(ch[0]);
		System.out.print(ch[1]);
		System.out.print(ch[2]);
		System.out.print(ch[3]);
		System.out.println();
		
		// �ݺ����� �̿��� �迭�� ��� ���
		for(int i=0;i<ch.length;i++) { // �迭�� ���̴� �迭��.length�� ȣ����
			System.out.println("ch[" + i + "] : " + ch[i]);
		}
		
		// �迭�� ���� �� ����
		int[] it = new int[6]; // ������ �迭�� ��� ��Ҵ� 0���� �ʱ�ȭ�Ǿ� ����
		for(int i=0;i<it.length;i++) {
			System.out.println(it[i]);
		}
		
		// �迭 ���� �� ����(����� �迭 ����), �ʱ�ȭ
		char[] ch2 = new char[] {'J', 'a', 'v', 'a'}; // ������ ��� �Է��� ������ ���� ���� �ڵ����� �����Ǹ�, ������ ���� ����ϸ� ���� �߻�
		for (int i=0;i<ch2.length;i++) {
			System.out.println(ch2[i]);
		}
		
		// �迭 ���� �� ����(�Ͻ��� �迭 ����), �ʱ�ȭ
		char[] ch3 = {'��','��'};
		System.out.println(ch3[0]);
		System.out.println(ch3[1]);
	}
}