package kr.s01.file;

import java.io.File;

public class FileMain06 {
	public static void main(String[] args) {
		File f1 = new File("C:\\javaWork\\javaSample");
		// mkdir() �޼���� ���丮�� ������ �� ������ ���� �� true�� ��ȯ�ϰ�, �׷��� ������ false�� ��ȯ
		System.out.println("���丮 ���� : " + f1.mkdir());
		// delete() �޼���� ���丮�� ����
		if(f1.delete()) {
			System.out.println(f1.getName() + " ���丮�� �����Ǿ����ϴ�!");
		}
		else {
			System.out.println("���丮�� ������ �� �����ϴ�.");
		}
	}
}