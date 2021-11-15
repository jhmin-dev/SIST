public class PrintMain05 {
	public static void main(String[] args) {
		// System.out.printf(포맷문자, 데이터)를 이용한 출력(데이터의 종류를 표시할 수 있는 포맷문자 지원)
		
		// 문자
		System.out.printf("%c", 'A'); // 포맷문자는 "" 처리하며, 데이터가 포맷문자에 전달되어 포맷문자가 출력됨(println은 데이터가 출력됨)
		System.out.printf("%c%n", 'B'); // printf는 기본적으로 줄바꿈되지 않음, 포맷문자에 %n 추가시 줄바꿈됨
		System.out.printf("%6c%n", 'C'); // 6자리 확보하고 오른쪽 정렬
		System.out.printf("%-6c%n", 'D'); // 6자리 확보하고 왼쪽 정렬
		
		System.out.println("========");
		
		// 정수
		System.out.printf("%d%n", 67);
		System.out.printf("%,d원%n", 10000); // 3자리 단위로 쉼표 표시+가장 끝에 단위 원 추가
		System.out.printf("%5d%n", 20); // 5자리 확보하고 오른쪽 정렬
		System.out.printf("%-5d%n", 20); // 5자리 확보하고 왼쪽 정렬
		
		System.out.println("========");

		// 실수
		System.out.printf("%f%n", 35.896); // %f는 기본적으로 소숫점 아래 6자리를 표시
		System.out.printf("%.2f%n", 35.896); // 소숫점 아래 2자리만 표시(셋째 자리에서 반올림)
		System.out.printf("%10.2f%n", 35.896); // 10자리 확보하고 오른쪽 정렬, 소숫점 아래 2자리 표시
		
		System.out.println("========");
		
		// 문자열
		System.out.printf("%s\n", "우주"); // 줄바꿈 문자로 \n도 사용 가능, %n은 포맷문자라 printf에서만 쓰고 \n은 print나 println 등에도 모두 사용 가능
		System.out.printf("%s는 %d점입니다.%n", "점수", 98); // 포맷문자는 여러 개를 한 번에 사용할 수 있고, 각 포맷문자에 대응하는 데이터를 ,로 구분해 순서대로 입력함

		// 논리값
		System.out.printf("%b", true);
	}
}