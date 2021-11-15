package kr.s01.list;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemberMain {
	/*
	 * [�ǽ�]
	 * ArrayList, BufferedReader ����
	 * �޴� : 1. ȸ�� ���� �Է�, 2. ȸ�� ���� ���, 3. ����
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
			System.out.println("�޴� : 1. ȸ�� ���� �Է�, 2. ȸ�� ���� ���, 3. ����");
			System.out.print("�޴� > ");
			String menu=br.readLine();
			if(menu.equals("1")) {
				setInfo();
			}
			else if(menu.equals("2")) {
				getInfo();
			}
			else if(menu.equals("3")) {
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				break;
			}
			else {
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	public void setInfo() throws IOException {
		Member m=new Member();
		System.out.print("�̸� > ");
		m.setName(br.readLine());
		m.setAge(parseInputData("���� > ")); // ���� ���� �޼��带 ������ �и��Ͽ� ȣ��
		System.out.print("���� > ");
		m.setJob(br.readLine());
		System.out.print("�ּ� > ");
		m.setAddress(br.readLine());
		System.out.print("��ȭ��ȣ > ");
		m.setPhone(br.readLine());
		ml.add(m);
	}
	
	// �Է°��� �������� Ȯ���ϰ�, 1 �̻��� ���� �Է¹޴� �޼���
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
					System.out.println("���̴� 0 ������ �� �����ϴ�.");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("���̴� ���ڸ� �Է��� �� �ֽ��ϴ�.");
			}
		}
		return a;
	}
	
	public void getInfo() {
		System.out.println("�� ȸ�� �� : "+ml.size());
		if(ml.size()!=0) System.out.println("�̸�\t����\t����\t�ּ�\t��ȭ��ȣ");
		for(Member m:ml) {
			System.out.println(m.getName()+"\t"+m.getAge()+"��\t"+m.getJob()+"\t"+m.getAddress()+"\t"+m.getPhone());
		}
	}
	
	public static void main(String[] args) {
		new MemberMain();
	}
}