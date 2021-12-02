package kr.s01.file;

import java.io.File;

public class FileMain04 {
	public static void main(String[] args) {
		// 현재 파일명
		String path = "sample.txt";
		// 새 파일명
		String path2 = "example.txt";
		// 현재 파일 객체 생성
		File f1 = new File(path);
		// 새 파일 객체 생성
		File f2 = new File(path2);
		// 새 파일명 정보를 가진 File 객체를 renameTo() 메서드의 인자로 전달하여 파일명 변경; 파일명 변경 작업에 성공하면 true, 그렇지 않으면 false 반환
		System.out.println("파일명 변경 : " + f1.renameTo(f2));
	}
}