package kr.s01.p1;

import kr.s01.p2.PackTwo; // ȣ���ϰ��� �ϴ� Ŭ������ ��Ű���� ���

public class PackMain {
	public static void main(String[] args) {
		// kr.s01.p1.PackOne p1 = new kr.s01.p1.PackOne();
		PackOne p1 = new PackOne(); // ���� ��Ű���� Ŭ������ ȣ��� ��Ű������ ������ �� ����
		p1.study();
		
		kr.s01.p2.PackTwo p2 = new kr.s01.p2.PackTwo();
		p2.play();
		
		PackTwo p3 = new PackTwo(); // ����߱� ������ ȣ��� ��Ű������ ������ �� ����
		p3.play();
		
	}
}