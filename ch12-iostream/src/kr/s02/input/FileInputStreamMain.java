package kr.s02.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException; // ������ ���� ��� �߻��ϴ� ����
import java.io.IOException;

public class FileInputStreamMain {
	public static void main(String[] args) {
		// �ʱ�ȭ
		FileInputStream fis = null;
		int readbyte = 0;
		byte[] readbyte2;
		// ���Ϸκ��� �Է¹���
		try {
			fis = new FileInputStream("file.txt"); // ��� ���; file.txt�� ������Ʈ �ؿ� �ִ� ������ �ν�
			/*
			// ������ ������ �� ���ھ� �б�; ���� �̿��� ���ڴ� ����
			while((readbyte = fis.read())!=-1) { // read() �޼���� �� �̻� ���� �����Ͱ� ������ -1�� ��ȯ
				System.out.print((char)readbyte); // read() �޼��尡 ��ȯ�� ASCII �ڵ带 char�� ĳ�����Ͽ� ���
			}
			*/
			// ������ ������ �迭�� �б�; 2byte ���ڵ� ������ ����
			readbyte2 = new byte[fis.available()]; // available() �޼���� ������ �����͸� ����Ʈ ������ ȯ���Ͽ� ���� ��ȯ�ϹǷ�, �迭�� ���̸� ��Ȯ�ϰ� ���� ����
			fis.read(readbyte2); // read() �޼��忡 byte[]�� ���ڷ� �����ϸ�, ���Ϸκ��� �Է¹��� �����͸� byte[]�� ����
			System.out.println(new String(readbyte2)); // byte[]�� String���� ��ȯ�Ͽ� ���
		}
		catch(FileNotFoundException e) { // FileInputStream ��ü ������ �߻� ����
			e.printStackTrace();
		}
		catch(IOException e) { // read()�޼��忡�� �߻� ����
			e.printStackTrace();
		}
		finally { // �ڿ� ����
			if(fis!=null) try {fis.close();} catch(IOException e) {}
		}		
	}
}