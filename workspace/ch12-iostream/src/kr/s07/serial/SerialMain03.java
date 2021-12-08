package kr.s07.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList; // ArrayList 클래스는 Serializable을 구현하고 있으므로 직렬화 가능

public class SerialMain03 {
	public static void main(String[] args) {
		// 참조 변수 선언
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		// 직렬화할 객체 생성
		UserInfo u1 = new UserInfo("너굴", 20, "서울시");
		UserInfo u2 = new UserInfo("콩돌", 18, "부산시");

		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		list.add(u1);
		list.add(u2);
		
		try {
			// 객체 생성하여 참조 변수에 할당
			fos = new FileOutputStream("userInfo.ser");
			oos = new ObjectOutputStream(fos);
			
			// 객체 직렬화 수행
			oos.writeObject(list);
			
			System.out.println("객체 직렬화가 성공적으로 완료되었습니다.");
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
