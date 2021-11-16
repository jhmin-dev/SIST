package kr.s03.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamMain {
	public static void main(String[] args) {
		// 스트림 객체 선언; 스트림 객체 생성시에 예외가 발생할 수 있기 때문에 선언과 생성을 분리; 선언을 try에 포함하면 finally에서 자원을 정리할 수 없음
		FileOutputStream fos = null;
		BufferedOutputStream bo = null;
		// 스트림 객체 생성
		try {
			fos = new FileOutputStream("bufferOut.txt"); // bufferOut.txt 생성
			bo = new BufferedOutputStream(fos);
			String str = "BufferedOutputStream Test 입니다.";
			bo.write(str.getBytes()); // str의 내용을 버퍼에 출력; 파일에는 내용 없음
			bo.flush(); // 버퍼를 비우고 버퍼에 있는 데이터를 파일에 출력
			System.out.println("파일을 생성하고 파일에 내용을 출력합니다.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// 자원 정리; 스트림 객체 생성 역순으로 해야 안전; 이 예제에서는 bo가 fos의 자원을 사용하므로, bo 닫기 전에 fos 닫으면 문제 생길 수 있음
		finally {
			 if(bo!=null) try {bo.close();} catch(IOException e) {} // BufferedOutputStream의 close() 메서드는 자원을 정리하기 전에 버퍼를 확인해서 남아 있는 데이터가 있으면 flush() 메서드를 호출하여 처리함; 데이터 누락 방지
			 if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}