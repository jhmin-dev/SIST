package kr.s05.map;

import java.util.HashMap;
// import java.util.Set;
import java.util.Iterator;

public class HashMapMain02 {
	public static void main(String[] args) {
		String[] msg = {"Berlin", "Paris", "Seoul", "New York", "London"};
		HashMap<Integer, String> mp = new HashMap<Integer, String>();

		// �ݺ����� ���� ������ ����
		for(int i=0;i<msg.length;i++) {
			mp.put(i, msg[i]);
		}
		System.out.println(mp);
		
		// �ĺ��ڸ� ��� �����ϰ�, �ĺ��ڸ� ���� ���� �б�; keySet() �޼��带 ���� Set �������̽��� ������ ��ü�� ���� ��, iterator() �޼��带 ���� Iterator ��ü�� �����ؾ� ��
		Iterator<Integer> keys = mp.keySet().iterator(); // mp.keySet()�� Set �������̽� �ڷ���
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ", " + mp.get(key));
		}
	}
}
