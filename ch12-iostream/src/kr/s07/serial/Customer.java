package kr.s07.serial;

import java.io.Serializable;

public class Customer implements Serializable { // Serializable �������̽��� �����ϸ� �ش� Ŭ������ ��ü ����ȭ ����� �Ǿ� ��ü ����ȭ�� ���� ����; Serializable�� �������� ������ ��ü ����ȭ �Ұ�; Serializable �������̽��� ��� �ִ� �������̽���, �����ؾ� �� ������ �߻� �޼��� ������ ���� ����; �����Ͱ� �� ��� ������ ����ȭ ���
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
