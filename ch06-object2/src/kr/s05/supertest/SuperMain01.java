package kr.s05.supertest;
// �θ� Ŭ����
class Dad {
	public String getLunch() {
		return "��";
	}
}
// �ڽ� Ŭ����
class Daughter extends Dad {
	@Override
	public String getLunch() {
		return "��";
	}
	// �θ� Ŭ���� ������ getLunch �޼��带 ȣ��
	public String getRice() {
		return super.getLunch();
	}
}

public class SuperMain01 {
	public static void main(String[] args) {
		Daughter d  = new Daughter();
		System.out.println("���� " + d.getLunch() + "�� �Դ´�.");
		System.out.println("���� �����Ͽ��� " + d.getRice() + "�� �Դ´�.");
	}
}