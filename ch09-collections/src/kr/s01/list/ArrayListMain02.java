package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		// 리스트는 저장되는 순서를 유지하며, 중복 저장을 허용
		ArrayList al = new ArrayList();
		al.add("가나다"); // 인덱스 0번, String이 Object로 업캐스팅
		al.add("라마바");
		al.add("사아자");
		al.add("차카파");
		
		// 반복문을 이용한 ArrayList의 요소 출력
		for(int i=0;i<al.size();i++) { // 리스트의 길이는 size() 메서드를 이용
			String name = (String)al.get(i); // ArrayList에 저장된 요소는 get() 메서드를 통해 반환할 수 있으며, Object로 반환되므로 다운캐스팅해야 함
			System.out.println(name);
		}
	}
}