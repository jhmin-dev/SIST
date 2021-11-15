package kr.s01.file;

import java.io.File;
import java.io.IOException; // 파일 생성시 발생 가능

public class FileMain03 {
	public static void main(String[] args) {
		// 절대 경로
		// String path = "C:\\javaWork2\\sample.txt"; // IOException 발생
		// String path = "C:\\javaWork\\sample.txt";
		
		// 상대 경로
		String path = "sample.txt"; // 프로젝트 내에서 파일을 찾음
		
		File f1 = new File(path);
		System.out.println("파일 생성");
		try {
			System.out.println(f1.createNewFile()); // createNewFile() 메서드는 try~catch하지 않으면 컴파일 에러; 제공된 경로를 기반으로 파일을 생성하며, 생성되면 true를 반환하고 그렇지 않으면 false를 반환; 경로가 잘못되면 IOException 발생
		}
		catch(IOException e) {
			e.printStackTrace(); // 예외 문구 출력
		}
		
		System.out.println("파일 정보");
		System.out.println("절대 경로 : " + f1.getAbsolutePath());
		System.out.println("상대 경로 : " + f1.getPath()); // 제공된 정보를 통해 구하기 때문에, 절대 경로만 제공했을 경우 getPath() 메서드는 절대 경로를 반환
		System.out.println("디렉토리명 : " + f1.getParent()); // 제공된 정보를 통해 구하기 때문에, 디렉토리를 포함하지 않은 상대 경로만 제공했을 경우 getParent() 메서드는 null을 반환
		System.out.println("파일명 : " + f1.getName());
	}
}