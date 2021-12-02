package kr.s02.mathtest;

import java.util.Random; // 난수 생성을 위한 클래스

public class RandomMain {
	public static void main(String[] args) {
		String[] gift = {"스마트폰", "TV", "냉장고", "꽝!"};
		
		double ran = Math.random(); // random() 메서드는 0.0 이상, 1.0 미만의 임의의 값을 반환; 난수의 범위가 좁으면 겹칠 우려가 있기 때문에 double 자료형 사용
		System.out.println("발생한 난수 : " + ran);
		
		int get = (int)(ran * gift.length); // 난수의 범위를 가공하여 일의 자리가 배열의 인덱스와 동일한 범위를 갖게 하고, 강제 형변환으로 소숫점 이하 절사
		System.out.println("정수 형태의 난수 : " + get);
		System.out.println("오늘의 선물 : " + gift[get]);

		String[] luck = {"귀인을 만남", "로또 당첨", "피곤한 일", "청혼 받음"};
		
		Random r = new Random(); // static 메서드가 아니라 객체를 생성해야 함
		get = r.nextInt(4); // 0부터 인자에 전달된 값 직전까지의 범위로 정수형 난수 발생
		System.out.println("발생한 난수 : " + get);
		System.out.println("오늘의 운세 : " + luck[get]);
	}
}