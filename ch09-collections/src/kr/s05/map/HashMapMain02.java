package kr.s05.map;

import java.util.HashMap;
// import java.util.Set;
import java.util.Iterator;

public class HashMapMain02 {
	public static void main(String[] args) {
		String[] msg = {"Berlin", "Paris", "Seoul", "New York", "London"};
		HashMap<Integer, String> mp = new HashMap<Integer, String>();

		// 반복문을 통해 데이터 저장
		for(int i=0;i<msg.length;i++) {
			mp.put(i, msg[i]);
		}
		System.out.println(mp);
		
		// 식별자를 모두 추출하고, 식별자를 통해 값을 읽기; keySet() 메서드를 통해 Set 인터페이스를 구현한 객체로 복사 후, iterator() 메서드를 통해 Iterator 객체로 복사해야 함
		Iterator<Integer> keys = mp.keySet().iterator(); // mp.keySet()은 Set 인터페이스 자료형
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ", " + mp.get(key));
		}
	}
}
