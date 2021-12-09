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
				if(menu==1) { // 영화 등록
					System.out.print("영화제목>");
					String mo_title = br.readLine();

					System.out.print("상영날짜(ex:2021/12/09)>");
					String mo_date = br.readLine();

					System.out.print("상영시간(ex:14:00)>");
					String mo_time = br.readLine();

					System.out.print("좌석수>");
					int mo_seats = Integer.parseInt(br.readLine());

					System.out.print("나이제한>");
					int mo_ban = Integer.parseInt(br.readLine());

					MovieVO vo = new MovieVO();
					vo.setMo_title(mo_title);
					vo.setMo_date(mo_date);
					vo.setMo_time(mo_time);
					vo.setMo_seats(mo_seats);
					vo.setMo_ban(mo_ban);

					dao.insertMovie(vo);
				}
				else if(menu==2) { // 영화 목록 확인
					dao.selectListMovie();
				}
				else if(menu==3) { // 영화 수정
					dao.selectListMovie();
					System.out.println("---------------------");
					System.out.print("영화 번호:");
					int mo_num = Integer.parseInt(br.readLine());
					System.out.print("영화 제목:");
					String mo_title = br.readLine();
					System.out.print("영화 날짜:");
					String mo_date =  br.readLine();
					System.out.print("영화 시간:");
					String mo_time = br.readLine();
					System.out.print("영화 좌석:");
					int mo_seats = Integer.parseInt(br.readLine());

					MovieVO movie = new MovieVO();
					movie.setMo_num(mo_num);
					movie.setMo_title(mo_title);
					movie.setMo_date(mo_date);
					movie.setMo_time(mo_time);
					movie.setMo_seats(mo_seats);

					dao.updateMovie(movie);
				}
				else if(menu==4) { // 영화 삭제
					// dao.selectListMovie();
					System.out.println("삭제할 영화 번호를 입력하세요.");
					System.out.print("번호 > ");
					int mo_num = Integer.parseInt(br.readLine());
					if(dao.checkMovie(mo_num)!=1) {
						System.out.println("영화 번호를 잘못 입력했습니다!");
						continue;
					}
					dao.deleteMovie(mo_num);
				}
				else if(menu==5) { // 전체 예매 내역 확인
					dao.selectListReservation();
				}
				else if(menu==6) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else {
					throw new NumberFormatException(); // catch 블럭으로 이동
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