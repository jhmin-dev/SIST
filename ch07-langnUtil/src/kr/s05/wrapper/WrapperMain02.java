package kr.s05.wrapper;

public class WrapperMain02 {
	public static void main(String[] args) {
		// ��������� ��ü ����
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		
		// ����
		int result = obj1.intValue() + obj2.intValue(); // intVaule() �޼��带 �̿��� ��ü�� �����͸� int�� ��ȯ
		System.out.println("result = " + result);
		
		// �Ͻ������� ��ü ����
		Integer obj3 = 10;
		Integer obj4 = 20;
		int result2 = obj3 + obj4; // �ڵ� Boxing, Unboxing�� �Ͼ�Ƿ� ������ �޼��� �ʿ� ���� Integer ��ü���� �ٷ� �����ϰ� �� ����� int ������ ���� ����
		System.out.println("result2 = " + result2);
	}
}