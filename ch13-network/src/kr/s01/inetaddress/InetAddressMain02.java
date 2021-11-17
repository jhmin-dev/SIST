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
			System.out.print("웹사이트 도메인 입력 > ");
			url = br.readLine();
			
			addresses = InetAddress.getAllByName(url); // static 메서드인 getAllByName() 메서드에 도메인을 전달하면 해당 도메인과 매핑되어 있는 모든 IP 주소 정보를 InetAddress[]로 반환
			
			for(int i=0;i<addresses.length;i++) {
				System.out.println("호스트 이름 : " + addresses[i].getHostName() + ", " + "호스트 IP 주소 : " + addresses[i].getHostAddress());
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
