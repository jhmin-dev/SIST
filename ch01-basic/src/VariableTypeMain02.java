public class VariableTypeMain02 {
	public static void main(String[] args) {
		// '�� �Ϲ� ����ó�� ����ϱ� ���� �տ� \�� ����
		char single = '\'';
		System.out.println(single);
		
		// "�� �Ϲ� ����ó�� ����ϱ� ���� �տ� \�� ����
		String str = "������ \"����\"�� �� �Ϳ�";
		System.out.println(str);
		
		// ���ڿ� ���� '�� \�� ������ �ʾƵ� �Ϲ� ���ڷ� ��ȯ�Ǿ� ��µǸ�, \ �ٿ��� ������ ���
		String str2 = "������ '�����'�Դϴ�.";
		System.out.println(str2);
		
		// ��� ������ \�� �Ϲ� ����ó�� ����ϱ� ���� �տ� \�� ����
		String dir = "C:\\Program Files\\Java";
		System.out.println(dir);

		String str3 = "������ �ݿ���\n�𷹴� �����";
		System.out.println(str3);
		
		String str4 = "�̸�\t����\t���";
		System.out.println(str4);
	}
}