public class CastMain02 {
	public static void main(String[] args) {
		System.out.println("====����� ����ȯ(���� ����ȯ)====");
		// ū �ڷ������� ���� �ڷ������� ������ �Ͼ�� ����
		// ������ �ս��� �߻��� �� ����
		
		byte b1 = 127;
		byte b2 = 127;
		// ĳ��Ʈ �����ڸ� �̿��Ͽ� int�� ��� �� b1 + b2�� byte�� ���� ����ȯ��; ��� ���� byte�� ǥ�� ������ ����� ������ ������ �ս��� �Ͼ
		byte result1 = (byte)(b1 + b2);
		System.out.println("result1 = " + result1);
		
		short s1 = 1000;
		short s2 = 2000;
		// ĳ��Ʈ �����ڸ� �̿��Ͽ� int�� ��� �� s1 + s2�� short�� ���� ����ȯ��; ��� ���� short�� ǥ�� ���� �ȿ� �ֱ� ������ ������ �ս��� ����
		short result2 = (short)(s1 + s2);
		System.out.println("result2 = " + result2);
		
		int in1 = 2345;
		float f1 = 25.67f;
		// ĳ��Ʈ �����ڸ� �̿��Ͽ� float�� f1�� int�� ���� ����ȯ �� in1�� ������; �Ҽ��� ���� �ڸ��� ���� ������ �սǵ�(���� ó��, �ݿø��Ϸ��� Math.round() �Լ� �̿�)
		int result3 = in1 + (int)(f1);
		System.out.println("result3 = " + result3);
		
		int in2 = 1234;
		long lg1 = 1234L;
		// ĳ��Ʈ �����ڸ� �̿��Ͽ� long�� lg1�� int�� ���� ����ȯ �� int2�� ������; ������ �ս��� �߻����� ����
		int result4 = in2 + (int)(lg1);
		System.out.println("result4 = " + result4);
	}
}