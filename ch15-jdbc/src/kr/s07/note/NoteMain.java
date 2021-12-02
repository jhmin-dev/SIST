package kr.s07.note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NoteMain {
	private BufferedReader br;
	private NoteDAO note; // callMenu() �޼��忡�� ����ϱ� ������ ��� ������ ����
	
	public NoteMain() {
		note = new NoteDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
	
	// �޴�
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("�޴� : 1. �� ����, 2. ��� ����, 3. �� �� ����, 4. �� ����, 5. �� ����, 6.����");
			System.out.print("�޴� > ");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num==1) { // �� ����
					System.out.print("�̸� > ");
					String name = br.readLine();
					System.out.print("��й�ȣ > ");
					String passwd = br.readLine();
					System.out.print("���� > ");
					String subject = br.readLine();
					System.out.print("���� > ");
					String content = br.readLine();
					System.out.print("�̸��� > ");
					String email = br.readLine();
					
					// NoteDAO�� insertInfo() �޼��带 ȣ���ؼ� �����͸� ����
					note.insertInfo(name, passwd, subject, content, email);
				}
				else if(num==2) { // ��� ����
					note.selectListInfo();
				}
				else if(num==3) { // �� �� ����
					note.selectListInfo(); // �� ��ȣ Ȯ�ο� ��� ����
					System.out.println("�� ������ Ȯ���Ϸ��� �� ��ȣ�� �Է��ϼ���!");
					System.out.print("�� ��ȣ > ");
					num = Integer.parseInt(br.readLine());
					note.selectDetailInfo(num);
				}
				else if(num==4) { // �� ����
					note.selectListInfo(); // �� ��ȣ Ȯ�ο� ��� ����
					System.out.println("�����Ϸ��� �� ��ȣ�� �Է��ϼ���!");
					System.out.print("�� ��ȣ > ");
					num = Integer.parseInt(br.readLine());
					if(note.selectDetailInfo(num)==-1) continue; // ���� �� ��ȣ�� �Է����� ��, �� �̻� �Է¹��� �ʵ��� ó��
					System.out.println("������ ������ �Է��ϼ���!");
					System.out.print("�̸� > ");
					String name = br.readLine();
					System.out.print("��й�ȣ > ");
					String passwd = br.readLine();
					System.out.print("���� > ");
					String subject = br.readLine();
					System.out.print("���� > ");
					String content = br.readLine();
					System.out.print("�̸��� > ");
					String email = br.readLine();
					note.updateInfo(num, name, passwd, subject, content, email);
				}
				else if(num==5) { // �� ����
					note.selectListInfo(); // �� ��ȣ Ȯ�ο� ��� ����
					System.out.println("�����Ϸ��� �� ��ȣ�� �Է��ϼ���!");
					System.out.print("�� ��ȣ > ");
					num = Integer.parseInt(br.readLine());
					note.deleteInfo(num);
				}
				else if(num==6) { // ����
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
				else {
					System.out.println("�߸� �Է��߽��ϴ�!");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է� �����մϴ�!");
			}
		}
	}
	
	public static void main(String[] args) {
		new NoteMain();
	}
}