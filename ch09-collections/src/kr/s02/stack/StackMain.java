package kr.s02.stack;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		String[] array = {"진달래", "백합", "개나리", "벚꽃", "장미"};
		Stack<String> stk = new Stack<String>();
		
		// stk에 push() 메서드로 데이터를 저장
		for(int i=0;i<array.length;i++) {
			stk.push(array[i]);
		}
		System.out.println(stk);
		
		// stk에서 pop() 메서드로 데이터를 꺼냄(=stk 안의 데이터는 지워짐)
		while(!stk.isEmpty()) { // stk이 비어 있지 않은 동안 루프
			System.out.print(stk.pop() + "\t");
		}
		System.out.println("\n"+stk);
	}
}