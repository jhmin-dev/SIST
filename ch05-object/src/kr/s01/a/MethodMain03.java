package kr.s01.a;
public class MethodMain03 {
	// ��� ����
	String name;
	int korean;
	int english;
	int math;
	
	// ��� �޼���
	// ���� ���ϱ�
	public int makeSum() { // ���ڰ� ���� ��쿡�� �Ұ�ȣ�� ������ �� ����
		return korean + english + math; // ��� �������� ���� ��ü�� �������̹Ƿ� ���ڷ� ���� �ʾƵ� ���� ������ �� �� ����
	}
	// ��� ���ϱ�
	public int makeAverage() {
		return makeSum() / 3; // ���� ��ü�� ���Ե� �ٸ� ��� �޼��带 ȣ���� �� ����
	}
	
	public static void main(String[] args) {
		MethodMain03 me = new MethodMain03();
		
		me.name = "ȫ�浿";
		me.korean = 98;
		me.english = 97;
		me.math = 96;
		
		System.out.println("�̸� : " + me.name);
		System.out.println("���� : " + me.korean);
		System.out.println("���� : " + me.english);
		System.out.println("���� : " + me.math);
		System.out.println("���� : " + me.makeSum());
		System.out.println("��� : " + me.makeAverage());
	}
}