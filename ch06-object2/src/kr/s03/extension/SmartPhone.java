package kr.s03.extension;

public class SmartPhone extends Phone {
	private String os;

	public String getOs() {
		return os;
	}
	// SmartPhone ��ü�� �����ϸ� �޸𸮿� ���� Object ������ ���������(Object Ŭ������ ����� �޸𸮿� �ö�), �������� �θ� Ŭ���� ������ ���������(�θ� Ŭ������ ����� �޸𸮿� �ö�), ���������� �ڽ� Ŭ���� ������ ������(�ڽ� Ŭ������ ����� �޸𸮿� �ö�); �� ������ ������ ��ü�� �ƴ϶� �ϳ��� ��ü�̹Ƿ� �ּҴ� �ϳ���
	public SmartPhone(String number, String model, String color, String os) {
		this.number = number; // Phone�� number�� ��ӹ޾ұ� ������ �ڽ�(=this)�� ��ó�� �ν�
		this.model = model;
		this.color = color;
		this.os = os;
	}
}