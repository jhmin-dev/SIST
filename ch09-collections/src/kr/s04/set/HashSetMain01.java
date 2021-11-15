package kr.s04.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain01 {
	public static void main(String[] args) {
		String[] array = {"Java", "Oracle", "JSP", "Java", "HTML"};
		HashSet<String> hs = new HashSet<String>();
		
		// 데이터 저장
		for(String n : array) {
			hs.add(n); // 중복 불허; add() 메서드에서 걸러냄
		}
		System.out.println(hs); // 정렬을 보장하지 않음

		// 데이터 읽기; HashSet에서 바로 읽는 것이 아니라, Iterator로 복사해서 읽는 것이 원칙
		Iterator<String> ir = hs.iterator(); // iterator() 메서드로 HashSet의 데이터를 Iterator에 복사
		while(ir.hasNext()) { // hasNext() 메서드로 저장된 데이터가 있는지 확인
			System.out.println(ir.next()); // next() 메서드로 데이터를 꺼냄
		}
		
		System.out.println();
		
		// 확장 for문을 이용한 데이터 읽기
		for(String s : hs) {
			System.out.println(s);
		}		
	}
}