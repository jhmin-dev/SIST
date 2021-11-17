package kr.s07.serial;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private String name;
	private int age;
	private String address;
	
	public UserInfo(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
