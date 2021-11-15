public class VariableTypeMain01 {
	public static void main(String[] args) {
		System.out.println("====����====");
		// ����: ũ�� 1byte, ǥ�� ���� true, false
		boolean b = true; // �������� �ڷ��� �´� �����͸� ���� �� ����(���ڿ��� ������ ���� �Ұ�)
		System.out.println("b = " + b);
		
		System.out.println("====������====");
		// ������: ũ�� 2byte, ǥ�� ���� 0 ~ 65,535(���ڸ� ���ڷ� ��ȯ�� ����)
		// �������� ũ�Ⱑ 1byte�� ��� ����, ���ڿ� �Ϻ� Ư�����ڸ� ó�� ����(ASCII)������ 2byte�� ��� �ѱ�, ���� � ó�� ����(Unicode)
		char c1 = 'A';
		System.out.println("c1 : " + c1);
		char c2 = 65; // A�� �ƽ�Ű �ڵ� ���� ����; ������ ��� �����ڵ� �ȿ� �ƽ�Ű �ڵ尡 ���ԵǾ� �־� �� �� ��� ����
		System.out.println("c2 : " + c2); // A�� ��µ�
		char c3 = '\u0041'; // A�� �����ڵ� ��(16����, ��������u�� �����ڵ����� ǥ��) ����
		System.out.println("c3 : " + c3);
		char c4 = '��';
		System.out.println("c4 : " + c4);
		char c5 = '\uc790'; // ���� �����ڵ� �� ����
		System.out.println("c5 : " + c5); // �ڰ� ��µ�
		
		System.out.println("====������====");
		// byte: ũ�� 1byte, ǥ�� ���� -128 ~ 127
		// byte�� ��� ǥ�� ������ ���� ���꿡�� �� ������� ������ ����¿� �����
		byte b1 = 127; // 128 �� ���� �ʰ��� ���� ���� �Ұ�
		System.out.println(" b1 : " + b1);
		// short: ũ�� 2byte, ǥ�� ���� -32,768 ~ 32,767
		short s1 = -32768; // 32768 �� ���� �ʰ��� ���� ���� �Ұ�
		System.out.println(" s1 : " + s1);
		// int: ũ�� 4byte, ǥ�� ���� -2,147,483,648 ~ 2,147,483,647
		// int�� ��� ������ �⺻ �ڷ������� ���� �ڷ����� �� ���� ���� ����
		int n1 = 1000;
		System.out.println("n1 : " + n1);
		// long: ũ�� 8byte
		// ���� ���α׷� �� ū ���� �ٷ�� �� �� �����, ��Ʃ�� ��ȸ���� ��� int�� ǥ���ϴٰ� 21�� �並 �ʰ��ϴ� ������ �����鼭 long���� �ٲ�
		long lg = 1000L; // long ������ 1000 ���Խ� �ڹٴ� ���� ǥ���� �⺻���� int�� �ν� �� long���� ��ȯ��; ���� �ڿ� l�̳� L�� ���̸� ó������ long���� �ν���
		System.out.println("lg : " + lg);
		
		System.out.println("====�Ǽ���====");
		// float: ũ�� 4byte
		float f1 = 4.5f; // �Ҽ��� ���� ���� ��� �ڹٰ� �Ǽ� ǥ���� �⺻���� double�� �ν��Ͽ� float ������ �� ū �ڷ����� ���� �������� ���ϰ� ������ �߻���; ���� �ڿ� f�� F�� ���̸� ó������ float���� �ν���
		System.out.println("f1 : " + f1);
		// double: ũ�� 8byte, �Ǽ��� �⺻ �ڷ������� float���� �� ������
		double d1 = 9.8;
		System.out.println("d1 = " + d1);

		System.out.println("====���ڿ� ǥ��====");
		// ���ڿ��� �⺻ �ڷ����� �ƴ����� ���� ����ϱ� ������ ���� �����ϴ� ���� �̸� ���
		String str = "Hello World!"; // �⺻ �ڷ����� �ҹ��ڷ� ����������, ���� �ڷ����� �빮�ڷ� ������
		System.out.println("str : " + str);
	}
}