package kr.s01.inetaddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			String url = null;
			InetAddress[] addresses;
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("������Ʈ ������ �Է� > ");
			url = br.readLine();
			
			addresses = InetAddress.getAllByName(url); // static �޼����� getAllByName() �޼��忡 �������� �����ϸ� �ش� �����ΰ� ���εǾ� �ִ� ��� IP �ּ� ������ InetAddress[]�� ��ȯ
			
			for(int i=0;i<addresses.length;i++) {
				System.out.println("ȣ��Ʈ �̸� : " + addresses[i].getHostName() + ", " + "ȣ��Ʈ IP �ּ� : " + addresses[i].getHostAddress());
			}
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
