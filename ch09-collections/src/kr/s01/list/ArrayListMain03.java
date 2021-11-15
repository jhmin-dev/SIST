package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		// 제네릭 표현: 객체를 생성할 때 객체에 저장할 수 있는 요소의 자료형을 클래스명과 생성자명 다음에 <>로 지정; 제네릭 표현을 사용하지 않으면 데이터 읽어올 때 ClassCastException 등 예외가 발생할 수 있으므로, 사용이 권장됨
		ArrayList<String> al = new ArrayList<String>();
		al.add("서울"); // 제네릭 표현을 쓰면 Object로 업캐스팅되지 않고 String으로 저장됨
		al.add("부산");
		// al.add(1000); // 제네릭 표현을 써서 ArrayList 객체를 생성할 때 저장되는 객체의 자료형을 String으로 지정했으므로 Integer 객체를 저장할 수 없음(=컴파일시 오류 발생)
		al.add("인천");
		
		// 반복문을 이용한 ArrayList의 요소 출력
		for(int i=0;i<al.size();i++) {
			String city = al.get(i); // 제네릭 표현을 쓰면 Object가 아니라 String으로 반환
			System.out.println(city);
		}
		
		// 확장 for문을 이용한 ArrayList의 요소 출력
		for(String city : al) {
			System.out.println(city);
		}
	}
}