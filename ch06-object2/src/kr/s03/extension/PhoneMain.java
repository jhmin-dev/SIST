package kr.s03.extension;

public class PhoneMain {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("010-1234", "A1001", "White", "Android");
		FeaturePhone fp = new FeaturePhone("010-4321", "Z1001", "Black", 800);
		
		System.out.println("��ȣ\t��\t����\t�ɼ�(OS/ȭ�� ��)");
		
		System.out.print(sp.getNumber() + "\t");
		System.out.print(sp.getModel() + "\t");
		System.out.print(sp.getColor() + "\t");
		System.out.print(sp.getOs() + "\n");
		
		System.out.print(fp.getNumber() + "\t");
		System.out.print(fp.getModel() + "\t");
		System.out.print(fp.getColor() + "\t");
		System.out.print(fp.getPixel() + "\n");
	}
}