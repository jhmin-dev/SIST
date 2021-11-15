package kr.s07.finaltest;
// 클래스에 final을 명시하면 상속이 불가능함
// final class Me2 {
class Me2 {
	int num = 200;
}

public class FinalMain03 extends Me2 {
	public static void main(String[] args) {
		FinalMain03 fm = new FinalMain03();
		System.out.println(fm.num);
	}
}