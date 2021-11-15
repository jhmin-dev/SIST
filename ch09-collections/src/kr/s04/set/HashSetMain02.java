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
			set.add(r.nextInt(45)+1); // 1~45 ������ ����, �ߺ��� ����
		}
		System.out.println(set);
		
		ArrayList<Integer> list = new ArrayList<Integer>(set); // Collections.sort() �޼���� List �������̽� �ڷ����� ���ڷ� �ޱ� ������, ArrayList�� �����ڸ� ���� set�� �����͸� ������ list�� ����
		Collections.sort(list);
		for(int num : list) {
			System.out.print(num + "\t");
		}
	}
}