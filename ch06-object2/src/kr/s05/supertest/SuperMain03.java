package kr.s05.supertest;
// �θ� Ŭ����
class People2 {
	int a;
	// �θ� Ŭ������ �⺻ �����ڰ� ���� ���ڰ� �ִ� �����ڸ� ���ǵ� �����̱� ������ �ڽ� Ŭ�������� ��ü�� ������ ���� ��������� �θ� Ŭ������ ���ڰ� �ִ� �����ڸ� ȣ���ؾ� ��ü ������ ������
	public People2(int a) {
		this.a = a;
	}
}
// �ڽ� Ŭ����
class Student2 extends People2 { // �����ڸ� ������� ���� ���, �θ� Ŭ������ �⺻ �����ڰ� ���� ������ ���� �߻�
	public Student2() {
		super(100); // �θ� Ŭ������ ���� �ڷ����� int�� �����ڸ� ȣ�� 
	}
}

public class SuperMain03 {
	public static void main(String[] args) {
		
	}
}