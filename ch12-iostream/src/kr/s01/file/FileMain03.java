package kr.s01.file;

import java.io.File;
import java.io.IOException; // ���� ������ �߻� ����

public class FileMain03 {
	public static void main(String[] args) {
		// ���� ���
		// String path = "C:\\javaWork2\\sample.txt"; // IOException �߻�
		// String path = "C:\\javaWork\\sample.txt";
		
		// ��� ���
		String path = "sample.txt"; // ������Ʈ ������ ������ ã��
		
		File f1 = new File(path);
		System.out.println("���� ����");
		try {
			System.out.println(f1.createNewFile()); // createNewFile() �޼���� try~catch���� ������ ������ ����; ������ ��θ� ������� ������ �����ϸ�, �����Ǹ� true�� ��ȯ�ϰ� �׷��� ������ false�� ��ȯ; ��ΰ� �߸��Ǹ� IOException �߻�
		}
		catch(IOException e) {
			e.printStackTrace(); // ���� ���� ���
		}
		
		System.out.println("���� ����");
		System.out.println("���� ��� : " + f1.getAbsolutePath());
		System.out.println("��� ��� : " + f1.getPath()); // ������ ������ ���� ���ϱ� ������, ���� ��θ� �������� ��� getPath() �޼���� ���� ��θ� ��ȯ
		System.out.println("���丮�� : " + f1.getParent()); // ������ ������ ���� ���ϱ� ������, ���丮�� �������� ���� ��� ��θ� �������� ��� getParent() �޼���� null�� ��ȯ
		System.out.println("���ϸ� : " + f1.getName());
	}
}