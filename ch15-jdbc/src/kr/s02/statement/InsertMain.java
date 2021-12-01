package kr.s02.statement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "scott";
		String db_password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			
			// JDBC 수행 2단계 : Connection 객체 생성(ID, 비밀번호 인증)
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			
			// JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL문 작성
			sql = "INSERT INTO test1 (id, age) VALUES ('star', 10)";
			
			// JDBC 수행 4단계 : SQL문을 실행해서 하나의 행을 삽입
			int count = stmt.executeUpdate(sql); // 삽입 작업 후 삽입한 행의 수를 반환
			System.out.println(count + "개의 행이 삽입되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}