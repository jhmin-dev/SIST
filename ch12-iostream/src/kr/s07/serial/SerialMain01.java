package kr.s07.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream; // 직렬화 메서드를 사용하기 위해 필요

public class SerialMain01 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		// 직렬화할 객체 생성
		Customer c = new Customer("너굴");
		
		try {
			fos = new FileOutputStream("object.ser");
			oos = new ObjectOutputStream(fos);
			
			// 객체 직렬화 수행
			oos.writeObject(c); // c의 클래스가 Serializable을 implements하고 있지 않으면 실행시 NotSerializableException 에러 발생
			
			System.out.println("객체 직렬화가 완료되었습니다.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(oos!=null) try {oos.close();} catch(IOException e) {}
			if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}
