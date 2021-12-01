package kr.s01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle로 연결, Type 4 드라이버인 thin 사용, @호스트명(=IP 주소나 도메인으로 대체 가능), 포트 번호 1521, Oracle Database 설치시 부여되는 SID명 XE
		String db_id = "scott";
		String db_password = "tiger";
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			// JDBC 수행 2단계 : Connection 객체 생성
			Connection conn = DriverManager.getConnection(db_url, db_id, db_password);
			System.out.println("Connection 객체가 생성되었습니다.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}