public class ArrayMain12 {
	public static void main(String[] args) {
		// 2차원 배열 선언 및 생성, 초기화
		int[][] array = {{10, 20, 30, 40}, {20, 30, 40, 50}}; // 2행 4열
		
		// 반복문을 이용한 출력
		for(int i=0;i<array.length;i++) { // 행
			for(int j=0;j<array[i].length;j++) { // 열
				System.out.print(array[i][j] + "\t");
			}
			System.out.println(); // 단순 줄바꿈(행이 바뀌었음을 나타내기 위해)
		}
		
	}
}