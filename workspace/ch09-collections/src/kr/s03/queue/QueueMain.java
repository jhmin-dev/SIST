package kr.s03.queue;

import java.util.LinkedList;

public class QueueMain {
	public static void main(String[] args) {
		String[] array = {"서울", "인천", "광주", "부산", "대구"};
		LinkedList<String> ll = new LinkedList<String>();
		
		// ll에 offer() 메서드로 데이터 저장
		for(int i=0;i<array.length;i++) {
			ll.offer(array[i]);
		}
		System.out.println(ll);
		
		// ll에서 poll() 메서드로 데이터 꺼냄(=ll 안의 데이터는 지워짐)
		while(ll.peek()!=null) { // ll에 저장된 첫 번째 요소를 검색
			System.out.print(ll.poll() + "\t"); // ll에 저장된 첫 번째 요소를 반환하고 제거
		}
		System.out.println("\n"+ll);
	}
}