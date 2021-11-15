package kr.s01.exception;

public class ExceptionMain06 {
	// throw를 이용한 인위적 예외 발생
	public void methodA(String[] n) throws Exception {
		if(n.length>0) { // 입력한 값이 있는 경우
			for(String s : n) {
				System.out.println(s);
			}
		}
		else { // 입력한 값이 없는 경우
			throw new Exception("입력한 데이터가 없습니다."); // 예외 객체를 생성하여 던짐(=조건을 만족하지 않는 경우에 catch 블럭으로 이동시킴); throw를 명시하지 않으면 생성된 예외 객체가 메서드와 관련 없는(=예외 발생이 아닌) 것으로 인식됨
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain06 ex = new ExceptionMain06();
		try {
			ex.methodA(args);
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); // 예외 객체에 명시한 메시지를 출력
		}
	}
}