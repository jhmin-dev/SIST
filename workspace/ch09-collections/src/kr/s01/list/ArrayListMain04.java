package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("사과");
		al.add("망고");
		al.add("바나나");
		al.add("오렌지");
		al.add("사과");

		System.out.println("삭제 전");
		for(int i=0;i<al.size();i++) {
			System.out.println(i + " : " + al.get(i));
		}

		// al.remove(2); // remove() 메서드에 인덱스 값을 입력하여 지정한 요소 삭제; 인덱스 변동 발생
		al.remove("사과"); // remove() 메서드에 저장된 요소를 입력시, 일치하는 (첫 번째) 요소 삭제; 인덱스 변동 발생

		System.out.println("삭제 후");
		for(int i=0;i<al.size();i++) {
			System.out.println(i + " : " + al.get(i));
		}
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(10);
		al2.add(5);
		al2.add(3);
		al2.add(20);
		
		System.out.println("삭제 전");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i + " : " + al2.get(i));
		}
		
		// al2.remove(2); // 인덱스를 지정해 요소 삭제
		// Integer n = 10;
		// al2.remove(n); // 10과 일치하는 요소 삭제
		al2.remove((Integer)10); // 그냥 10을 입력하면 int라 인덱스로 인식하여 예외 발생하므로 Integer임을 명시해야 함
		
		System.out.println("삭제 후");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i + " : " + al2.get(i));
		}
		
		al2.set(1, 30); // set() 메서드에 인덱스를 지정하고 변경할 데이터를 입력하여 지정한 요소의 데이터를 변경
		System.out.println("변경 후");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i + " : " + al2.get(i));
		}
	}
}