package kr.s01.member;

class Outer2 {
	// ��� ����
	private int x = 100;
	// ��� ���� Ŭ����
	class Inner2 {
		private int y = 200;
		public void make() {
			System.out.println("x = " + x); // x�� Inner2�� ��� Outer2�� ����� �νĵǱ� ������ Outer2�� private ������ Inner2���� �ٷ� ���� ����; �������� ���� ������� ������ �ȵ���̵忡���� Getters, Setters ����� ��� ���� Ŭ������ ����ϴ� ��
			System.out.println("y = " + y);
		}
	}
}

public class MemberMain02 {
	public static void main(String[] args) {
		Outer2 ot = new Outer2();
		Outer2.Inner2 oi = ot.new Inner2();
		oi.make();
	}
}