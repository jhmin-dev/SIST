package kr.s01.file;

import java.io.File;

public class FileMain04 {
	public static void main(String[] args) {
		// ���� ���ϸ�
		String path = "sample.txt";
		// �� ���ϸ�
		String path2 = "example.txt";
		// ���� ���� ��ü ����
		File f1 = new File(path);
		// �� ���� ��ü ����
		File f2 = new File(path2);
		// �� ���ϸ� ������ ���� File ��ü�� renameTo() �޼����� ���ڷ� �����Ͽ� ���ϸ� ����; ���ϸ� ���� �۾��� �����ϸ� true, �׷��� ������ false ��ȯ
		System.out.println("���ϸ� ���� : " + f1.renameTo(f2));
	}
}