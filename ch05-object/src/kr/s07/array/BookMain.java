package kr.s07.array;

public class BookMain {
	public static void main(String[] args) {
		// Book 객체를 요소로 갖는 배열 선언 및 생성
		Book[] bookArray = new Book[3]; // 길이 3인 배열이 생성되고, 각 요소는 null로 초기화됨; 객체가 아직 생성되지 않아 주소가 없다는 의미
		int total = 0;
		
		// Book 객체를 3개 생성하여 배열에 저장
		bookArray[0] = new Book("IT", "Java", 5000, 0.05); // 생성된 객체의 주소가 배열의 0번 인덱스에 저장됨
		bookArray[1] = new Book("미술", "고흐", 4000, 0.03);
		bookArray[2] = new Book("음악", "아리랑", 6000, 0.06);
		
		// 배열의 요소 출력; 참조값이 출력됨
		System.out.println(bookArray[0]);
		System.out.println(bookArray[1]);
		System.out.println(bookArray[2]);
		
		// 반복문을 이용해 배열에 접근해서 객체를 호출하고 객체의 멤버 변수에 저장된 데이터 출력
		for(int i=0;i<bookArray.length;i++) {
			System.out.print(bookArray[i].getCategory() + "\t"); // 객체의 멤버 변수는 private이라 직접 접근 불가
			System.out.print(bookArray[i].getName() + "\t");
			System.out.printf("%,d원\t", bookArray[i].getPrice());
			System.out.printf("%.2f%%\n", bookArray[i].getDiscount()); // printf에서 %를 일반문자로 출력하려면 %% 사용
		}
		
		System.out.println();
		
		// 확장 for문
		for(Book book : bookArray) { // 참조 자료형은 클래스명 Book을 적고 참조 변수 book을 선언
			System.out.printf("%s\t", book.getCategory());
			System.out.printf("%s\t", book.getName());
			System.out.printf("%,d원\t", book.getPrice());
			System.out.printf("%.2f%%\n", book.getDiscount());
			// 합계
			total += book.getPrice();
		}
		// 합계 출력
		System.out.printf("가격의 합 : %,d원", total);
	}
}