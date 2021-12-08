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
				if(menu==1) {
					System.out.println("��ȭ ���");
					dao.insertMovie();
				}
				else if(menu==2) {
					System.out.println("��ȭ ��� Ȯ��");
				}
				else if(menu==3) {
					System.out.println("��ȭ ����");
				}
				else if(menu==4) {
					// dao.selectListMovie();
					MovieVO vo = new MovieVO();
					System.out.println("������ ��ȭ ��ȣ�� �Է��ϼ���.");
					System.out.print("��ȣ > ");
					vo.setMo_num(Integer.parseInt(br.readLine()));
					
					dao.deleteMovie(vo);
				}
				else if(menu==5) {
					System.out.println("��ü ���� ���� Ȯ��");
				}
				else if(menu==6) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
				else {
					throw new NumberFormatException();
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