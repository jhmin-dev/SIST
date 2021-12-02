package kr.s05.statictest;

public class StaticCount {
	int c; // 인스턴스 변수; 객체 생성시 메모리에 올라감
	static int count; // static(클래스) 변수; 객체 생성과 무관하게 호출되면 메모리에 올라감

	public StaticCount() { // 생성자
		c++;
		count++;
	}
}