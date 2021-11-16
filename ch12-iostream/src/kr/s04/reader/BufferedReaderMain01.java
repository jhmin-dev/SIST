package kr.s04.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // InputStreamReader�� System.in���� ���� ����Ʈ ��Ʈ���� ���� ��Ʈ������ ��ȯ�Ͽ� BufferedReader�� ����
			System.out.print("����� �̸� > ");
			String name = br.readLine();
			System.out.println(name);
			System.out.print("����� ���� > ");
			int age = Integer.parseInt(br.readLine()); // String�� int�� ��ȯ
			System.out.println(age);
		}
		catch(NumberFormatException e) { // parseInt() �޼��� ���� ����
			e.printStackTrace();
		}
		catch(IOException e) { // readLine() �޼��� ���� �ǹ�
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}