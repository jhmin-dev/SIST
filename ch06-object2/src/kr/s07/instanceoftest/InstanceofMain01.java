package kr.s07.instanceoftest;

class Parent {
	@Override
	public String toString() {
		return "Parent Ŭ����";
	}
}

class Child extends Parent {
	@Override
	public String toString() {
		return "Child Ŭ����";
	}
}

public class InstanceofMain01 {
	public static void main(String[] args) {
		Parent p = new Parent();
		
		// �����Ͻÿ��� ������ ������, ����� ���� �߻�
		// Child ch = (Child)p;
		
		// ��ü p�� Child �ڷ������� ĳ��Ʈ�� �� �ִ����� instanceof �����ڷ� ����
		if(p instanceof Child) {
			Child ch2 = (Child)p;
			System.out.println(ch2);
		}
		else {
			System.out.println(p);
		}
	}
}