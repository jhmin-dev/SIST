package kr.s01.file;

import java.io.File;

public class FileMain05 {
	public static void main(String[] args) {
		// ���� ���ϸ�
		String path = "example.txt";
		// ���� ���� ��ü ����
		File f = new File(path);		
		// delete() �޼���� ������ ������ �� ������ ���� �� true�� ��ȯ�ϸ�, �׷��� ������ false�� ��ȯ
		if(f.delete()) {
			System.out.println(f.getName() + " ���� ����");
		}
		else {
			System.out.println("������ ������ �� �����ϴ�.");
		}
	}
}