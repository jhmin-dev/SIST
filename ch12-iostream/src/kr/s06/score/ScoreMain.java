package kr.s06.score;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.File;

public class ScoreMain {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * �޴� : 1. ���� �Է�, 2. ���� ���, 3. ���� ����, 4. ���� �б�, 5. ����
		 * ���� �������� FileOutputStream, FileWriter �� �ϳ��� �̿�
		 * ���� �б⿡�� FileInputStream, FileReader �� �ϳ��� �̿�
		 */
		new ScoreMain();
	}
	// ��� ����
	ArrayList<Score> al;
	BufferedReader br;
	FileReader fr;
	FileWriter fw;
	String filename="Score.txt";
	// ������
	public ScoreMain() {
		menu();
	}
	// �޴� �޼���
	public void menu() {
		al = new ArrayList<Score>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("�޴� : 1. ���� �Է�, 2. ���� ���, 3. ���� ����, 4. ���� �б�, 5. ����");
				System.out.print("�޴� > ");
				String menu = br.readLine();
				if(menu.equals("1")) {
					setScore();
				}
				else if(menu.equals("2")) {
					getScore();
				}
				else if(menu.equals("3")) {
					mkFile();
				}
				else if(menu.equals("4")) {
					readFile();
				}
				else if(menu.equals("5")) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
				else {
					System.out.println("�޴� ��ȣ �� �߸� �Է��ϼ̽��ϴ�.");
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
			if(fr!=null) try {fr.close();} catch(IOException e) {}
			if(fw!=null) try {fw.close();} catch(IOException e) {}
		}
	}
	// ���� �Է�
	public void setScore() throws IOException {
		Score s = new Score();
		System.out.printf("�̸� > ");
		s.setName(br.readLine());
		s.setKorean(parseInputScore("���� > "));
		s.setEnglish(parseInputScore("���� > "));
		s.setMath(parseInputScore("���� > "));
		al.add(s);
	}
	// ���� ���
	public void getScore() {
		if(al.size()==0) {
			System.out.println("��� �ֽ��ϴ�.");
			return;
		}
		System.out.println("�̸�\t����\t����\t����\t����\t���\t���");
		for(Score s : al) {
			System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%6.2f\t%s", s.getName(), s.getKorean(), s.getEnglish(), s.getMath(), s.makeSum(), s.makeAvg(), s.makeGrade());
			System.out.print(System.getProperty("line.separator"));
		}
	}
	// ���� ����
	public void mkFile() throws IOException {
		boolean append=false;
		if(new File(filename).exists()) {
			System.out.println("������ �ۼ��� ������ �����մϴ�. ����ðڽ��ϱ�? [y/n]");
			while(true) {
				String replace=br.readLine();
				if(replace.equalsIgnoreCase("y")) {
					break;
				}
				else if(replace.equalsIgnoreCase("n")) {
					append=true;
					break;
				}
				else {
					System.out.println("y: �����, n: �̾��");
				}
			}
		}
		fw = new FileWriter(filename, append);
		if(!append) {
			fw.write("�̸�\t����\t����\t����\t����\t���\t���");
			fw.write(System.getProperty("line.separator"));
		}
		for(Score s : al) {
			fw.write(s.getName()+"\t"+s.getKorean()+"\t"+s.getEnglish()+"\t"+s.getMath()+"\t"+s.makeSum()+"\t"+s.makeAvg()+"\t"+s.makeGrade());
			fw.write(System.getProperty("line.separator"));
		}
		fw.flush();
	}
	// ���� �б�
	public void readFile() throws IOException {
		try {
			fr = new FileReader(filename);
			BufferedReader brfr = new BufferedReader(fr);
			String fileline;
			while((fileline=brfr.readLine())!=null) {
				System.out.println(fileline);
			}
			if(brfr!=null) brfr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
		}
	}
	// �Է°� ����
	public int parseInputScore(String title) throws IOException {
		while(true) {
			System.out.print(title);
			try {
				int s = Integer.parseInt(br.readLine());
				if(s>=0&s<=100) {
					return s;
				}
				throw new ScoreValueException("������ 0~100 ������ ���� �Է� �����մϴ�.");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}