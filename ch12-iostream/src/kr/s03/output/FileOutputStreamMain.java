package kr.s03.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("fileout.txt"); // 상대 경로; file.txt가 프로젝트 밑에 있는 것으로 인식
			// fos = new FileOutputStream("fileout.txt", true); // FileOutputStream의 기본값은 덮어쓰기 모드이며, 생성자에 두 번째 인자로 true 전달시 이어쓰기 모드
			String message = "Hello File! 파일에 내용을 출력합니다.";
			fos.write(message.getBytes()); // getByes() 메서드로 String을 byte[]로 변환 후 write() 메서드에 전달
			System.out.println("파일을 생성하고 내용을 파일에 출력합니다.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}