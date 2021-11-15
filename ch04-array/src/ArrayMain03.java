public class ArrayMain03 {
	public static void main(String[] args) {
		// 배열의 선언 및 생성, 초기화
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		// 비교의 기준값은 배열 안의 값을 사용함; 배열에 포함되어 있지 않은 임의의 값 사용시 최댓값, 최솟값 비교가 제대로 동작하지 않을 수 있음
		int max = score[0]; // 배열의 첫 번째 값으로 최댓값을 초기화
		int min = score[0]; // 배열의 첫 번째 값으로 최솟값을 초기화
		
		for(int i=1;i<score.length;i++) { // 기준값이 배열의 첫 번째 값이므로 자기 자신과의 비교는 생략
			if(score[i] > max) {
				max = score[i];
			}
			if(score[i] < min) {
				min = score[i];
			}
		}
		
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}
}