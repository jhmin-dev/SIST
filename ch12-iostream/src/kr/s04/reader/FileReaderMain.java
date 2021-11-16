package kr.s04.reader;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		int readChar;
		try {
			// 문자 입력 스트림
			fr = new FileReader("file.txt");
			// 파일로부터 데이터를 한 문자씩 읽기; 한글 등 영문 이외의 문자라도 유니코드로 반환되므로 깨지지 않음
			while((readChar = fr.read())!=-1) { // read() 메서드는 더 이상 읽을 데이터가 없으면 -1을 반환
				System.out.print((char)readChar); // read() 메서드가 반환한 유니코드를 char로 캐스팅하여 출력
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}
}