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

	// 메뉴
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("메뉴 : 1. 성적 입력, 2. 성적 출력, 3. 파일 생성, 4. 파일 읽기, 5. 종료");
			System.out.print("메뉴 > ");
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
					System.out.println("프로그램 종료");
					break;
				}
				else {
					System.out.println("잘못 입력했습니다.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능!");
			}
		}
	}
	// 성적 입력
	public void input() throws IOException {
		Score s = new Score();
		System.out.print("이름 > ");
		s.setName(br.readLine());
		s.setKorean(parseInputData("국어 > "));
		s.setEnglish(parseInputData("영어 > "));
		s.setMath(parseInputData("수학 > "));
		list.add(s); // Score 객체를 ArrayList에 저장
	}
	// 성적 범위 체크(0~100)
	public int parseInputData(String course) throws IOException {
		while(true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				if(num < 0 || num > 100) {
					throw new ScoreValueException("0~100 사이의 값만 인정");
				}
				return num;
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
			catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 성적 출력
	public void output() {
		if(list.size()>0) {
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
			for(Score s : list) {
				System.out.print(s); // 재정의된 toString() 메서드가 %n 포함하고 있으므로 print() 메서드 사용
			}
		}
		else {
			System.out.println("출력할 성적이 없습니다.");
		}
	}
	// 파일 생성
	public void createFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("score.txt");
			fw.write("이룸\t국어\t영어\t수학\t총점\t평균\t등급\n");
			for(Score s : list) {
				fw.write(s.toString()); // s만 명시하면 Score 자료형으로 인식해서 컴파일 에러
			}
			fw.flush();
			System.out.println("파일이 생성되었습니다.");
		}
		catch(IOException e) {
			System.out.println("파일 생성 오류");
		}
		finally {
			if(fw!=null) try {fw.close();} catch(IOException e) {}
		}
	}
	// 파일 읽기
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
			System.out.println("생성된 파일이 없습니다.");
		}
		catch(IOException e) {
			System.out.println("파일 읽기 오류");
		}
		finally {
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 메뉴 : 1. 성적 입력, 2. 성적 출력, 3. 파일 생성, 4. 파일 읽기, 5. 종료
		 * 파일 생성에는 FileOutputStream, FileWriter 중 하나를 이용
		 * 파일 읽기에는 FileInputStream, FileReader 중 하나를 이용
		 */
		new ScoreMain();
	}
}