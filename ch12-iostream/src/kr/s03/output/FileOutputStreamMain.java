package kr.s03.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("fileout.txt"); // ��� ���; file.txt�� ������Ʈ �ؿ� �ִ� ������ �ν�
			// fos = new FileOutputStream("fileout.txt", true); // FileOutputStream�� �⺻���� ����� ����̸�, �����ڿ� �� ��° ���ڷ� true ���޽� �̾�� ���
			String message = "Hello File! ���Ͽ� ������ ����մϴ�.";
			fos.write(message.getBytes()); // getByes() �޼���� String�� byte[]�� ��ȯ �� write() �޼��忡 ����
			System.out.println("������ �����ϰ� ������ ���Ͽ� ����մϴ�.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}