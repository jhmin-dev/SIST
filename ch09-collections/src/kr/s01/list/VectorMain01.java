package kr.s01.list;

import java.util.Vector;

public class VectorMain01 {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		// 객체
		v.add(100.3);
		v.add(3.14);
		v.add(1000.); // 1000.0에서 0 생략 가능
		
		// 확장 for문
		for(Double n : v) {
			System.out.println(n); // Vector에 저장된 요소 출력
		}
		
		// 자원 검색
		double search = 1000.0; // 검색할 요소
		int index = v.indexOf(search);
		if(index!=-1) { // 검색할 요소가 v에 있는 경우
			System.out.println("검색 요소 " + search + "의 위치 : " + index);
		}
		else { // 검색할 요소가 v에 없는 경우
			System.out.println("검색 요소 " + search + "이/가 v에 없습니다.");
		}
		
		// 자원 삭제
		double del = 3.14; // 삭제할 요소
		if(v.contains(del)) { // 삭제할 요소가 v에 있는 경우
			v.remove(del);
			System.out.println(del + "의 삭제를 완료하였습니다 : " + v);
		}
		else { // 삭제할 요소가 v에 없는 경우
			System.out.println(del + "이/가 v에 없습니다 : " + v);
		}
	}
}