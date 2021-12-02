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
			br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8")); // openStream() 메서드를 통해 URL 객체에 저장된 주소에 접근하여 입력 스트림을 반환; 두 번째 인자로 인코딩 방식 지정; 인코딩 방식을 지정하지 않을 경우 한글 등 영문 이외의 문자는 깨짐
			
			while((line = br.readLine())!=null) { // 입력 스트림에서 한 줄씩 읽고, 더 읽을 데이터가 없으면 루프 중단
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
