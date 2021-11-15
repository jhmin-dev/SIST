package kr.s06.animal;

public class AnimalMain {
	public static void main(String[] args) {
		// 기본 생성자를 이용하여 객체 생성
		Animal a1 = new Animal();
		// 기본 정보 세팅
		a1.setName("기린");
		a1.setAge(10);
		a1.setFly(false);
		// 정보 출력
		System.out.println("이름 : " + a1.getName());
		System.out.println("나이 : " + a1.getAge());
		System.out.println("비행 여부 : " + (a1.isFly() ? "가능" : "불가능")); // 삼항 연산자를 이용해서 true일 때 가능, false일 때 불가능 출력; 우선순위 문제가 있으니 소괄호 필요
		
		System.out.println();
		
		// 생성자로 기본 정보 세팅
		Animal a2 = new Animal("기러기", 3, true);
		// 정보 출력
		System.out.println("이름 : " + a2.getName());
		System.out.println("나이 : " + a2.getAge());
		System.out.println("비행 여부 : " + printFly(a2.isFly())); // 같은 클래스의 static 메서드는 클래스명 명시하지 않고 호출 가능
	}
	// 삼항 연산자 이용하는 메서드 만들기; 메서드 위치는 main 위, 아래 무관
	private static String printFly(boolean fly) { // 객체 생성 없이 호출 가능
		return fly ? "가능" : "불가능";
	}
}