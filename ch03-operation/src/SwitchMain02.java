public class SwitchMain02 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("계절 입력 : ");
		String season = input.next(); // next() 함수로 문자열을 입력받아 season에 전달
		
		switch(season) {
		case "봄":
			System.out.println("꽃이 피는 계절");
			break;
		case "여름":
			System.out.println("뜨거운 태양의 계절");
			break;
		case "가을":
			System.out.println("산들바람이 부는 계절");
			break;
		case "겨울":
			System.out.println("눈이 내리는 계절");
			break;
		default:
			System.out.println("계절을 입력하지 않았습니다.");
		}
		
		input.close();
	}
}