package kr.s02.url;

import java.net.URL;
import java.net.MalformedURLException; // URL 객체 생성시 URL 형식을 지키지 않으면 발생하는 예외

public class UrlMain01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://java.sun.com/index.jsp?name=milktea#content"); // 실제 접속 가능한 주소가 아니어도 URL 형식에 맞으면 URL 객체가 생성됨
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("기본 포트 : " + url.getDefaultPort()); // 프로토콜의 기본 포트를 반환
			System.out.println("포트 : " + url.getPort()); // URL 객체 생성시 포트를 명시하지 않으면 -1 반환
			System.out.println("패스 : " + url.getPath());
			System.out.println("쿼리 : " + url.getQuery()); // URL에서 ? 이후를 반환
			System.out.println("레퍼런스 : " + url.getRef()); // URL에서 # 이후를 반환
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
