package kr.s03.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamMain {
	public static void main(String[] args) {
		// ��Ʈ�� ��ü ����; ��Ʈ�� ��ü �����ÿ� ���ܰ� �߻��� �� �ֱ� ������ ����� ������ �и�; ������ try�� �����ϸ� finally���� �ڿ��� ������ �� ����
		FileOutputStream fos = null;
		BufferedOutputStream bo = null;
		// ��Ʈ�� ��ü ����
		try {
			fos = new FileOutputStream("bufferOut.txt"); // bufferOut.txt ����
			bo = new BufferedOutputStream(fos);
			String str = "BufferedOutputStream Test �Դϴ�.";
			bo.write(str.getBytes()); // str�� ������ ���ۿ� ���; ���Ͽ��� ���� ����
			bo.flush(); // ���۸� ���� ���ۿ� �ִ� �����͸� ���Ͽ� ���
			System.out.println("������ �����ϰ� ���Ͽ� ������ ����մϴ�.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// �ڿ� ����; ��Ʈ�� ��ü ���� �������� �ؾ� ����; �� ���������� bo�� fos�� �ڿ��� ����ϹǷ�, bo �ݱ� ���� fos ������ ���� ���� �� ����
		finally {
			 if(bo!=null) try {bo.close();} catch(IOException e) {} // BufferedOutputStream�� close() �޼���� �ڿ��� �����ϱ� ���� ���۸� Ȯ���ؼ� ���� �ִ� �����Ͱ� ������ flush() �޼��带 ȣ���Ͽ� ó����; ������ ���� ����
			 if(fos!=null) try {fos.close();} catch(IOException e) {}
		}
	}
}