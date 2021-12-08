public class SwitchMain01 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("정수형 데이터 입력 : ");
		int a = input.nextInt();
		
		switch(a) { // int인 a를 인자값으로 사용
		case 1:
			System.out.println("1 입력");
			break; // {} 블럭 탈출; 생략시 다음 케이스의 수행문까지 실행함
		case 2:
			System.out.println("2 입력");
			break;
		case 3:
			System.out.println("3 입력");
			break;
		default: // if문에서의 else 역할; 마지막이므로 break 생략 가능
			System.out.println("1, 2, 3이 아닌 숫자가 입력됨");
		}
		
		input.close();
	}
}