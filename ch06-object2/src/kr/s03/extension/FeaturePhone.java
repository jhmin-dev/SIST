package kr.s03.extension;

public class FeaturePhone extends Phone {
	private int pixel; // ������ ȭ�� ��; �ڹٿ��� �Ϲ������� ��� ������ ���� �����ڴ� public�� �����ϰ� ����ϸ�, ���� ������ �ش� ������ ���ǵ� �޼����� ���� �����ڸ� ����
	
	public int getPixel() {
		return pixel;
	}
	
	public FeaturePhone(String number, String model, String color, int pixel) {
		this.number = number;
		this.model = model;
		this.color = color;
		this.pixel = pixel;
	}
}