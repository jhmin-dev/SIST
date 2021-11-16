package kr.s01.file;

import java.io.File;

public class FileMain05 {
	public static void main(String[] args) {
		// 현재 파일명
		String path = "example.txt";
		// 현재 파일 객체 생성
		File f = new File(path);		
		// delete() 메서드는 파일을 삭제할 수 있으면 삭제 후 true를 반환하며, 그렇지 않으면 false를 반환
		if(f.delete()) {
			System.out.println(f.getName() + " 파일 삭제");
		}
		else {
			System.out.println("파일을 삭제할 수 없습니다.");
		}
	}
}