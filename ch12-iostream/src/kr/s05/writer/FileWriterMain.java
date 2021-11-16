package kr.s05.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// �����
			fw = new FileWriter("fileWriter.txt");
			// �̾��
			// fw = new FileWriter("fileWriter.txt", true);
			String msg = "�ȳ��ϼ���! FileWriter �׽�Ʈ�Դϴ�.";
			fw.write(msg); // write() �޼���� char[], �����ڵ� ��, String ���� ���ڷ� �޾� ���ۿ� ������ ���
			fw.flush(); // ������ ������ ���� ���Ͽ� ������ ���
			System.out.println("������ �����ϰ� ���Ͽ� ������ ���");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fw!=null) try {fw.close();} catch(IOException e) {} // FileWriter�� close() �޼���� �ڿ��� �����ϱ� ���� ���۸� Ȯ���ؼ� ���� �ִ� �����Ͱ� ������ flush() �޼��带 ȣ���Ͽ� ó����; ������ ���� ����
		}
	}
}