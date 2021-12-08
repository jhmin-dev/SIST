package miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MovieMain {
	private BufferedReader br;
	private MovieDAO dao;
	
	public MovieMain() {
		dao = new MovieDAO();
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
			System.out.println("메뉴 : 1. 영화 등록, 2. 영화 목록 확인, 3. 영화 수정, 4. 영화 삭제, 5. 전체 예매 내역 확인, 6. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) {
					System.out.println("영화 등록");
					dao.insertMovie();
				}
				else if(menu==2) {
					System.out.println("영화 목록 확인");
				}
				else if(menu==3) {
					System.out.println("영화 수정");
				}
				else if(menu==4) {
					// dao.selectListMovie();
					MovieVO vo = new MovieVO();
					System.out.println("삭제할 영화 번호를 입력하세요.");
					System.out.print("번호 > ");
					vo.setMo_num(Integer.parseInt(br.readLine()));
					
					dao.deleteMovie(vo);
				}
				else if(menu==5) {
					System.out.println("전체 예매 내역 확인");
				}
				else if(menu==6) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException e) {
				System.out.println("메뉴를 잘못 입력했습니다!");
			}
		}
	}
	
	public static void main(String[] args) {
		new MovieMain();
	}
}