public class ArrayMain07 {
	public static void main(String[] args) { // main �Լ��� �����ϸ� Program arguments�� �Էµ� �����͸� �迭 args�� ����
		if(args.length>0) { // Program arguments�� ������ �Է����� ���� ��� main �Լ��� �����ϸ鼭 �迭�� �����ǳ� �迭�� length�� 0�� ��
			for(int i=0;i<args.length;i++) {
				System.out.print(args[i]+"\t");
			}
		}
		else {
			System.out.println("args.length = " + args.length);
			System.out.println("�Է��� ������ �����ϴ�!");
		}
	}
}