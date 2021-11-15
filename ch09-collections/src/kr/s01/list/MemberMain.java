package kr.s01.list;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemberMain {
	/*
	 * [실습]
	 * ArrayList, BufferedReader 생성
	 * 메뉴 : 1. 회원 정보 입력, 2. 회원 정보 출력, 3. 종료
	 */
	ArrayList<Member> ml;
	BufferedReader br;
	
	public MemberMain() {
		ml=new ArrayList<Member>();
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
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
			System.out.println("메뉴 : 1. 회원 정보 입력, 2. 회원 정보 출력, 3. 종료");
			System.out.print("메뉴 > ");
			String menu=br.readLine();
			if(menu.equals("1")) {
				setInfo();
			}
			else if(menu.equals("2")) {
				getInfo();
			}
			else if(menu.equals("3")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
	}
	
	public void setInfo() throws IOException {
		Member m=new Member();
		System.out.print("이름 > ");
		m.setName(br.readLine());
		m.setAge(parseInputData("나이 > ")); // 나이 검증 메서드를 별도로 분리하여 호출
		System.out.print("직업 > ");
		m.setJob(br.readLine());
		System.out.print("주소 > ");
		m.setAddress(br.readLine());
		System.out.print("전화번호 > ");
		m.setPhone(br.readLine());
		ml.add(m);
	}
	
	// 입력값이 숫자인지 확인하고, 1 이상의 값만 입력받는 메서드
	public int parseInputData(String title) throws IOException {
		int a;
		while(true) {
			System.out.print(title);
			try {
				a=Integer.parseInt(br.readLine());
				if(a>=1) {
					break;
				}
				else {
					System.out.println("나이는 0 이하일 수 없습니다.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("나이는 숫자만 입력할 수 있습니다.");
			}
		}
		return a;
	}
	
	public void getInfo() {
		System.out.println("총 회원 수 : "+ml.size());
		if(ml.size()!=0) System.out.println("이름\t나이\t직업\t주소\t전화번호");
		for(Member m:ml) {
			System.out.println(m.getName()+"\t"+m.getAge()+"세\t"+m.getJob()+"\t"+m.getAddress()+"\t"+m.getPhone());
		}
	}
	
	public static void main(String[] args) {
		new MemberMain();
	}
}