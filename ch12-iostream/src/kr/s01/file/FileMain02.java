package kr.s01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMain02 {
	public static void main(String[] args) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String path = "C:\\";
		File f = new File(path);
		
		// 지정한 경로의 하위 디렉토리 및 파일 정보를 File[]로 변환
		File[] files = f.listFiles();
		
		String attribute = ""; // 읽기 전용, 숨김 파일 등의 정보를 저장할 변수 초기화
		String size = "";
		String name = "";
		
		for(int i=0;i<files.length;i++) {
			File f2 = files[i]; // File 배열로부터 File 객체를 반환
			name = f2.getName();
			if(f2.isDirectory()) { // f2가 디렉토리인 경우
				size = "0";
				attribute = "DIR";	
			}
			else { // f2가 파일인 경우
				size = f2.length() + ""; // long형으로 반환된 파일 크기에 빈 문자열을 연결해 문자열로 변환 
				attribute = f2.canRead() ? "R" : " "; // 읽기 가능하면 attribute에 R 추가
				attribute += f2.canWrite() ? "W" : " "; // 쓰기 가능하면 attribute에 W 추가
				attribute += f2.isHidden() ? "H" : " "; // 숨김 파일이면 attribute에 H 추가
			}
			// System.out.println(f2.lastModified()); // lastModified() 메서드는 파일의 마지막 수정 날짜를 1970-01-01 00:00:00 이후 지나간 밀리세컨드로 환산하여 long형으로 반환
			System.out.printf("%s %3s %6s %s\n", sf.format(new Date(f2.lastModified())), attribute, size, name);
		}	
	}
}