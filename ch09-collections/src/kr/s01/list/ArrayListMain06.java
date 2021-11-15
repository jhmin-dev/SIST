package kr.s01.list;

import java.util.ArrayList;
import java.util.Collections; // ArrayList에는 정렬 메서드가 없음

public class ArrayListMain06 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루");
		list.add("사과");
		list.add("앵두");
		list.add("자두");
		list.add("사과");
		list.add("사과");
		
		// 인덱스 탐색
		int index1 = list.indexOf("사과"); // 앞에서부터 "사과"를 탐색
		System.out.println("첫 번째 사과 : " + index1);
		int index2 = list.lastIndexOf("사과"); // 끝에서부터 "사과"를 탐색
		System.out.println("마지막 사과 : " + index2);
		int index3 = list.indexOf("망고"); // 없는 요소의 인덱스를 탐색하면 -1로 반환
		System.out.println("망고 : " + index3);
		
		// 정렬
		Collections.sort(list); // 사전순으로 요소를 정렬(=인덱스 재배치)
		System.out.println(list);
		Collections.reverse(list); // 사전순의 역순으로 요소를 정렬
		System.out.println(list);
	}
}