public class ArrayMain08 {
	public static void main(String[] args) {
		// Ŭ������ ������ �� main�� ������ args�� ����Ű�� �迭�� �����͸� �����ؼ� Ȱ���� �� ����
		System.out.println(args[0] + args[1]);

		// args�� �ڷ����� String�̶� ���ڸ� �����ص� ���ڿ��� ��ȯ�� �����ϱ� ������ ���꿡 Ȱ���Ϸ��� ������ ��ȯ �۾��� �ʿ���
		int num = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println("�հ� : " + (num + num2));
	}
}