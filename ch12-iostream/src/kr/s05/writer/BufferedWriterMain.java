package kr.s05.writer;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class BufferedWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("bufferedWriter.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter 테스트입니다."); // 버퍼에 내용을 출력
			bw.newLine(); // OS 환경에 맞는 줄바꿈
			bw.write("안녕하세요"+System.getProperty("line.separator")+"line test!"); // OS 환경에 맞는 줄바꿈
			bw.flush(); // 버퍼의 내용을 비우고 파일에 내용을 출력
			System.out.println("파일을 생성하고 내용을 출력");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(bw!=null) try {bw.close();} catch(IOException e) {}
			if(fw!=null) try {fw.close();} catch(IOException e) {}
		}
	}
}