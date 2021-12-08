package kr.s01.a;
public class MethodMain01 {
	// 반환하는 데이터가 있는 경우
	public int add(int a, int b){
		return a + b;
	}
	
	// 반환하는 데이터가 없는 경우
	public void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) { // main 메서드는 반환하는 데이터가 없는 void형 메서드
		// 객체 선언 및 생성
		MethodMain01 method = new MethodMain01(); // 생성자는 명시하지 않아도 호출 가능
		
		// 반환하는 데이터가 있는 메서드 호출
		int result = method.add(5, 8);
		System.out.println("result = " + result);
		
		// 반환하는 데이터가 없는 메서드 호출
		method.print("가을"); // void형 메서드는 데이터가 없으므로 변수에 대입할 수 없음
	}
}