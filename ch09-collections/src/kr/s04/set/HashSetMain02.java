package kr.s04.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class HashSetMain02 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Random r = new Random();
		while(set.size()<6) {
			set.add(r.nextInt(45)+1); // 1~45 범위의 난수, 중복값 불허
		}
		System.out.println(set);
		
		ArrayList<Integer> list = new ArrayList<Integer>(set); // Collections.sort() 메서드는 List 인터페이스 자료형만 인자로 받기 때문에, ArrayList의 생성자를 통해 set의 데이터를 복사한 list를 생성
		Collections.sort(list);
		for(int num : list) {
			System.out.print(num + "\t");
		}
	}
}