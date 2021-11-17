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
		 * [실습]
		 * 메뉴 : 1. 성적 입력, 2. 성적 출력, 3. 파일 생성, 4. 파일 읽기, 5. 종료
		 * 파일 생성에는 FileOutputStream, FileWriter 중 하나를 이용
		 * 파일 읽기에는 FileInputStream, FileReader 중 하나를 이용
		 */
		new ScoreMain();
	}
	// 멤버 변수
	ArrayList<Score> al;
	BufferedReader br;
	FileReader fr;
	FileWriter fw;
	String filename="Score.txt";
	// 생성자
	public ScoreMain() {
		menu();
	}
	// 메뉴 메서드
	public void menu() {
		al = new ArrayList<Score>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("메뉴 : 1. 성적 입력, 2. 성적 출력, 3. 파일 생성, 4. 파일 읽기, 5. 종료");
				System.out.print("메뉴 > ");
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
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					System.out.println("메뉴 번호 를 잘못 입력하셨습니다.");
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
	// 성적 입력
	public void setScore() throws IOException {
		Score s = new Score();
		System.out.printf("이름 > ");
		s.setName(br.readLine());
		s.setKorean(parseInputScore("국어 > "));
		s.setEnglish(parseInputScore("영어 > "));
		s.setMath(parseInputScore("수학 > "));
		al.add(s);
	}
	// 성적 출력
	public void getScore() {
		if(al.size()==0) {
			System.out.println("비어 있습니다.");
			return;
		}
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		for(Score s : al) {
			System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%6.2f\t%s", s.getName(), s.getKorean(), s.getEnglish(), s.getMath(), s.makeSum(), s.makeAvg(), s.makeGrade());
			System.out.print(System.getProperty("line.separator"));
		}
	}
	// 파일 생성
	public void mkFile() throws IOException {
		boolean append=false;
		if(new File(filename).exists()) {
			System.out.println("이전에 작성한 파일이 존재합니다. 덮어쓰시겠습니까? [y/n]");
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
					System.out.println("y: 덮어쓰기, n: 이어쓰기");
				}
			}
		}
		fw = new FileWriter(filename, append);
		if(!append) {
			fw.write("이름\t국어\t영어\t수학\t총점\t평균\t등급");
			fw.write(System.getProperty("line.separator"));
		}
		for(Score s : al) {
			fw.write(s.getName()+"\t"+s.getKorean()+"\t"+s.getEnglish()+"\t"+s.getMath()+"\t"+s.makeSum()+"\t"+s.makeAvg()+"\t"+s.makeGrade());
			fw.write(System.getProperty("line.separator"));
		}
		fw.flush();
	}
	// 파일 읽기
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
			System.out.println("파일이 없습니다.");
		}
	}
	// 입력값 제한
	public int parseInputScore(String title) throws IOException {
		while(true) {
			System.out.print(title);
			try {
				int s = Integer.parseInt(br.readLine());
				if(s>=0&s<=100) {
					return s;
				}
				throw new ScoreValueException("성적은 0~100 사이의 값만 입력 가능합니다.");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}