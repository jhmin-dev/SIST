package kr.s05.map;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		
		// mp에 put() 메서드로 데이터 저장
		mp.put("너굴", 95);
		mp.put("콩돌", 100);
		mp.put("밤돌", 85);
		mp.put("링크", 93);
		mp.put("젤다", 70);
		mp.put("콩돌", 0); // Map 인터페이스는 식별자의 중복을 불허하며, 식별자가 중복되었을 경우 마지막에 등록한 값을 저장
		mp.put("가논", null); // 값으로 null 인정
		mp.put(null, 100); // 식별자로 null 인정
		System.out.println(mp);
		
		// get() 메서드에 식별자를 인자로 입력하여 연결된 값을 반환받음
		int num = mp.get("콩돌"); // Integer에서 int로 자동 변환 발생
		System.out.println("콩돌의 성적은 " + num);
		int nullnum = mp.get(null);
		Integer nullnum2 = mp.get("가논"); // int로 변수 선언시 Integer를 int로 변환하는 과정에서 예외 발생; 저장시에는 문제가 없어도 호출시 문제될 수 있으므로 조건문으로 null 제외하도록 검증하는 것이 안전
		System.out.println("식별자 null : " + nullnum + ", 값 null : " + nullnum2);
	}
}