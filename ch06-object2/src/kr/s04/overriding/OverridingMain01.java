package kr.s04.overriding;
// �θ� Ŭ����
class GrandParent {
	public String getCar() {
		return "���� �ڵ���";
	}
}
// �ڽ� Ŭ����
class Father extends GrandParent {
	// �޼��� �������̵�; �޼����� ������ ���� ���븸 ��ü
	@Override
	public String getCar() {
		return "���� �ڵ���";
	}
}
// �ڽ� Ŭ����
class Uncle extends GrandParent {
	
}

public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(ft.getCar()); // GrandParent���� ��ӹ��� �޼��� ��� Father���� �������� �޼��尡 ȣ���
		
		Uncle uc = new Uncle();
		System.out.println(uc.getCar()); // GrandParent���� ��ӹ��� �޼��尡 ȣ���
	}
}