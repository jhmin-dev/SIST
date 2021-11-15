package kr.s02.method;

public class MethodMain03 {
	// Variable Arguments
	public void argTest(int ... n) { // 자료형을 명시하고 ... 후에 인자를 명시하면 가변 인자가 됨
		for(int i=0;i<n.length;i++) {
			System.out.println("n[" + i + "] : " + n[i]);
		}
		System.out.println("========");
	}
	
	public static void main(String[] args) {
		MethodMain03 me = new MethodMain03();
		me.argTest(); // 인자를 입력하지 않은 경우, 길이 0인 빈 배열이 생성되어 for문은 동작하지 않음
		me.argTest(10); // 10이 n에 직접 전달되는 것이 아니라, n이 가리키는 길이 1인 배열의 요소가 됨
		me.argTest(20, 30);
		me.argTest(40, 50, 60);
	}
}