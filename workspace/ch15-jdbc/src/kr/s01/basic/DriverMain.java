package kr.s01.basic;

public class DriverMain {
	public static void main(String[] args) {
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver"); // 입력한 문자열을 이름으로 갖는 클래스를 찾아 메모리에 로드
			System.out.println("드라이버가 정상적으로 설치되었습니다.");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}