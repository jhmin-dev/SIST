package kr.s01.list;

public class Member {
	/* [�ǽ�]
	 * ��� ���� : �̸�(name), ����(age), ����(job), �ּ�(address), ��ȭ��ȣ(phone)
	 */
	private String name;
	private int age;
	private String job;
	private String address;
	private String phone;
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}