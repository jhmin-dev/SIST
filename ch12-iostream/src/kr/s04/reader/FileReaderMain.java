package kr.s04.reader;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		int readChar;
		try {
			// ���� �Է� ��Ʈ��
			fr = new FileReader("file.txt");
			// ���Ϸκ��� �����͸� �� ���ھ� �б�; �ѱ� �� ���� �̿��� ���ڶ� �����ڵ�� ��ȯ�ǹǷ� ������ ����
			while((readChar = fr.read())!=-1) { // read() �޼���� �� �̻� ���� �����Ͱ� ������ -1�� ��ȯ
				System.out.print((char)readChar); // read() �޼��尡 ��ȯ�� �����ڵ带 char�� ĳ�����Ͽ� ���
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}
}