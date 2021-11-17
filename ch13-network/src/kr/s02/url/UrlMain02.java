package kr.s02.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class UrlMain02 {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader br = null;
		String address = "https://www.naver.com/index.html";
		String line = "";
		
		try {
			url = new URL(address);
			br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8")); // openStream() �޼��带 ���� URL ��ü�� ����� �ּҿ� �����Ͽ� �Է� ��Ʈ���� ��ȯ; �� ��° ���ڷ� ���ڵ� ��� ����; ���ڵ� ����� �������� ���� ��� �ѱ� �� ���� �̿��� ���ڴ� ����
			
			while((line = br.readLine())!=null) { // �Է� ��Ʈ������ �� �پ� �а�, �� ���� �����Ͱ� ������ ���� �ߴ�
				System.out.println(line);
			}
		}
		catch(MalformedURLException e) {
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
