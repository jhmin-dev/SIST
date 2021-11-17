package kr.s02.url;

import java.net.URL;
import java.net.MalformedURLException; // URL ��ü ������ URL ������ ��Ű�� ������ �߻��ϴ� ����

public class UrlMain01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://java.sun.com/index.jsp?name=milktea#content"); // ���� ���� ������ �ּҰ� �ƴϾ URL ���Ŀ� ������ URL ��ü�� ������
			System.out.println("�������� : " + url.getProtocol());
			System.out.println("ȣ��Ʈ : " + url.getHost());
			System.out.println("�⺻ ��Ʈ : " + url.getDefaultPort()); // ���������� �⺻ ��Ʈ�� ��ȯ
			System.out.println("��Ʈ : " + url.getPort()); // URL ��ü ������ ��Ʈ�� ������� ������ -1 ��ȯ
			System.out.println("�н� : " + url.getPath());
			System.out.println("���� : " + url.getQuery()); // URL���� ? ���ĸ� ��ȯ
			System.out.println("���۷��� : " + url.getRef()); // URL���� # ���ĸ� ��ȯ
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
