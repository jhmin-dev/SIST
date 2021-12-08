package kr.s01.list;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ScoreMain {
	/*
	 * [실습] 메뉴 : 1. 성적 입력, 2. 성적 출력, 3. 종료
	 * [조건] 0~100 사이로 입력하도록 강제(int parseInputData(String title))
	 */
	// 멤버 변수
	ArrayList<Score> al;
	BufferedReader br;
	// 객체 생성
	public static void main(String[] args) {
		new ScoreMain();
	}
	// 생성자
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
	// 메뉴 메서드
	public void menu() throws IOException {
		while(true) {
			System.out.println("메뉴 : 1. 성적 입력, 2. 성적 출력, 3. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) {
					setScore();
				}
				else if(menu==2) {
					getScore();
				}
				else if(menu==3) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else { // 1,2,3 외의 숫자 입력
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException e) { // 숫자 외 문자 입력
				System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
			}
		}
	}
	// 성적 입력
	public void setScore() throws IOException {
		Score s = new Score();
		System.out.print("이름 > ");
		s.setName(br.readLine());
		s.setKorean(parseInputData("국어 > "));
		s.setEnglish(parseInputData("영어 > "));
		s.setMath(parseInputData("수학 > "));
		al.add(s);
	}
	// 성적 출력
	public void getScore() {
		// System.out.println(al); // 입력이 제대로 되었는지 확인하기 위해 재정의된 toString() 메서드 호출
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		for(Score s : al) {
			System.out.printf("%s\t%3d\t%3d\t%3d\t%3d\t%6.2f\t%s\n", s.getName(), s.getKorean(), s.getEnglish(), s.getMath(), s.makeSum(), s.makeAvg(), s.makeGrade());
		}
	}
	// 입력값 검사
	public int parseInputData(String title) throws IOException {
		while(true) {
			System.out.print(title);	
			try {
				int s=Integer.parseInt(br.readLine());
				if(s<0||s>100) {
					throw new ScoreValueException("성적은 0에서 100 사이의 값이어야 합니다."); // 입력값이 조건 미충족시 예외를 던져 catch 블럭으로 이동
				}		
				return s; // 예외가 발생하지 않은 경우 s를 반환하여 메서드 종료
			}
			catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
}