package kr.s07.instanceoftest;
// �θ� Ŭ����
class Car {
	public void drive() {
		System.out.println("����");
	}
	public void stop() {
		System.out.println("����");
	}
}
// �ڽ� Ŭ����
class FireEngine extends Car {
	public void getWater() {
		System.out.println("�� �Ѹ���");
	}
}

public class InstanceofMain02 {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) { // fe�� FireEngine Ÿ�� ��� ����
			System.out.println("This is a FireEngine instance");
		}
		
		if(fe instanceof Car) { // fe�� Car Ÿ�� ��� ����
			System.out.println("This is a Car instance");
		}
		
		if(fe instanceof Object) { // fe�� Object Ÿ�� ��� ����; ��� Ŭ������ Object Ÿ������ ����ȯ ����
			System.out.println("This is an Object instance");
		}
	}
}