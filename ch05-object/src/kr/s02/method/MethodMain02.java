package kr.s02.method;

public class MethodMain02 {
	// Call by reference
	public void increase(int[] n) { // 배열(객체)의 주소를 n에 전달
		for(int i=0;i<n.length;i++) { // 주소가 저장된 n을 통해 배열에 접근; n과 ref1은 동일한 배열을 가리킴
			n[i]++;
		}
	}
	
	public static void main(String[] args) {
		int[] ref1 = {100, 200, 300}; // 배열의 선언, 생성, 초기화
		for(int i=0;i<ref1.length;i++) { // 메서드 호출 전
			System.out.println("ref1[" + i + "] : " + ref1[i]);
		}
		MethodMain02 me = new MethodMain02(); // 객체의 선언, 생성
		me.increase(ref1); // 메서드 호출
		for(int i=0;i<ref1.length;i++) { // 메서드 호출 후
			System.out.println("ref1[" + i + "] : " + ref1[i]);
		}
	}
}