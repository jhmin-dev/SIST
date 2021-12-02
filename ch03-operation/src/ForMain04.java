public class ForMain04 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("단을 입력하세요 : ");
		int dan = input.nextInt();
		
		System.out.println(dan + "단");
		System.out.println("========");
		
		if(dan<=9&&dan>=1) {
			for(int i=1;i<=9;i++) {
				System.out.println(dan + " * " + i + " = " + dan * i); // 곱셈은 덧셈보다 우선순위가 높기 때문에 소괄호 없어도 곱셈 먼저 실행하고 문자열로 연결함
			}
		}
		else if(dan>9){
			for(int i=1;i<=dan;i++) {
				System.out.println(dan + " * " + i + " = " + dan * i);
			}
		}
		else {
			System.out.println("양의 정수를 입력하세요.");
		}
		input.close();
	}
}