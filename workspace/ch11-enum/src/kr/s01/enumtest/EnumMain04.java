package kr.s01.enumtest;

enum Item2 {
	ADD(5), DEL(11), SEARCH(2), CANCEL(22);
	
	// 열거 객체 생성시 지정한 상수값들을 저장하기 위한 공간 생성
	private final int var;
	
	// 생성자 정의
	Item2(int v) {
		var = v;
	}
	
	// 상수값을 반환하는 메서드 정의
	public int getVar() {
		return var;
	}
}

public class EnumMain04 {
	public static void main(String[] args) {
		System.out.println(Item2.ADD);
		System.out.println(Item2.DEL);
		System.out.println(Item2.SEARCH);
		System.out.println(Item2.CANCEL);
		
		for(Item2 n : Item2.values()) { // values() 메서드로 배열을 생성해서 확장 for문 이용
			System.out.println(n + " : " + n.getVar()); // getVar() 메서드로 상수값 반환
		}
	}
}