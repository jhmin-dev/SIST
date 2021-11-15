package kr.s01.file;

import java.io.File;

public class FileMain01 {
	public static void main(String[] args) {
		String path = "C:\\"; // ���丮 ��� �غ�
		File f = new File(path); // �غ��� path�� ������ File ��ü ����
		if(!f.exists() || !f.isDirectory()) { // ���ڷ� ���޵� path�� �ý��ۿ� �����ϴ���, �׸��� ���丮������ Ȯ��
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0); // ���α׷� ����
		}
		
		// ������ ���丮�� ���� ���丮 �� ���� ���� �б�
		File[] files = f.listFiles(); // listFiles() �޼��带 ���� ���� ���丮 �� ���� ������ File �迭�� ��ȯ
		for(int i=0;i<files.length;i++) {
			File f2 = files[i]; // File �迭�κ��� File ��ü ��ȯ
			if(f2.isDirectory()) { // f2�� ���丮�� ���
				System.out.println("[" + f2.getName() + "]"); // getName() �޼���� ���丮�� ���
			}
			else { // f2�� ������ ���
				System.out.print(f2.getName()); // getName() �޼���� ���ϸ� ���
				System.out.printf(" (%,d bytes)\n", f2.length()); // length() �޼���� ���� ũ�� ���
			}
		}
	}
}