package miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MemberMain {
	private BufferedReader br;
	private MovieDAO dao;
	private boolean flag;
	private int me_num;
	
	public MemberMain() {
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
		// 로그인 건너뛰고 예매하기 위해 임시로 값 설정
		flag=true;
		me_num=1;
		while(flag) {
			System.out.println("메뉴 : 1. 예매하기, 2. 예매 정보 보기, 3. 예매 취소하기, 4. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) {
					System.out.println("상영시간표");
					// dao.selectListMovie();
					ReservationVO vo = new ReservationVO();
					vo.setMe_num(me_num);
					System.out.println("예매할 영화 번호를 입력하세요.");
					System.out.print("번호 > ");
					vo.setMo_num(Integer.parseInt(br.readLine()));
					if(dao.checkAge(vo)!=1) {
						continue;
					}
					while(true) {
						System.out.println("예매할 영화 좌석 수(1~4)를 입력하세요.");
						System.out.print("좌석 수 > ");
						int re_seats=Integer.parseInt(br.readLine());
						if(re_seats<=4 && re_seats>=1) {
							vo.setRe_seats(re_seats);
							break;
						}
						System.out.println("한 번에 1~4인 좌석만 예매 가능합니다.");
					}
					if(dao.checkSeats(vo)!=1) {
						continue;
					}
					dao.reserve(vo);
				}
				else if(menu==2) {
					System.out.println("예매 정보 보기");
				}
				else if(menu==3) {
					System.out.println("예매 취소하기");
				}
				else if(menu==4) {
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
		new MemberMain();
	}
}