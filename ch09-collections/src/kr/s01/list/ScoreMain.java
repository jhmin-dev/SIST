package kr.s01.list;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ScoreMain {
	/*
	 * [�ǽ�] �޴� : 1. ���� �Է�, 2. ���� ���, 3. ����
	 * [����] 0~100 ���̷� �Է��ϵ��� ����(int parseInputData(String title))
	 */
	// ��� ����
	ArrayList<Score> al;
	BufferedReader br;
	// ��ü ����
	public static void main(String[] args) {
		new ScoreMain();
	}
	// ������
	public ScoreMain() {
		al = new ArrayList<Score>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			menu();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {};
		}
	}
	// �޴� �޼���
	public void menu() throws IOException {
		while(true) {
			System.out.println("�޴� : 1. ���� �Է�, 2. ���� ���, 3. ����");
			System.out.print("�޴� > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) {
					setScore();
				}
				else if(menu==2) {
					getScore();
				}
				else if(menu==3) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
				else { // 1,2,3 ���� ���� �Է�
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException e) { // ���� �� ���� �Է�
				System.out.println("�޴� ��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	// ���� �Է�
	public void setScore() throws IOException {
		Score s = new Score();
		System.out.print("�̸� > ");
		s.setName(br.readLine());
		s.setKorean(parseInputData("���� > "));
		s.setEnglish(parseInputData("���� > "));
		s.setMath(parseInputData("���� > "));
		al.add(s);
	}
	// ���� ���
	public void getScore() {
		// System.out.println(al); // �Է��� ����� �Ǿ����� Ȯ���ϱ� ���� �����ǵ� toString() �޼��� ȣ��
		System.out.println("�̸�\t����\t����\t����\t����\t���\t���");
		for(Score s : al) {
			System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%6.2f\t%s\n", s.getName(), s.getKorean(), s.getEnglish(), s.getMath(), s.makeSum(), s.makeAvg(), s.makeGrade());
		}
	}
	// �Է°� �˻�
	public int parseInputData(String title) throws IOException {
		while(true) {
			System.out.print(title);	
			try {
				int s=Integer.parseInt(br.readLine());
				if(s<0||s>100) {
					throw new ScoreValueException("������ 0���� 100 ������ ���̾�� �մϴ�."); // �Է°��� ���� �������� ���ܸ� ���� catch ������ �̵�
				}		
				return s; // ���ܰ� �߻����� ���� ��� s�� ��ȯ�Ͽ� �޼��� ����
			}
			catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���.");
			}
		}
	}
}