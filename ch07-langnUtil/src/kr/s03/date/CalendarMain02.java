package kr.s03.date;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("희망 연도와 월을 입력하세요! (예: 연도 > 2021, 월 > 7)");
		System.out.print("연도 > ");
		int year = input.nextInt();
		System.out.print("월 > ");
		int month = input.nextInt();
		input.close();
		
		System.out.println("[ " + year + "년 " + month + "월 ]");
		System.out.println("========");
		System.out.println("일  월  화  수  목  금  토");
	
		// 현재 날짜와 시간을 구함; new로 객체 생성 불가
		Calendar cal = Calendar.getInstance();
		// 희망 연도, 월, 일 세팅; 월의 범위는 0~11이기 때문에 입력 월-1, 일은 달력이 1일부터 시작하기 때문에 1일로 세팅
		cal.set(year, month-1, 1);
		// 1일의 요일을 구하기; 요일의 범위는 1=일요일, 7=토요일
		int week = cal.get(Calendar.DAY_OF_WEEK);
		// 월의 마지막 날짜 구하기
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		
		// 첫 날짜를 표시하기 전 공백 처리
		for(int i=1;i<week;i++) {
			System.out.printf("%3s", " "); // 3칸 잡고 공백 넣음
		}
		// 1일부터 마지막 날짜까지 표시
		for(int i=1;i<=lastOfDate;i++) {
			System.out.printf("%3d", i); // 3칸 잡고 날짜 넣음
			if(week%7==0) System.out.println(); // 토요일이면 줄바꿈
			week++;
		}
		System.out.println("\n========");
	}
}