package kr.s01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMain02 {
	public static void main(String[] args) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String path = "C:\\";
		File f = new File(path);
		
		// ������ ����� ���� ���丮 �� ���� ������ File[]�� ��ȯ
		File[] files = f.listFiles();
		
		String attribute = ""; // �б� ����, ���� ���� ���� ������ ������ ���� �ʱ�ȭ
		String size = "";
		String name = "";
		
		for(int i=0;i<files.length;i++) {
			File f2 = files[i]; // File �迭�κ��� File ��ü�� ��ȯ
			name = f2.getName();
			if(f2.isDirectory()) { // f2�� ���丮�� ���
				size = "0";
				attribute = "DIR";	
			}
			else { // f2�� ������ ���
				size = f2.length() + ""; // long������ ��ȯ�� ���� ũ�⿡ �� ���ڿ��� ������ ���ڿ��� ��ȯ 
				attribute = f2.canRead() ? "R" : " "; // �б� �����ϸ� attribute�� R �߰�
				attribute += f2.canWrite() ? "W" : " "; // ���� �����ϸ� attribute�� W �߰�
				attribute += f2.isHidden() ? "H" : " "; // ���� �����̸� attribute�� H �߰�
			}
			// System.out.println(f2.lastModified()); // lastModified() �޼���� ������ ������ ���� ��¥�� 1970-01-01 00:00:00 ���� ������ �и�������� ȯ���Ͽ� long������ ��ȯ
			System.out.printf("%s %3s %6s %s\n", sf.format(new Date(f2.lastModified())), attribute, size, name);
		}	
	}
}