package kr.s05.map;

import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableMain {
	public static void main(String[] args) {
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		// h에 put() 메서드로 데이터 저장
		h.put("name", "홍길동");
		h.put("age", "20"); // 값의 자료형을 String으로 지정했기 때문에 10 입력시 예외 발생
		h.put("tel", "010-1234-5678");
		h.put("job", "탐정");
		h.put("address", "서울시");
		h.put("name", "너굴"); // 식별자의 중복을 불허하며, 식별자가 중복되는 경우 마지막에 등록한 값을 저장
		// h.put("zipcode", null); // 실행시 NullPointerException; 값에 null을 인정하지 않음
		// h.put(null, "마포구"); // 실행시 NullPointerException; 식별자에 null을 인정하지 않음
		System.out.println(h);
		
		// get() 메서드에 식별자를 인자로 입력하여 연결된 값을 반환받음
		String name = h.get("name");
		System.out.println("name = " + name);

		System.out.println();
		
		// h에 저장된 식별자 구하기; keys() 메서드를 통해 Enumeration 객체로 복사해야 함
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key + " = " + h.get(key));
		}
	}		
}