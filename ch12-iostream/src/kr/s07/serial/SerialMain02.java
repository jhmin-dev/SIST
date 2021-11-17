package kr.s07.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream; // ������ȭ �޼��带 ����ϱ� ���� �ʿ�

public class SerialMain02 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("object.ser");
			ois = new ObjectInputStream(fis);
			
			// ������ȭ ����
			Customer m = (Customer)ois.readObject(); // readObject() �޼���� Object ��ü�� ��ȯ�ϹǷ� �ٿ�ĳ����
			
			System.out.println(m.getName());
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) { // readObject() �޼��� ���� �ǹ������� ó���ؾ� �ϴ� ����
			e.printStackTrace();
		}
		finally {
			if(ois!=null) try {ois.close();} catch(IOException e) {}
			if(fis!=null) try {ois.close();} catch(IOException e) {}
		}
	}
}
