package miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MemberMain {
	private BufferedReader br;
	private MovieDAO dao;
	private boolean flag;
	private int me_num;
	private MemberVO vo = new MemberVO();
	
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
		while(true) {
			System.out.print("1. 로그인, 2. 회원 가입, 3. 종료");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {
					System.out.print("아이디 > ");
					String me_id = br.readLine();

					System.out.print("비밀번호 > ");
					String me_passwd = br.readLine();

					me_num = dao.loginCheck(me_id, me_passwd);
					ReservationVO revo = new ReservationVO(); // 회원 번호로 회원 이름을 가져오기 위해 객체를 만들고 dao.getInfo() 메서드 사용
					revo.setMe_num(me_num);
					if(me_num!=0) {
						System.out.println(dao.getInfo(revo, "me_name") + " (" + me_id + ")님 로그인 되었습니다.");
						flag = true;
						break;
					}
					System.out.println("아이디 또는 비밀번호가 불일치합니다.");

				}else if (no ==2) {
					System.out.print("아이디 입력 > ");
					String me_id = br.readLine();
					int count = dao.checkId(me_id);

					if(count ==1) {
						System.out.println("아이디가 중복되었습니다.");
						continue;
					}

					System.out.print("비밀번호 입력 > ");
					String me_passwd = br.readLine();
					System.out.print("이름 > ");
					String me_name = br.readLine();
					System.out.println("생년월일을 입력하세요. 2021/12/09 형식으로 입력해야 합니다.");
					System.out.print("생년월일 > ");
					String brithdate = br.readLine();
					int me_age = vo.getAge(brithdate);
					System.out.print("전화번호 > ");
					String me_phone = br.readLine();

					vo.setMe_id(me_id);
					vo.setMe_passwd(me_passwd);
					vo.setMe_name(me_name);
					vo.setMe_Age(me_age);
					vo.setMe_phone(me_phone);
					dao.insertMember(vo);
					
				}else if(no==3) {
					System.out.println("프로그램을 종료했습니다.");
					break;

				}else {
					System.out.println("잘못 입력했습니다!");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다!");
			}
		}
		
		while(flag) {
			ReservationVO revo = new ReservationVO();
			revo.setMe_num(me_num);
			System.out.println("메뉴 : 1. 예매하기, 2. " + dao.getInfo(revo, "me_name") + " 님의 예매 정보 보기, 3. 예매 취소하기, 4. 종료");
			System.out.print("메뉴 > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) {
					System.out.println("상영시간표");
					dao.selectListMovie();
					ReservationVO vo = new ReservationVO();
					
					vo.setMe_num(me_num);
					System.out.println("예매할 영화 번호를 입력하세요.");
					System.out.print("번호 > ");
					vo.setMo_num(Integer.parseInt(br.readLine()));
					if(dao.checkAge(vo)!=1) {
						continue;
					}
					while(true) {
						System.out.println("예매할 좌석 수를 입력하세요. 1인에서 4인까지의 자리를 예매할 수 있습니다.");
						System.out.print("좌석 수 > ");
						int re_seats=Integer.parseInt(br.readLine());
						if(re_seats<=4 && re_seats>=1) {
							vo.setRe_seats(re_seats);
							break;
						}
						else if(re_seats>4) {
							System.out.println("한 번에 최대 4자리까지만 예매 가능합니다!");
						}
						else {
							System.out.println("예매할 좌석 수는 적어도 1자리 이상이어야 합니다!");
						}
					}
					if(dao.checkSeats(vo)!=1) {
						continue;
					}
					dao.reserve(vo);
				}
				else if(menu==2) {
					System.out.println("예매 정보 보기");
					dao.reservationCheck(me_num);
				}
				else if(menu==3) {
					dao.reservationCheck(me_num);
					System.out.println("취소하려는 예매의 번호를 입력하세요.");
					System.out.print("예매 번호 > ");
					int re_num = Integer.parseInt(br.readLine());
					ReservationVO vo = dao.getReservationVO(re_num);
					if(vo.getMe_num()!=me_num) {
						System.out.println("예매 번호를 잘못 입력했습니다.");
						continue;
					}
					if(vo.getRe_seats()==0) {
						System.out.println("이미 취소한 예매 내역입니다.");
						continue;
					}
					dao.cancelReservation(vo);
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