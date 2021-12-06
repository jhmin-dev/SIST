package kr.s09.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BookAdminMain {
	private BufferedReader br;
	private BookDAO dao;
	
	public BookAdminMain() {
		dao = new BookDAO();
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
			System.out.println("메뉴 : 1. 회원 목록, 2. 도서 등록, 3. 도서 목록, 4. 대출 목록, 5. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu = Integer.parseInt(br.readLine());
				if(menu==1) { // 회원 목록
					dao.selectListMember();
				}
				else if(menu==2) { // 도서 등록
					BookVO vo = new BookVO();
					System.out.print("도서명 > ");
					vo.setBk_name(br.readLine());
					System.out.print("분류 > ");
					vo.setBk_category(br.readLine());
					dao.insertBook(vo);
				}
				else if(menu==3) { // 도서 목록
					dao.selectListBook();
				}
				else if(menu==4) { // 대출 목록
					
				}
				else if(menu==5) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					System.out.println("메뉴 번호를 잘못 입력했습니다!");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
		}
	}
	
	public static void main(String[] args) {
		new BookAdminMain();
	}
}