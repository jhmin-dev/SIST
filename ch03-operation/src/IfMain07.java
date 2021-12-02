public class IfMain07 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 생년월일을 입력하고 만 나이를 출력하는 프로그램을 작성하시오.
		 * 만 나이 = (현재 연도 - 생년) - (생일이 지났으면 0, 생일이 지나지 않았으면 1)
		 * 
		 * [출력 예시]
		 * 연도 입력 : 2001
		 * 월 입력 : 10
		 * 일 입력 : 20
		 * 만 나이는 ?
		 */
		int thisYear = 2021;
		int thisMonth = 11;
		int thisDate = 1;
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("생년월일을 입력하세요.");
		
		int year, month, date;
		
		while(true) { // 연도 루프
			System.out.print("연도 입력 : ");
			year = input.nextInt();
			if(year>1900) {
				while(true) { // 월 루프
					System.out.print("월 입력 : ");
					month = input.nextInt();
					if(month>=1&&month<=12) {
						while(true) { // 일 루프
							System.out.print("일 입력 : ");
							date = input.nextInt();
							if(month==2){
								if(date>=1&&date<=28) {
									break;	
								}
								else {
									System.out.println("일은 1부터 28까지만 가능합니다.");
								}
							}
							else if((month%2==0&&month<=6)||(month%2==1&&month>=9)) {
								if(date>=1&&date<=30) {
									break;	
								}
								else {
									System.out.println("일은 1부터 30까지만 가능합니다.");
								}
							}
							else {
								if(date>=1&&date<=31) {
									break;	
								}
								else {
									System.out.println("일은 1부터 31까지만 가능합니다.");
								}
							}
						}
						break; // 월 루프 탈출
					}
					else {
						System.out.println("월은 1부터 12까지만 가능합니다.");
					}
				}
				break; // 연도 루프 탈출
			}
			else {
				System.out.println("연도를 잘못 입력하셨습니다");
			}
		}
		
		int age=thisYear-year;
		if(thisMonth<month) { // 생일 지나지 않음(월)
			age-=1;
		}
		else if(thisMonth==month) {
			if(thisDate<date) { // 생일 지나지 않음(일)
				age-=1;
			}
		}
		System.out.println("만 나이는 ? "+age);
		
		input.close();
	}
}