package kr.s02.overloading;

public class OverloadingMain02 {
	// ���޵Ǵ� ������ �ڷ����� String���� ��ȯ�Ͽ� ���ڿ��� ���̸� ���ϴ� �޼��� �����
	public void getLength(int n) {
		String s = String.valueOf(n);
		getLength(s); // println�� �ݺ������� ���� ���, �̹� ������ �޼��带 ȣ��; s�� String�̱� ������ ���ڰ� String�� getLength�� ȣ���ϰ� ��
	}
	void getLength(float n) {
		String s = String.valueOf(n);
		getLength(s);
	}
	private void getLength(String s) {
		System.out.println(s + "�� ���� : " + s.length());
	}
	
	public static void main(String[] args) {
		OverloadingMain02 om = new OverloadingMain02();
		om.getLength(1000); // 1, 0, 0, 0 ������ ���ڷ� ��޵Ǵ� ���ڿ��� ���̸� ����
		om.getLength(3.14f); // 3, ., 1, 4 ������ ���ڷ� ��޵Ǵ� ���ڿ��� ���̸� ����
		om.getLength("Hello");
	}
}