package kr.s03.date;

import java.text.DateFormat; // 날짜 및 시간의 출력 형식을 변경하기 위한 클래스
import java.text.SimpleDateFormat; // 날짜 및 시간의 출력 형식을 보다 자유롭게 변경하기 위한 클래스
import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now); // 현재 날짜 및 시간을 기본 형식으로 출력
		// System.out.println(now.toLocaleString()); // 현재 날짜 및 시간을 한국 형식으로 출력; deprecated되어 사용하지 않음
		
		DateFormat df = DateFormat.getInstance(); // SHORT style이 적용된 formatter 객체 반환
		String today = df.format(now); // Date 객체에 포맷을 적용하여 문자열로 반환
		System.out.println(today);
		
		df = DateFormat.getDateTimeInstance(); // FORMAT locale이 적용된 formatter 객체 반환
		today = df.format(now); // Date 객체에 포맷을 적용하여 문자열로 반환
		System.out.println(today);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh:mm:ss"); // 지정한 패턴의 formatter 객체 생성; y는 연도, M은 월, d는 일, E는 요일, a는 오전/오후, h는 0~11시, m은 분, s는 초를 의미하며 yyyy는 4자리로 연도를 출력하라는 의미 
		today = sf.format(now);
		System.out.println(today);		
	}
}