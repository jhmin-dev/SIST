package kr.s01.a;
class Car { // �� Ŭ����
	// ��� ���� ���� �ʱⰪ�� �������� �� ����
	String company = "�����ڵ���";
	String model = "���̿��� 5";
	String color = "����";
	int maxSpeed = 350;
	int speed;
}

public class CarMain { // �� Ŭ����
	
	public static void main(String[] args) {
		// ��ü ���� �� ����
		Car myCar = new Car();
		
		// ��ü�� ��� ������ ����� ������ �б�
		System.out.println("����ȸ�� : " + myCar.company);
		System.out.println("�𵨸� : " + myCar.model);
		System.out.println("���� : " + myCar.color);
		System.out.println("�ִ�ӷ� : " + myCar.maxSpeed);
		System.out.println("����ӷ� : " + myCar.speed); // ��� ������ �ʱⰪ�� ���������� ���� ���, �ڷ����� �⺻������ �ʱ�ȭ��; ������ ��� 0, String�� ��� null(��ü�� ������ �ʾ� �ּҰ� ���ٴ� �ǹ�)
		
		// ��� ������ �� ����
		myCar.speed = 60;
		System.out.println("������ ����ӷ� : " + myCar.speed);
	}
}