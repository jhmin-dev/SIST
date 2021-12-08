package kr.s07.note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NoteMain {
	private BufferedReader br;
	private NoteDAO note; // callMenu() 메서드에서 사용하기 때문에 멤버 변수로 선언
	
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
	
	// 메뉴
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("메뉴 : 1. 글 쓰기, 2. 목록 보기, 3. 상세 글 보기, 4. 글 수정, 5. 글 삭제, 6.종료");
			System.out.print("메뉴 > ");
			try {
				int menu = Integer.parseInt(br.readLine());
				if(menu==1) { // 글 쓰기
					System.out.print("이름 > ");
					String name = br.readLine();
					System.out.print("비밀번호 > ");
					String passwd = br.readLine();
					System.out.print("제목 > ");
					String subject = br.readLine();
					System.out.print("내용 > ");
					String content = br.readLine();
					System.out.print("이메일 > ");
					String email = br.readLine();
					// NoteDAO의 insertInfo() 메서드를 호출해서 데이터를 전달
					note.insertInfo(name, passwd, subject, content, email);
				}
				else if(menu==2) { // 목록 보기
					note.selectListInfo();
				}
				else if(menu==3) { // 상세 글 보기
					note.selectListInfo(); // 글 번호 확인용 목록 보기
					System.out.println("상세 정보를 확인하려는 글 번호를 입력하세요!");
					System.out.print("글 번호 > ");
					int num = Integer.parseInt(br.readLine());
					note.selectDetailInfo(num);
				}
				else if(menu==4) { // 글 수정
					note.selectListInfo(); // 글 번호 확인용 목록 보기
					System.out.println("수정하려는 글 번호를 입력하세요!");
					int num;
					while(true) { // 올바른 글 번호 입력 강제
						System.out.print("글 번호 > ");
						num = Integer.parseInt(br.readLine());
						if(note.selectDetailInfo(num)==1) break;
					}
					System.out.println("수정할 내용을 입력하세요!");
					System.out.print("이름 > ");
					String name = br.readLine();
					System.out.print("비밀번호 > ");
					String passwd = br.readLine();
					System.out.print("제목 > ");
					String subject = br.readLine();
					System.out.print("내용 > ");
					String content = br.readLine();
					System.out.print("이메일 > ");
					String email = br.readLine();
					note.updateInfo(num, name, passwd, subject, content, email);
				}
				else if(menu==5) { // 글 삭제
					note.selectListInfo(); // 글 번호 확인용 목록 보기
					System.out.println("삭제하려는 글 번호를 입력하세요!");
					System.out.print("글 번호 > ");
					int num = Integer.parseInt(br.readLine());
					note.deleteInfo(num);
					note.selectListInfo(); // 삭제가 정상적으로 수행되었는지 확인하기 위해 목록 호출
				}
				else if(menu==6) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					System.out.println("잘못 입력했습니다!");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
		}
	}
	
	public static void main(String[] args) {
		new NoteMain();
	}
}