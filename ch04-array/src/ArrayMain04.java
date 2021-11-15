public class ArrayMain04 {
	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50};
		
		// 일반 for문
		for(int i=0;i<array.length;i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}
		
		// 확장 for문(=개선된 루프)
		for(int num : array) { // 배열 array의 요소를 변수 num에 저장; 인덱스를 사용하지 않고 직접 배열의 각 데이터에 접근
			System.out.print(num + "\t");
		}
	}
}