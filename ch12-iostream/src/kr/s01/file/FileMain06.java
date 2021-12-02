package kr.s01.file;

import java.io.File;

public class FileMain06 {
	public static void main(String[] args) {
		File f1 = new File("C:\\javaWork\\javaSample");
		// mkdir() 메서드는 디렉토리를 생성할 수 있으면 생성 후 true를 반환하고, 그렇지 않으면 false를 반환
		System.out.println("디렉토리 생성 : " + f1.mkdir());
		// delete() 메서드로 디렉토리를 삭제
		if(f1.delete()) {
			System.out.println(f1.getName() + " 디렉토리가 삭제되었습니다!");
		}
		else {
			System.out.println("디렉토리를 삭제할 수 없습니다.");
		}
	}
}