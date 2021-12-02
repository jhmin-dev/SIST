public class ArrayMain09 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 1) 10, 20, 30, 40, 50을 초기값으로 갖는 1차원 배열을 test 이름으로 선언, 생성, 초기화하시오.
		 * 2) 반복문을 이용하여 출력하시오.
		 * 3) 확장 for문을 이용하여 출력하시오.
		 * 4) 인덱스 3의 데이터를 100으로 변경하시오.
		 * 5) 마지막 요소의 값을 200으로 변경하시오.
		 * 6) 반복문을 사용하여 모든 요소의 값을 0으로 초기화하시오.
		 * 7) 홀수 인덱스에 10, 짝수 인덱스에 20을 저장하시오.
		 * 8) 모든 요소의 총합과 평균(총합을 요소의 수로 나눔) 구하고 출력하시오.
		 */
		// 1
		int[] test={10, 20, 30, 40, 50};
		// 2
		for(int i=0;i<test.length;i++) {
			System.out.println(test[i]);
		}
		System.out.println("========");
		// 3
		for(int num:test) {
			System.out.print(num+"\t");
		}
		System.out.println("\n========");
		// 4
		test[3]=100;
		// 5
		test[test.length-1]=200;
		for(int num:test) {
			System.out.print(num+"\t");
		}
		System.out.println("\n========");
		// 6
		for(int i=0;i<test.length;i++) {
			test[i]=0;
			System.out.println(test[i]);
		}
		System.out.println("========");
		// 7
		for(int i=0;i<test.length;i++) {
			if(i%2==0) {
				test[i]=20;
			}
			else {
				test[i]=10;
			}
			System.out.println(test[i]);
		}
		System.out.println("========");
		// 8
		int sum=0;
		float avg=0.0f;
		for(int num:test) {
			sum+=num;
		}
		avg=sum/(float)test.length;
		System.out.printf("총합 = %d\n평균 = %.2f", sum, avg);
	}
}