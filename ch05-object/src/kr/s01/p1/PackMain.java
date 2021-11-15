package kr.s01.p1;

import kr.s01.p2.PackTwo; // 호출하고자 하는 클래스의 패키지를 등록

public class PackMain {
	public static void main(String[] args) {
		// kr.s01.p1.PackOne p1 = new kr.s01.p1.PackOne();
		PackOne p1 = new PackOne(); // 같은 패키지의 클래스는 호출시 패키지명을 생략할 수 있음
		p1.study();
		
		kr.s01.p2.PackTwo p2 = new kr.s01.p2.PackTwo();
		p2.play();
		
		PackTwo p3 = new PackTwo(); // 등록했기 때문에 호출시 패키지명을 생략할 수 있음
		p3.play();
		
	}
}