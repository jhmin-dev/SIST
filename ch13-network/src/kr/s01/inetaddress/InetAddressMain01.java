package kr.s01.inetaddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain01 {
	public static void main(String[] args) {
		BufferedReader br = null; // finally에서 자원 정리하기 위해서는 반드시 try 밖에서 변수 선언해야 함
		String url = null;
		InetAddress iaddr = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("웹사이트 도메인 입력 > ");
			url = br.readLine();
			
			iaddr = InetAddress.getByName(url); // static 메서드인 getByName() 메서드에 도메인을 전달하면 IP 주소를 갖는 InetAddress 객체 반환; 잘못 입력하는 경우 UnknownHostException 발생
			
			System.out.println("호스트 이름 : " + iaddr.getHostName()); // getHostName() 메서드는 도메인이 있으면 도메인명을 반환하고, 도메인이 없으면 IP 주소를 반환
			System.out.println("호스트 IP 주소 : " + iaddr.getHostAddress()); // getHostAddress() 메서드는 IP 주소를 반환
			
			iaddr = InetAddress.getLocalHost(); // getLocalHost() 메서드는 로컬 호스트 IP 주소를 갖는 InetAddress 객체 반환
			
			System.out.println("로컬 호스트 이름 : " + iaddr.getHostName());
			System.out.println("로컬 호스트 IP 주소 : " + iaddr.getHostAddress());
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally { // 콘솔 입력시에는 자원 정리 생략 가능
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
