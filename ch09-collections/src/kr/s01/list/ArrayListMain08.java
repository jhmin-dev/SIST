package kr.s01.list;

import java.util.Random;
import java.util.ArrayList;

public class ArrayListMain08 {
	public static void main(String[] args) {
		/*
		 * [실습] 로또 프로그램
		 * 1부터 45까지의 범위에서 겹치지 않는 6개 수를 구하면서 ArrayList에 저장하고 출력하시오.
		 */
		ArrayList<Integer> lottery = new ArrayList<Integer>();
		Random lt = new Random();
		while(lottery.size()<6) { // lottery의 길이가 6이 되면 루프 중단
			int num=lt.nextInt(45)+1; // 0부터 44까지의 범위에서 정수형 난수를 발생하여 1을 더한 값을 num에 저장
			if(!lottery.contains(num)) { // lottery에 num이 없는 경우
				lottery.add(num); // lottery에 num을 저장
			}
		}
		System.out.println(lottery);
	}
}