package kr.s01.list;

import java.util.Random;
import java.util.ArrayList;

public class ArrayListMain08 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] �ζ� ���α׷�
		 * 1���� 45������ �������� ��ġ�� �ʴ� 6�� ���� ���ϸ鼭 ArrayList�� �����ϰ� ����Ͻÿ�.
		 */
		ArrayList<Integer> lottery = new ArrayList<Integer>();
		Random lt = new Random();
		while(lottery.size()<6) { // lottery�� ���̰� 6�� �Ǹ� ���� �ߴ�
			int num=lt.nextInt(45)+1; // 0���� 44������ �������� ������ ������ �߻��Ͽ� 1�� ���� ���� num�� ����
			if(!lottery.contains(num)) { // lottery�� num�� ���� ���
				lottery.add(num); // lottery�� num�� ����
			}
		}
		System.out.println(lottery);
	}
}