package kr.s01.extension;
// �θ� Ŭ����
class Parent extends Object { // �⺻������ �����Ǹ�, �ڹ��� ��� Ŭ������ �ڵ������� Object�� ��ӵ�
	int a = 100;
}
// �ڽ� Ŭ����
class Child extends Parent {

}

public class ExtensionMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a); // ��� ���踦 ������ �θ� Ŭ������ �ڿ��� �ڽ� Ŭ�������� ������ �� �� ����
	}
}