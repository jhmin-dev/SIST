package kr.s08.score;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ScoreMain {
	private BufferedReader br;
	private ScoreDAO dao;
	
	public ScoreMain() {
		dao = new ScoreDAO();
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
	
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("메뉴 : 1. 성적 입력, 2. 목록 보기, 3. 상세 정보 보기, 4. 수정, 5. 삭제, 6. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu = Integer.parseInt(br.readLine());
				if(menu==1) { // 성적 입력
					System.out.print("이름 > ");
					String name = br.readLine();
					int korean = parseInputData("국어 > ");
					int english = parseInputData("영어 > ");
					int math = parseInputData("수학 > ");
					
					// ScoreVO 객체 생성
					ScoreVO score = new ScoreVO();
					score.setName(name);
					score.setKorean(korean);
					score.setEnglish(english);
					score.setMath(math);
					
					dao.insertInfo(score);
				}
				else if(menu==2) { // 목록 보기
					dao.selectListInfo();
				}
				else if(menu==3) { // 상세 정보 보기
					dao.selectListInfo(); // 번호 확인용 목록 보기
					System.out.println("상세 정보를 조회할 자료의 번호를 입력하세요.");
					System.out.print("번호 > ");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailInfo(num);
				}
				else if(menu==4) { // 수정
					dao.selectListInfo(); // 번호 확인용 목록 보기
					System.out.println("수정할 자료의 번호를 입력하세요.");
					System.out.print("번호 > ");
					int num = Integer.parseInt(br.readLine());
					if(dao.selectDetailInfo(num)==-1) continue; // 수정할 글 번호를 잘못 입력한 경우 메뉴로 돌아감
					ScoreVO score = new ScoreVO();
					score.setNum(num);
					System.out.print("이름 > ");
					score.setName(br.readLine());
					score.setKorean(parseInputData("국어 > "));
					score.setEnglish(parseInputData("영어 > "));
					score.setMath(parseInputData("수학 > "));
					dao.updateInfo(score);
				}
				else if(menu==5) { // 삭제
					System.out.print("삭제 전 ");
					dao.selectListInfo(); // 번호 확인용 목록 보기
					System.out.println("삭제할 자료의 번호를 입력하세요.");
					System.out.print("번호 > ");
					int num = Integer.parseInt(br.readLine());
					dao.deleteInfo(num);
					System.out.print("삭제 후 ");
					dao.selectListInfo(); // 행 삭제가 정상적으로 수행되었는지 확인하기 위한 목록 보기
				}
				else if(menu==6) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					System.out.println("메뉴를 잘못 입력했습니다!");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
		}
	}
	
	// 성적 범위 검사(0~100)
	public int parseInputData(String course) throws IOException {
		while(true) {
			System.out.println(course);
			try {
				int num = Integer.parseInt(br.readLine());
				if(num<0 || num>100)
					throw new ScoreValueException("0부터 100 사이의 값만 허용됩니다!");
				return num;
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
			catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new ScoreMain();
	}
}