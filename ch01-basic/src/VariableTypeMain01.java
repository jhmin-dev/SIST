public class VariableTypeMain01 {
	public static void main(String[] args) {
		System.out.println("====논리형====");
		// 논리형: 크기 1byte, 표현 범위 true, false
		boolean b = true; // 변수에는 자료형 맞는 데이터만 넣을 수 있음(문자열은 논리형에 저장 불가)
		System.out.println("b = " + b);
		
		System.out.println("====문자형====");
		// 문자형: 크기 2byte, 표현 범위 0 ~ 65,535(문자를 숫자로 변환해 저장)
		// 문자형의 크기가 1byte인 경우 영문, 숫자와 일부 특수문자만 처리 가능(ASCII)하지만 2byte인 경우 한글, 한자 등도 처리 가능(Unicode)
		char c1 = 'A';
		System.out.println("c1 : " + c1);
		char c2 = 65; // A의 아스키 코드 값을 대입; 영문의 경우 유니코드 안에 아스키 코드가 포함되어 있어 둘 다 사용 가능
		System.out.println("c2 : " + c2); // A가 출력됨
		char c3 = '\u0041'; // A의 유니코드 값(16진수, 역슬래시u로 유니코드임을 표시) 대입
		System.out.println("c3 : " + c3);
		char c4 = '자';
		System.out.println("c4 : " + c4);
		char c5 = '\uc790'; // 자의 유니코드 값 대입
		System.out.println("c5 : " + c5); // 자가 출력됨
		
		System.out.println("====정수형====");
		// byte: 크기 1byte, 표현 범위 -128 ~ 127
		// byte의 경우 표현 범위가 좁아 연산에는 잘 사용하지 않지만 입출력에 사용함
		byte b1 = 127; // 128 등 범위 초과한 값은 대입 불가
		System.out.println(" b1 : " + b1);
		// short: 크기 2byte, 표현 범위 -32,768 ~ 32,767
		short s1 = -32768; // 32768 등 범위 초과한 값은 대입 불가
		System.out.println(" s1 : " + s1);
		// int: 크기 4byte, 표현 범위 -2,147,483,648 ~ 2,147,483,647
		// int의 경우 정수의 기본 자료형으로 정수 자료형들 중 가장 많이 사용됨
		int n1 = 1000;
		System.out.println("n1 : " + n1);
		// long: 크기 8byte
		// 은행 프로그램 등 큰 단위 다뤄야 할 때 사용함, 유튜브 조회수의 경우 int로 표현하다가 21억 뷰를 초과하는 영상이 나오면서 long으로 바뀜
		long lg = 1000L; // long 변수에 1000 대입시 자바는 정수 표현의 기본형인 int로 인식 후 long으로 변환함; 숫자 뒤에 l이나 L을 붙이면 처음부터 long으로 인식함
		System.out.println("lg : " + lg);
		
		System.out.println("====실수형====");
		// float: 크기 4byte
		float f1 = 4.5f; // 소숫점 가진 값의 경우 자바가 실수 표현의 기본형인 double로 인식하여 float 변수에 더 큰 자료형의 값을 대입하지 못하고 오류가 발생함; 숫자 뒤에 f나 F를 붙이면 처음부터 float으로 인식함
		System.out.println("f1 : " + f1);
		// double: 크기 8byte, 실수의 기본 자료형으로 float보다 더 정밀함
		double d1 = 9.8;
		System.out.println("d1 = " + d1);

		System.out.println("====문자열 표시====");
		// 문자열은 기본 자료형이 아니지만 자주 사용하기 때문에 변수 선언하는 법을 미리 언급
		String str = "Hello World!"; // 기본 자료형은 소문자로 시작하지만, 참조 자료형은 대문자로 시작함
		System.out.println("str : " + str);
	}
}