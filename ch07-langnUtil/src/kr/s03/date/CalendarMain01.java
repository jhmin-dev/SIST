package kr.s03.date;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); // 추상 클래스라 new로 객체 생성하지 못하고 getInstance() 메서드로 객체 반환; 자식 클래스 GregorianCalendar 객체가 생성됨
		System.out.println(today); // 식별자(=static 상수)와 값의 쌍으로 구성
		
		int year = today.get(Calendar.YEAR); // get()메서드로 식별자와 매칭된 값을 반환
		int month = today.get(Calendar.MONTH) + 1; // MONTH의 경우 내부적으로 0~11로 처리하기 때문에 11월은 10의 값을 가짐
		int date = today.get(Calendar.DATE);
		System.out.println(year + "년 " + month + "월 " + date + "일");
		
		int day = today.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK는 1이 일요일, 7이 토요일을 의미
		/*
		String nday = ""; // 빈 문자열로 초기화
		switch(day) {
		case 1: nday = "일"; break;
		case 2: nday = "월"; break;
		case 3: nday = "화"; break;
		case 4: nday = "수"; break;
		case 5: nday = "목"; break;
		case 6: nday = "금"; break;
		case 7: nday = "토"; break;
		System.out.println(nday + "요일");
		}
		*/
		String weekday = "일월화수목금토";
		System.out.println(weekday.charAt(day + 1) + "요일");
		
		int amPm = today.get(Calendar.AM_PM); // 오전=0, 오후=1
		System.out.println(amPm == Calendar.AM ? "오전" : "오후");
		
		int hour = today.get(Calendar.HOUR); // 12시간 표기법; HOUR_OF_DAY는 24시간 표기법
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		System.out.println(hour + ":" + min + ":" + sec);
	}
}