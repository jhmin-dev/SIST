package kr.s07.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream; // 역직렬화 메서드를 사용하기 위해 필요

public class SerialMain02 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("object.ser");
			ois = new ObjectInputStream(fis);
			
			// 역직렬화 수행
			Customer m = (Customer)ois.readObject(); // readObject() 메서드는 Object 객체를 반환하므로 다운캐스팅
			
			System.out.println(m.getName());
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) { // readObject() 메서드 사용시 의무적으로 처리해야 하는 예외
			e.printStackTrace();
		}
		finally {
			if(ois!=null) try {ois.close();} catch(IOException e) {}
			if(fis!=null) try {ois.close();} catch(IOException e) {}
		}
	}
}
