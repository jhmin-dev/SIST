package kr.s01.a;
public class MethodMain03 {
	// 멤버 변수
	String name;
	int korean;
	int english;
	int math;
	
	// 멤버 메서드
	// 총점 구하기
	public int makeSum() { // 인자가 없는 경우에도 소괄호는 생략할 수 없음
		return korean + english + math; // 멤버 변수들이 같은 객체의 구성원이므로 인자로 받지 않아도 값을 가져다 쓸 수 있음
	}
	// 평균 구하기
	public int makeAverage() {
		return makeSum() / 3; // 같은 객체에 포함된 다른 멤버 메서드를 호출할 수 있음
	}
	
	public static void main(String[] args) {
		MethodMain03 me = new MethodMain03();
		
		me.name = "홍길동";
		me.korean = 98;
		me.english = 97;
		me.math = 96;
		
		System.out.println("이름 : " + me.name);
		System.out.println("국어 : " + me.korean);
		System.out.println("영어 : " + me.english);
		System.out.println("수학 : " + me.math);
		System.out.println("총점 : " + me.makeSum());
		System.out.println("평균 : " + me.makeAverage());
	}
}