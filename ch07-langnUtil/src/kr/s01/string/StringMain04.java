package kr.s01.string;

import java.util.Scanner;

public class StringMain04 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] ���ڿ��� �� ���ھ� �о �������� ���
		 * hello -> olleh
		 */
		Scanner input = new Scanner(System.in);
		
		System.out.print("���ڿ� > ");
		String s = input.nextLine();
	
		for(int i=s.length();i>0;i--) {
			System.out.print(s.charAt(i-1)); // i�� �����̴� ����(=s.length()���� 1����)�� �ε����� ����(=0���� s.length()-1����) ���� ����
		}
		
		input.close();
	}
}