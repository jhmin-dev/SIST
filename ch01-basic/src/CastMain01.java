public class CastMain01 {
	public static void main(String[] args) {
		System.out.println("====묵시적 형변환(자동 형변환)====");
		// 작은 자료형에서 큰 자료형으로 승격이 일어나는 형태
		// 정보의 손실이 전혀 없으며 자동적으로 발생
		
		byte b1 = 127; // 8bit
		byte b2 = 127;
		// 32bit 미만 정수형 데이터를 연산하면 자동으로 32bit으로 승격됨; 결과가 자료형의 표현 범위를 벗어날 가능성이 높기 때문에 데이터를 보호하기 위해 자동 형변환하는 것
		int result1 = b1 + b2;
		System.out.println("result1 = " + result1);
		
		short s1 = 32767; // 16bit
		short s2 = 32767;
		// byte나 short끼리의 연산이라도 결과 담는 변수를 byte나 short로 선언할 경우 오히려 오류 발생
		int result2 = s1 + s2;
		System.out.println("result2 = " + result2);

		int in1 = 1000;
		long lg1 = 2000L;
		long result3 = in1 + lg1; // in1의 자료형이 int에서 long으로 자동 형변환됨
		System.out.println("result3 = " + result3);
		
		double du1 = 5.3;
		int in2 = 20;
		double result4 = du1 + in2; // in2의 자료형이 int에서 double로 자동 형변환됨
		System.out.println("result4 = " + result4);
	}
}