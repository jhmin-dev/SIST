public class CastMain02 {
	public static void main(String[] args) {
		System.out.println("====명시적 형변환(강제 형변환)====");
		// 큰 자료형에서 작은 자료형으로 강등이 일어나는 형태
		// 정보의 손실이 발생할 수 있음
		
		byte b1 = 127;
		byte b2 = 127;
		// 캐스트 연산자를 이용하여 int인 결과 값 b1 + b2를 byte로 강제 형변환함; 결과 값이 byte의 표현 범위를 벗어나기 때문에 정보의 손실이 일어남
		byte result1 = (byte)(b1 + b2);
		System.out.println("result1 = " + result1);
		
		short s1 = 1000;
		short s2 = 2000;
		// 캐스트 연산자를 이용하여 int인 결과 값 s1 + s2를 short로 강제 형변환함; 결과 값이 short의 표현 범위 안에 있기 때문에 정보의 손실이 없음
		short result2 = (short)(s1 + s2);
		System.out.println("result2 = " + result2);
		
		int in1 = 2345;
		float f1 = 25.67f;
		// 캐스트 연산자를 이용하여 float인 f1을 int로 강제 형변환 후 in1과 연산함; 소숫점 이하 자리에 대한 정보가 손실됨(버림 처리, 반올림하려면 Math.round() 함수 이용)
		int result3 = in1 + (int)(f1);
		System.out.println("result3 = " + result3);
		
		int in2 = 1234;
		long lg1 = 1234L;
		// 캐스트 연산자를 이용하여 long인 lg1을 int로 강제 형변환 후 int2와 연산함; 정보의 손실은 발생하지 않음
		int result4 = in2 + (int)(lg1);
		System.out.println("result4 = " + result4);
	}
}