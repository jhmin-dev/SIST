public class ArrayMain04 {
	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50};
		
		// �Ϲ� for��
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}
		
		// Ȯ�� for��(=������ ����)
		for(int num : array) { // �迭 array�� ��Ҹ� ���� num�� ����; �ε����� ������� �ʰ� ���� �迭�� �� �����Ϳ� ����
			System.out.print(num + "\t");
		}
	}
}