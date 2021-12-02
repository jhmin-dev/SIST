package kr.s01.list;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(15);
		al.add(16);
		
		System.out.println(al);
		for(int i=0;i<al.size();i++) { // 요소의 값을 조건부로 삭제하는 경우, 인덱스를 0부터 검사하게 되면 요소가 삭제될 때 인덱스 변동이 일어나 놓치는 요소가 발생; 인덱스를 마지막부터 검사하면 요소를 삭제해도 인덱스 변동이 일어나지 않으므로 문제가 발생하지 않음
			if(al.get(i)%2==0) { //요소의 값이 짝수인 경우
				al.remove(i); // 해당 요소를 삭제
			}
		}
		System.out.println("인덱스 0부터 반복문 시작 : " + al);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(10);
		al2.add(20);
		al2.add(15);
		al2.add(16);
		
		System.out.println(al2);
		for(int i=al2.size();i>0;i--) {
			if(al2.get(i-1)%2==0) {
				al2.remove(i-1);
			}
		}
		System.out.println("마지막 인덱스부터 반복문 시작 : " + al2);
	}
}