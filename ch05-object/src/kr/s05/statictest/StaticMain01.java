package kr.s05.statictest;

public class StaticMain01 {
	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("c : " + sc1.c + ", count : " + StaticCount.count); // static ������ ��ü�� ���ԵǾ� ���� �����Ƿ�, ȣ��� ��ü�� �ƴ϶� Ŭ������ ���� ����
		StaticCount sc2 = new StaticCount();
		System.out.println("c : " + sc2.c + ", count : " + sc2.count); // static ������ ��ü�� ���� ������ ��� ������ �߻������� ������, ���������� ȣ���ϴ� ����� �ƴ�
		StaticCount sc3 = new StaticCount();
		System.out.println("c : " + sc3.c + ", count : " + StaticCount.count); // ��ü�� ��� ���� c�� ��ü�� ���� ������ ������ �ʱⰪ 0���� ���� ��������� �����ڿ� ���� ���� 1�� ��; static ���� count�� �� ���� ��������� �� ������ ��� ������ ���� ������ �����ڰ� ����� ������ 1�� ���� �����ϰ� ��
	}
}