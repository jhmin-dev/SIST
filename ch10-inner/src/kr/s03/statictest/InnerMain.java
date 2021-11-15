package kr.s03.statictest;

public class InnerMain {
	// static ���� Ŭ����
	public static class StaticInner {
		int iv = 100;
		static int cv = 200; // ���� Ŭ������ static���� �������� ������ ������ ����
		public void fun() {
			System.out.println("fun �޼���");
		}
		public static void make() { // ���� Ŭ������ static���� �������� ������ ������ ����
			System.out.println("make �޼���");
		}
	}
	
	public static void main(String[] args) {
		// static ���� Ŭ������ static ������ static �޼��忡 ���ٽ� .���� �ܺ� Ŭ�������� �Բ� ����ؾ� ��
		System.out.println(InnerMain.StaticInner.cv);
		InnerMain.StaticInner.make();
		// static ���� Ŭ������ ��ü�� (�ܺ� Ŭ���� ��ü ������ ��ġ�� �ʰ�) �ܵ����� ����
		InnerMain.StaticInner si = new InnerMain.StaticInner();
		// static ���� Ŭ������ �ν��Ͻ� ������ �ν��Ͻ� �޼���� ��ü ���� �� ȣ�� ����
		System.out.println(si.iv);
		si.fun();
	}
}