package myminiprj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;

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
			System.out.println("메뉴를 잘못 입력했습니다!");
		}
		else if(type.equals("menu_quit")) {
			System.out.println("프로그램을 종료합니다.");
		}
		else if(type.equals("input_null")) {
			System.out.println("아무 것도 입력하지 않았습니다!");
		}
		else if(type.equals("year_error")) {
			System.out.println("연도를 잘못 입력했습니다!");
		}
		else if(type.equals("month_error")) {
			System.out.println("월을 잘못 입력했습니다!");
		}
		else if(type.equals("date_error")) {
			System.out.println("일을 잘못 입력했습니다!");
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
		MemberVO vo = new MemberVO();
		while(true) {
			vo.setMe_id(validateLength("아이디 : ", 20));
			if(dao.checkID(vo)==0) break;
		}
		vo.setMe_pw(validateLength("비밀번호 : ", 30));
		vo.setMe_name(validateLength("이름 : ", 4000));
		vo.setMe_birthdate(validateDate("생년월일을 입력하세요."));
		dao.insertMember(vo);
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

	// 유효성 검사 : 길이
	public String validateLength(String guide, int length) throws IOException {
		while(true) {
			System.out.print(guide);
			String str = br.readLine();
			if(str.equals("")) {
				printMessage("input_null");
			}
			else if(str.getBytes("UTF-8").length>length) {
				System.out.println("최대 "+length+"바이트까지만 입력 가능합니다! (한글 : 3바이트, 영문 및 숫자 : 1바이트)");
			}
			else {
				return str;
			}
		}
	}

	// 유효성 검사 : 날짜
	public String validateDate(String guide) throws IOException {
		int year, month, date;
		Calendar input = Calendar.getInstance();
		while(true) {
			System.out.println(guide);
			while(true) { // 연도 loop
				System.out.print("연도 : ");
				try {
					year = Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e) {
					printMessage("year_error");
					continue;
				}
				if(year>=0 && year<100) { // 연도를 두 자리로 입력받은 경우
					if(year<30) { // 00~29는 21세기로 간주
						year = 2000+year;
					}
					else { // 30~99는 20세기로 간주
						year = 1900+year;
					}
					while(true) { // 두 자리 연도를 올바르게 해석했는지 확인
						System.out.println(year+"년을 입력하시겠습니까? (y. 예, n. 아니오)");
						String yn = br.readLine();
						if(yn.equalsIgnoreCase("y")) {
							break;
						}
						else if(yn.equalsIgnoreCase("n")) {
							if(year>=1900 && year<2000) {
								year += 100;
							}
							else {
								year -= 100;
							}
							break;
						}
					}
					break; // 연도 입력 종료
				}
				else if(year>=1900 && year<2100) { // 연도를 네 자리로 입력받은 경우
					break; // 연도 입력 종료
				}
				printMessage("year_error");
			}
			while(true) { // 월 loop
				System.out.print("월 : ");
				try {
					month = Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e) {
					printMessage("month_error");
					continue;
				}
				if(month>=1 && month<=12) {
					break;
				}
				printMessage("month_error");
			}
			while(true) { // 일 loop
				System.out.print("일 : ");
				try {
					date = Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e) {
					printMessage("date_error");
					continue;
				}
				if(date>=1 && date<=31) {
					break;
				}
				printMessage("date_error");
			}
			input.setLenient(false); // 날짜를 엄격하게 해석하도록 설정
			input.set(year, month-1, date);
			try {
				input.getTime(); // 입력받은 날짜가 유효하지 않은 경우 예외 발생
				break;
			}
			catch(IllegalArgumentException e) {
				System.out.println("유효하지 않은 날짜입니다!");
				continue;
			}
		}
		return year+"-"+month+"-"+date;
	}

	public static void main(String[] args) {
		new CinemaMain();
	}
}