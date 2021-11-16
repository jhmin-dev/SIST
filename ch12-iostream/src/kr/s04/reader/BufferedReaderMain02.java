package kr.s04.reader;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderMain02 {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("file.txt");
			br = new BufferedReader(fr); // FileReader�� ���Ͽ� �����ؼ� ���� ������ BufferedReader�� ����; ��뷮 �����͸� �ٷ�� ��� FileReader �ܵ� ��뺸�� ���� ������ Ȱ���ϴ� BufferedReader ���� ����� �ӵ����� ����
			String msg;
			while((msg = br.readLine())!=null) { // readLine() �޼���� �� �̻� ���� �����Ͱ� ������ null�� ��ȯ
				System.out.println(msg); // readLine() �޼��尡 �о�� �� ���� ���
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}
}