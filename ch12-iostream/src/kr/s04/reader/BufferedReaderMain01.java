package kr.s04.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // InputStreamReader는 System.in으로 받은 바이트 스트림을 문자 스트림으로 변환하여 BufferedReader에 전달
			System.out.print("당신의 이름 > ");
			String name = br.readLine();
			System.out.println(name);
			System.out.print("당신의 나이 > ");
			int age = Integer.parseInt(br.readLine()); // String을 int로 변환
			System.out.println(age);
		}
		catch(NumberFormatException e) { // parseInt() 메서드 사용시 권장
			e.printStackTrace();
		}
		catch(IOException e) { // readLine() 메서드 사용시 의무
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}