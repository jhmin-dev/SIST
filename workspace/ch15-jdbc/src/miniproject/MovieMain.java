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
			System.out.println("�޴� : 1. ��ȭ ���, 2. ��ȭ ��� Ȯ��, 3. ��ȭ ����, 4. ��ȭ ����, 5. ��ü ���� ���� Ȯ��, 6. ����");
			System.out.print("�޴� > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) { // ��ȭ ���
					System.out.print("��ȭ����>");
					String mo_title = br.readLine();

					System.out.print("�󿵳�¥(ex:2021/12/09)>");
					String mo_date = br.readLine();

					System.out.print("�󿵽ð�(ex:14:00)>");
					String mo_time = br.readLine();

					System.out.print("�¼���>");
					int mo_seats = Integer.parseInt(br.readLine());

					System.out.print("��������>");
					int mo_ban = Integer.parseInt(br.readLine());

					MovieVO vo = new MovieVO();
					vo.setMo_title(mo_title);
					vo.setMo_date(mo_date);
					vo.setMo_time(mo_time);
					vo.setMo_seats(mo_seats);
					vo.setMo_ban(mo_ban);

					dao.insertMovie(vo);
				}
				else if(menu==2) { // ��ȭ ��� Ȯ��
					dao.selectListMovie();
				}
				else if(menu==3) { // ��ȭ ����
					dao.selectListMovie();
					System.out.println("---------------------");
					System.out.print("��ȭ ��ȣ:");
					int mo_num = Integer.parseInt(br.readLine());
					System.out.print("��ȭ ����:");
					String mo_title = br.readLine();
					System.out.print("��ȭ ��¥:");
					String mo_date =  br.readLine();
					System.out.print("��ȭ �ð�:");
					String mo_time = br.readLine();
					System.out.print("��ȭ �¼�:");
					int mo_seats = Integer.parseInt(br.readLine());

					MovieVO movie = new MovieVO();
					movie.setMo_num(mo_num);
					movie.setMo_title(mo_title);
					movie.setMo_date(mo_date);
					movie.setMo_time(mo_time);
					movie.setMo_seats(mo_seats);

					dao.updateMovie(movie);
				}
				else if(menu==4) { // ��ȭ ����
					// dao.selectListMovie();
					System.out.println("������ ��ȭ ��ȣ�� �Է��ϼ���.");
					System.out.print("��ȣ > ");
					int mo_num = Integer.parseInt(br.readLine());
					if(dao.checkMovie(mo_num)!=1) {
						System.out.println("��ȭ ��ȣ�� �߸� �Է��߽��ϴ�!");
						continue;
					}
					dao.deleteMovie(mo_num);
				}
				else if(menu==5) { // ��ü ���� ���� Ȯ��
					dao.selectListReservation();
				}
				else if(menu==6) { // ����
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
				else {
					throw new NumberFormatException(); // catch ������ �̵�
				}
			}
			catch(NumberFormatException e) {
				System.out.println("�޴��� �߸� �Է��߽��ϴ�!");
			}
		}
	}
	
	public static void main(String[] args) {
		new MovieMain();
	}
}