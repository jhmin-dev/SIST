package kr.s04.overriding;
// �θ� Ŭ����
class Dad {
	public String getLunch() {
		return "��";
	}
}
// �ڽ� Ŭ����
class Son extends Dad {
	
}
// �ڽ� Ŭ����
class Daughter extends Dad {
	@Override
	public String getLunch() {
		return "��";
	}
}

public class OverridingMain02 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println("�Ƶ��� " + s.getLunch() + "�� �Դ´�.");
		
		Daughter d = new Daughter();
		System.out.println("���� " + d.getLunch() + "�� �Դ´�.");
	}
}