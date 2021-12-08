package kr.s02.statement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteMain {
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
			// JDBC 수행 2단계 : Connection 객체 생성
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			// JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL문 작성
			sql = "DELETE FROM test1 WHERE id='star'";
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행을 삭제
			int count = stmt.executeUpdate(sql); // 삭제 작업 후 삭제한 행의 수를 반환
			System.out.println(count + "개 행을 삭제하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}