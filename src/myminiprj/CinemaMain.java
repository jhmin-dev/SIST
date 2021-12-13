package myminiprj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CinemaMain {
	private BufferedReader br;
	private CinemaDAO dao;
	private int me_num = 0;
	private String me_access = "USER";
	
	public CinemaMain() {
		dao = new CinemaDAO();
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
		all: while(true) {
			// 사용자 페이지의 첫 번째 while
			while(me_num==0 && me_access.equalsIgnoreCase("USER")) {
				System.out.println("메뉴 : 1. 로그인, 2. 회원 가입, q. 종료");
				System.out.print("메뉴 > ");
				String menu = br.readLine();
				if(menu.equals("1")) { // 1. 로그인
					me_num = callGetLogin();
				}
				else if(menu.equals("2")) { // 2. 회원 가입
					callInsertMember();
				}
				else if(menu.equalsIgnoreCase("q")) { // q. 종료
					printMessage("menu_quit");
					break all;
				}
				else if(menu.equalsIgnoreCase("admin")) { // admin. 관리자 페이지
					callAdminMenu();
				}
				else { // 잘못 입력
					printMessage("menu_error");
				}
			}

			// 사용자 페이지의 두 번째 while
			while(me_num!=0 && me_access.equalsIgnoreCase("USER")) {
				System.out.println("메뉴 : 1. 예매하기, 2. 예매 내역 보기, 3. 예매 취소하기, 0. 로그아웃, q. 종료");
								System.out.print("메뉴 > ");
				String menu = br.readLine();
				if(menu.equals("1")) { // 1. 예매하기
					System.out.println("예매하기");
				}
				else if(menu.equals("2")) { // 2. 예매 내역 보기
					System.out.println("예매 내역 보기");
				}
				else if(menu.equals("3")) { // 3. 예매 취소하기
					System.out.println("예매 취소하기");
				}
				else if(menu.equals("0")) { // 0. 로그아웃
					me_num = 0;
					continue all;
				}
				else if(menu.equalsIgnoreCase("q")) { // q. 종료
					printMessage("menu_quit");
					break all;
				}
				else { // 잘못 입력
					printMessage("menu_error");
				}
			}
		}
	}

	// 가이드 메시지 출력
	public void printMessage(String type) {
		if(type.equals("menu_error")) {
			System.out.println("메뉴를 잘못 입력했습니다.");
		}
		else if(type.equals("menu_quit")) {
			System.out.println("프로그램을 종료합니다.");
		}
		else {
			System.out.println(type);
		}
	}

	// 1. 로그인
	public int callGetLogin() throws IOException {

		return me_num;
	}

	// 2. 회원 가입
	public void callInsertMember() throws IOException {

	}

	// admin. 관리자 페이지
	public void callAdminMenu() throws IOException {
		// 관리자 페이지의 첫 번째 while
		while(!me_access.equalsIgnoreCase("ADMIN")) {
			System.out.println("메뉴 : 1. 로그인, 2. 관리자 등록, q. 종료");
			System.out.print("메뉴 > ");
			String menu = br.readLine();
			if(menu.equals("1")) { // 1. 로그인
				me_access = callCheckAdmin();
			}
			else if(menu.equals("2")) { // 2. 관리자 등록
				callRegisterAdmin();
			}
			else if(menu.equalsIgnoreCase("q")) { // q. 종료
				printMessage("menu_quit");
				System.exit(0);
			}
			else { // 잘못 입력
				printMessage("menu_error");
			}
		}

		// 관리자 페이지의 두 번째 while
		while(me_access.equalsIgnoreCase("ADMIN")) {
			System.out.println("메뉴 : 1. 영화 관리, 2. 상영 시간표 관리, 3. 회원 및 예매 내역 관리, q. 종료");
			System.out.print("메뉴 > ");
			String menu = br.readLine();
			if(menu.equals("1")) { // 1. 영화 관리

			}
			else if(menu.equals("2")) { // 2. 상영 시간표 관리

			}
			else if(menu.equals("3")) { // 3. 회원 및 예매 내역 관리

			}
			else if(menu.equalsIgnoreCase("q")) { // q. 종료
				printMessage("menu_quit");
				System.exit(0);
			}
			else { // 잘못 입력
				printMessage("menu_error");
			}
		}
	}

	// 1. 로그인
	public String callCheckAdmin() throws IOException {
		System.out.print("아이디 : ");
		String me_id = br.readLine();
		System.out.print("비밀번호 : ");
		String me_pw = br.readLine();
		return dao.checkAdmin(me_id, me_pw);
	}

	// 2. 관리자 등록
	public void callRegisterAdmin() throws IOException {
		callInsertMember();
		dao.registerAdmin();
	}

	public static void main(String[] args) {
		new CinemaMain();
	}
}