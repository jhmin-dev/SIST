package kr.s06.score;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMain {
	BufferedReader br;
	ArrayList<Score> list;

	public ScoreMain() {
		list = new ArrayList<Score>();
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
			System.out.println("�޴� : 1. ���� �Է�, 2. ���� ���, 3. ���� ����, 4. ���� �б�, 5. ����");
			System.out.print("�޴� > ");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {
					input();
				}
				else if(num == 2) {
					output();
				}
				else if(num == 3) {
					createFile();
				}
				else if(num == 4) {
					readFile();
				}
				else if(num == 5) {
					System.out.println("���α׷� ����");
					break;
				}
				else {
					System.out.println("�߸� �Է��߽��ϴ�.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է� ����!");
			}
		}
	}
	// ���� �Է�
	public void input() throws IOException {
		Score s = new Score();
		System.out.print("�̸� > ");
		s.setName(br.readLine());
		s.setKorean(parseInputData("���� > "));
		s.setEnglish(parseInputData("���� > "));
		s.setMath(parseInputData("���� > "));
		list.add(s); // Score ��ü�� ArrayList�� ����
	}
	// ���� ���� üũ(0~100)
	public int parseInputData(String course) throws IOException {
		while(true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				if(num < 0 || num > 100) {
					throw new ScoreValueException("0~100 ������ ���� ����");
				}
				return num;
			}
			catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
			}
			catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// ���� ���
	public void output() {
		if(list.size()>0) {
			System.out.println("�̸�\t����\t����\t����\t����\t���\t���");
			for(Score s : list) {
				System.out.print(s); // �����ǵ� toString() �޼��尡 %n �����ϰ� �����Ƿ� print() �޼��� ���
			}
		}
		else {
			System.out.println("����� ������ �����ϴ�.");
		}
	}
	// ���� ����
	public void createFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("score.txt");
			fw.write("�̷�\t����\t����\t����\t����\t���\t���\n");
			for(Score s : list) {
				fw.write(s.toString()); // s�� ����ϸ� Score �ڷ������� �ν��ؼ� ������ ����
			}
			fw.flush();
			System.out.println("������ �����Ǿ����ϴ�.");
		}
		catch(IOException e) {
			System.out.println("���� ���� ����");
		}
		finally {
			if(fw!=null) try {fw.close();} catch(IOException e) {}
		}
	}
	// ���� �б�
	public void readFile() {
		FileReader fr= null;
		int readChar;
		try {
			fr = new FileReader("score.txt");
			while((readChar = fr.read())!=-1) {
				System.out.print((char)readChar);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("������ ������ �����ϴ�.");
		}
		catch(IOException e) {
			System.out.println("���� �б� ����");
		}
		finally {
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * �޴� : 1. ���� �Է�, 2. ���� ���, 3. ���� ����, 4. ���� �б�, 5. ����
		 * ���� �������� FileOutputStream, FileWriter �� �ϳ��� �̿�
		 * ���� �б⿡�� FileInputStream, FileReader �� �ϳ��� �̿�
		 */
		new ScoreMain();
	}
}