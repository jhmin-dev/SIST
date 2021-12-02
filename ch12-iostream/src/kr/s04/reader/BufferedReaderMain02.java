package kr.s04.reader;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderMain02 {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("file.txt");
			br = new BufferedReader(fr); // FileReader가 파일에 접근해서 얻은 정보를 BufferedReader에 전달; 대용량 데이터를 다루는 경우 FileReader 단독 사용보다 버퍼 공간을 활용하는 BufferedReader 연계 사용이 속도에서 유리
			String msg;
			while((msg = br.readLine())!=null) { // readLine() 메서드는 더 이상 읽을 데이터가 없으면 null을 반환
				System.out.println(msg); // readLine() 메서드가 읽어온 한 줄을 출력
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}
}