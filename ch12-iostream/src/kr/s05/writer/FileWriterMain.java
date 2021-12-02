package kr.s05.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// 덮어쓰기
			fw = new FileWriter("fileWriter.txt");
			// 이어쓰기
			// fw = new FileWriter("fileWriter.txt", true);
			String msg = "안녕하세요! FileWriter 테스트입니다.";
			fw.write(msg); // write() 메서드는 char[], 유니코드 값, String 등을 인자로 받아 버퍼에 내용을 출력
			fw.flush(); // 버퍼의 내용을 비우고 파일에 내용을 출력
			System.out.println("파일을 생성하고 파일에 내용을 출력");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fw!=null) try {fw.close();} catch(IOException e) {} // FileWriter의 close() 메서드는 자원을 정리하기 전에 버퍼를 확인해서 남아 있는 데이터가 있으면 flush() 메서드를 호출하여 처리함; 데이터 누락 방지
		}
	}
}