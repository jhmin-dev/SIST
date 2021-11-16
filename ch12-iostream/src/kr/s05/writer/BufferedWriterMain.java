package kr.s05.writer;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class BufferedWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("bufferedWriter.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter �׽�Ʈ�Դϴ�."); // ���ۿ� ������ ���
			bw.newLine(); // OS ȯ�濡 �´� �ٹٲ�
			bw.write("�ȳ��ϼ���"+System.getProperty("line.separator")+"line test!"); // OS ȯ�濡 �´� �ٹٲ�
			bw.flush(); // ������ ������ ���� ���Ͽ� ������ ���
			System.out.println("������ �����ϰ� ������ ���");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(bw!=null) try {bw.close();} catch(IOException e) {}
			if(fw!=null) try {fw.close();} catch(IOException e) {}
		}
	}
}