public class ArrayMain13 {
	public static void main(String[] args) {
		// 2차원 배열 선언 및 생성
		int[][] score = {
			{98, 99, 80}, 
			{97, 85, 70}, 
			{84, 88, 95},
			{79, 95, 90},
			{88, 85, 80},
		};
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		for(int i=0;i<score.length;i++) { // 행
			int sum = 0; // 총점을 각 행마다 초기화 후 누적시키기 위해
			System.out.print(i + 1 + "\t"); // 번호 출력
			for(int j=0;j<score[i].length;j++) { // 열
				sum += score[i][j]; // 총점
				System.out.print(score[i][j] + "\t"); // 과목 성적 출력
			}
			System.out.println(sum + "\t" + sum / score[i].length); // 총점, 평균 출력
		}
	}
}