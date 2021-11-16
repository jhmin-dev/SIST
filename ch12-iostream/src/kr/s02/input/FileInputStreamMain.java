package kr.s02.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException; // 파일이 없는 경우 발생하는 예외
import java.io.IOException;

public class FileInputStreamMain {
	public static void main(String[] args) {
		// 초기화
		FileInputStream fis = null;
		int readbyte = 0;
		byte[] readbyte2;
		// 파일로부터 입력받음
		try {
			fis = new FileInputStream("file.txt"); // 상대 경로; file.txt가 프로젝트 밑에 있는 것으로 인식
			/*
			// 파일의 정보를 한 문자씩 읽기; 영문 이외의 문자는 깨짐
			while((readbyte = fis.read())!=-1) { // read() 메서드는 더 이상 읽을 데이터가 없으면 -1을 반환
				System.out.print((char)readbyte); // read() 메서드가 반환한 ASCII 코드를 char로 캐스팅하여 출력
			}
			*/
			// 파일의 정보를 배열로 읽기; 2byte 문자도 깨지지 않음
			readbyte2 = new byte[fis.available()]; // available() 메서드는 파일의 데이터를 바이트 단위로 환산하여 값을 반환하므로, 배열의 길이를 정확하게 지정 가능
			fis.read(readbyte2); // read() 메서드에 byte[]을 인자로 전달하면, 파일로부터 입력받은 데이터를 byte[]에 저장
			System.out.println(new String(readbyte2)); // byte[]을 String으로 변환하여 출력
		}
		catch(FileNotFoundException e) { // FileInputStream 객체 생성시 발생 가능
			e.printStackTrace();
		}
		catch(IOException e) { // read()메서드에서 발생 가능
			e.printStackTrace();
		}
		finally { // 자원 정리
			if(fis!=null) try {fis.close();} catch(IOException e) {}
		}		
	}
}