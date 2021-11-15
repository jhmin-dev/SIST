package kr.s01.file;

import java.io.File;

public class FileMain01 {
	public static void main(String[] args) {
		String path = "C:\\"; // 디렉토리 경로 준비
		File f = new File(path); // 준비한 path를 전달해 File 객체 생성
		if(!f.exists() || !f.isDirectory()) { // 인자로 전달된 path가 시스템에 존재하는지, 그리고 디렉토리인지를 확인
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0); // 프로그램 종료
		}
		
		// 지정한 디렉토리의 하위 디렉토리 및 파일 정보 읽기
		File[] files = f.listFiles(); // listFiles() 메서드를 통해 하위 디렉토리 및 파일 정보를 File 배열로 반환
		for(int i=0;i<files.length;i++) {
			File f2 = files[i]; // File 배열로부터 File 객체 반환
			if(f2.isDirectory()) { // f2가 디렉토리인 경우
				System.out.println("[" + f2.getName() + "]"); // getName() 메서드로 디렉토리명 출력
			}
			else { // f2가 파일인 경우
				System.out.print(f2.getName()); // getName() 메서드로 파일명 출력
				System.out.printf(" (%,d bytes)\n", f2.length()); // length() 메서드로 파일 크기 출력
			}
		}
	}
}