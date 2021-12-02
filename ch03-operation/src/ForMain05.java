public class ForMain05 {
	public static void main(String[] args) {
		// 다중 for문
		for(int dan=2;dan<=9;dan++) { // 단
			System.out.println("** " + dan + "단 **");
			for(int i=1;i<=9;i++) { // 곱해지는 수
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
		}
	}
}