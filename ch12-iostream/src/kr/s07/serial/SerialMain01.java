package kr.s07.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream; // ����ȭ �޼��带 ����ϱ� ���� �ʿ�

public class SerialMain01 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		// ����ȭ�� ��ü ����
		Customer c = new Customer("�ʱ�");
		
		try {
			fos = new FileOutputStream("object.ser");
			oos = new ObjectOutputStream(fos);
			
			// ��ü ����ȭ ����
			oos.writeObject(c); // c�� Ŭ������ Serializable�� implements�ϰ� ���� ������ ����� NotSerializableException ���� �߻�
			
			System.out.println("��ü ����ȭ�� �Ϸ�Ǿ����ϴ�.");
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
