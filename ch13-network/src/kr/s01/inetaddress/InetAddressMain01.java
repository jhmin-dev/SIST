package kr.s01.inetaddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain01 {
	public static void main(String[] args) {
		BufferedReader br = null; // finally���� �ڿ� �����ϱ� ���ؼ��� �ݵ�� try �ۿ��� ���� �����ؾ� ��
		String url = null;
		InetAddress iaddr = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("������Ʈ ������ �Է� > ");
			url = br.readLine();
			
			iaddr = InetAddress.getByName(url); // static �޼����� getByName() �޼��忡 �������� �����ϸ� IP �ּҸ� ���� InetAddress ��ü ��ȯ; �߸� �Է��ϴ� ��� UnknownHostException �߻�
			
			System.out.println("ȣ��Ʈ �̸� : " + iaddr.getHostName()); // getHostName() �޼���� �������� ������ �����θ��� ��ȯ�ϰ�, �������� ������ IP �ּҸ� ��ȯ
			System.out.println("ȣ��Ʈ IP �ּ� : " + iaddr.getHostAddress()); // getHostAddress() �޼���� IP �ּҸ� ��ȯ
			
			iaddr = InetAddress.getLocalHost(); // getLocalHost() �޼���� ���� ȣ��Ʈ IP �ּҸ� ���� InetAddress ��ü ��ȯ
			
			System.out.println("���� ȣ��Ʈ �̸� : " + iaddr.getHostName());
			System.out.println("���� ȣ��Ʈ IP �ּ� : " + iaddr.getHostAddress());
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally { // �ܼ� �Է½ÿ��� �ڿ� ���� ���� ����
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
