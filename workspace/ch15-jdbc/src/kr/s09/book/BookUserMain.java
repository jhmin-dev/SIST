package kr.s09.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BookUserMain {
	private BufferedReader br;
	private BookDAO dao;
	private boolean flag; // 로그인 여부
	private int me_num; // 회원 번호
	
	public BookUserMain() {
		dao = new BookDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
	
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("메뉴 : 1. 로그인, 2. 회원 가입, 3. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu = Integer.parseInt(br.readLine());
				if(menu==1) { // 로그인
					System.out.print("아이디 > ");
					String me_id = br.readLine();
					System.out.print("비밀번호 > ");
					String me_passwd = br.readLine();
					me_num = dao.loginCheck(me_id, me_passwd);
					if(me_num!=0) {
						System.out.println(me_id + "님 로그인되었습니다.");
						flag = true;
						break;
					}
					System.out.println("아이디 또는 비밀번호를 잘못 입력했습니다!");
				}
				else if(menu==2) { // 회원 가입
					MemberVO vo = new MemberVO();
					System.out.print("아이디 > ");
					vo.setMe_id(br.readLine());
					if(dao.checkID(vo.getMe_id())==1) { // 아이디 중복 체크
						System.out.println("중복된 아이디입니다.");
						continue; // 메뉴로 되돌아감
					}
					System.out.print("비밀번호 > ");
					vo.setMe_passwd(br.readLine());
					System.out.print("이름 > ");
					vo.setMe_name(br.readLine());
					System.out.print("연락처 > ");
					vo.setMe_phone(br.readLine());
					dao.insertMember(vo);
				}
				else if(menu==3) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					System.out.println("메뉴 번호를 잘못 입력했습니다!");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
		}
		
		while(flag) { // 로그인시에만 동작
			System.out.println("메뉴 : 1. 도서 목록, 2. 도서 대출하기, 3. 내 대출 목록, 4. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu = Integer.parseInt(br.readLine());
				if(menu==1) { // 도서 목록
					dao.selectListBook();
				}
				else if(menu==2) { // 도서 대출하기
					System.out.println("도서 검색");
					dao.selectListBook();
					ReservationVO vo = new ReservationVO();
					vo.setMe_num(me_num);
					while(true) {
						System.out.println("대출할 도서 번호를 입력하세요(입력 중지: 0)");
						System.out.print("번호 > ");
						vo.setBk_num(Integer.parseInt(br.readLine()));
						if(vo.getBk_num()==0) break; // 메뉴로 되돌아가기
						int reserved=dao.getStatusReservation(vo.getBk_num()); // 대출 여부 확인
						if(reserved==1) {
							System.out.println("대출 중인 도서는 신청할 수 없습니다.");
						}
						else if(reserved==-1) {
							System.out.println("도서 번호를 잘못 입력했습니다.");
						}
						else {
							dao.insertReservation(vo);
							break;
						}
					}
				}
				else if(menu==3) { // 내 대출 목록
					dao.selectMyList(me_num);
					System.out.println("반납할 도서의 대출 번호를 입력하세요(입력 중지: 0)");
					System.out.print("대출 번호 > ");
					int re_num = Integer.parseInt(br.readLine());
					if(re_num==0) continue; // 메뉴로 되돌아가기
					dao.updateReservation(re_num);
				}
				else if(menu==4) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					System.out.println("메뉴 번호를 잘못 입력했습니다!");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
		}
	}
	
	public static void main(String[] args) {
		new BookUserMain();
	}
}