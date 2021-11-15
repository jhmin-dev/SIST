public class ArrayMain11 {
	public static void main(String[] args) {
		// 2차원 배열 선언
		int test[][];
		
		// 2차원 배열 생성
		test = new int[2][3]; // 2행 3열
		
		// 2차원 배열의 초기화
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		
		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;
		
		// 배열의 요소 출력
		System.out.println(test[0][0]);
		System.out.println(test[0][1]);
		System.out.println(test[0][2]);
		System.out.println(test[1][0]);
		System.out.println(test[1][1]);
		System.out.println(test[1][2]);
		
		System.out.println("========");
		
		for(int i=0;i<test.length;i++) { // 행
			for(int j=0;j<test[i].length;j++) { // 열
				System.out.println("test[" + i + "][" + j + "]: " + test[i][j]);
			}
		}
		
		// 2차원 배열 선언 및 생성
		int[][] test2 = new int[3][5]; // 3행 5
		
		// 2차원 배열 선언 및 생성(명시적), 초기화
		int[][] test3 = new int[][] {{100, 200, 300}, {400, 500, 600}};
		int[][] test4 = new int[][] { // 가독성을 위해
			{100, 200, 300}, 
			{400, 500, 600}
		};
	}
}