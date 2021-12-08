public class ArrayMain02 {
	public static void main(String[] args) {
		// 배열 선언 및 생성(암시적 배열 생성), 초기화
		int[] score = {100,88,88,100,90}; // score.length는 5로 저장됨
		int sum = 0;
		float avg = 0.0f;
		
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		avg = sum / (float)score.length; // 분모에 배열의 길이를 이용하게 되면, 배열에 요소를 추가하거나 삭제하더라도 분모를 수정할 필요 없음
		
		System.out.printf("총점 : %d\n평균 : %.2f", sum, avg);
	}
}