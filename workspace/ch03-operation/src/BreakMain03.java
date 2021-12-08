public class BreakMain03 {
	public static void main(String[] args) {
		// 다중 반복문에서 break label 사용
		exit_for: // label 지정
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				if(j == 3)
					break exit_for; // break 다음에 label을 명시하면 label이 지정된 for문을 빠져나감
				System.out.println("i = " + i + ", j = " + j);
			}
		}
	}
}