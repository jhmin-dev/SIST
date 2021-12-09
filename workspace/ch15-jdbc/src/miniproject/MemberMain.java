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
			System.out.print("1.�α���, 2.ȸ�� ����, 3.����");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) { // �α���
					System.out.print("���̵�:");
					String me_id = br.readLine();
					System.out.print("��й�ȣ");
					String me_passwd = br.readLine();

					me_num = dao.loginCheck(me_id, me_passwd);
					if(me_num!=0) {
						System.out.println(me_id + "(" + me_num + ")�� �α��� �Ǿ����ϴ�.");
						flag = true;
						break;
					}
					System.out.println("���̵� �Ǵ� ��й�ȣ�� ����ġ�մϴ�.");

				}else if (no ==2) { // ȸ�� ����
					System.out.print("���̵� �Է�>");
					String me_id = br.readLine();
					int count = dao.checkId(me_id);
					if(count ==1) {
						System.out.println("���̵� �ߺ��Ǿ����ϴ�.");
						continue;
					}

					System.out.print("��й�ȣ �Է�>");
					String me_passwd = br.readLine();
					System.out.print("�̸� >");
					String me_name = br.readLine();
					System.out.print("�������>");
					String brithdate = br.readLine();
					int me_age = vo.getAge(brithdate);
					System.out.print("��ȭ��ȣ>");
					String me_phone = br.readLine();

					vo.setMe_id(me_id);
					vo.setMe_passwd(me_passwd);
					vo.setMe_name(me_name);
					vo.setMe_Age(me_age);
					vo.setMe_phone(me_phone);
					dao.insertMember(vo);					
				}else if(no==3) { // ����
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�");
				}
			}catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է°���");
			}
		}
		while(flag) {			
			System.out.println("�޴� : 1. �����ϱ�, 2. ���� ���� ����, 3. ���� ����ϱ�, 4. ����");
			System.out.print("�޴� > ");
			try {
				int menu=Integer.parseInt(br.readLine());
				if(menu==1) {
					System.out.println("�󿵽ð�ǥ");
					dao.selectListMovie();
					ReservationVO vo = new ReservationVO();
					vo.setMe_num(me_num);
					System.out.println("������ ��ȭ ��ȣ�� �Է��ϼ���.");
					System.out.print("��ȣ > ");
					vo.setMo_num(Integer.parseInt(br.readLine()));
					if(dao.checkAge(vo)!=1) {
						continue;
					}
					while(true) {
						System.out.println("������ �¼� ���� �Է��ϼ���. 1�ο��� 4�α����� �ڸ��� ������ �� �ֽ��ϴ�.");
						System.out.print("�¼� �� > ");
						int re_seats=Integer.parseInt(br.readLine());
						if(re_seats<=4 && re_seats>=1) {
							vo.setRe_seats(re_seats);
							break;
						}
						else if(re_seats>4) {
							System.out.println("�� ���� �ִ� 4�ڸ������� ���� �����մϴ�!");
						}
						else {
							System.out.println("������ �¼� ���� ��� 1�ڸ� �̻��̾�� �մϴ�!");
						}
					}
					if(dao.checkSeats(vo)!=1) {
						continue;
					}
					dao.reserve(vo);
				}
				else if(menu==2) {
					dao.selectListReservation(me_num);
				}
				else if(menu==3) {
					dao.selectListReservation(me_num);
					System.out.println("����Ϸ��� ������ ��ȣ�� �Է��ϼ���.");
					System.out.print("���� ��ȣ > ");
					int re_num = Integer.parseInt(br.readLine());
					ReservationVO vo = dao.getReservationVO(re_num);
					if(vo.getMe_num()!=me_num) {
						System.out.println("���� ��ȣ�� �߸� �Է��߽��ϴ�.");
						continue;
					}
					if(vo.getRe_seats()==0) {
						System.out.println("�̹� ����� ���� �����Դϴ�.");
						continue;
					}
					dao.cancelReservation(vo);
				}
				else if(menu==4) {
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
		new MemberMain();
	}
}