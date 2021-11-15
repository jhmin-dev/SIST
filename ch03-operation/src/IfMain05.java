public class IfMain05 {
	public static void main(String[] args) {
		int a = 10;
		float b = 10.0f;
		
		if(a == b) { // a가 float으로 형변환됨
			System.out.println("10과 10.0f는 같다!");
		}
		
		char c = '0';
		int d = 0;
		
		if(c != d) { // '0'이 int로 형변환되면 48이 됨
			System.out.println("'0'과 0은 같지 않다.");
		}
		
		char e = 'A';
		int f = 65;
		
		if(e == f) {
			System.out.println("'A'와 65는 같다.");
		}
	}
}