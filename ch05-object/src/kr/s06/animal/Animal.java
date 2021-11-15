package kr.s06.animal;

public class Animal {
	// 멤버 변수
	private String name; // 이름
	private int age; // 나이
	private boolean fly; // 비행 여부
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
	public boolean isFly() { // boolean형은 데이터를 읽어올 때 get이 아닌 is를 사용하는 것이 표준
		return fly;
	}
	public void setFly(boolean fly) {
		this.fly = fly;
	}
	// 인자를 받는 생성자
	public Animal(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}
	// 인자 없는 기본 생성자; 명시하지 않을 경우 기본 생성자 사용 불가
	public Animal() {}
}