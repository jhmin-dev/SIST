public class BreakMain02 {
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				if(j == 3)
					break;
				System.out.println("i = " + i + ", j = " + j);
			}
		}
	}
}