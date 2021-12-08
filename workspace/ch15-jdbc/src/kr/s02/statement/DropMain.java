package kr.s02.statement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DropMain {
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
			sql = "DROP TABLE test1";
			
			// JDBC 수행 4단계 : SQL문을 실행해서 데이터베이스에서 테이블을 삭제
			stmt.executeUpdate(sql); // executeUpdate() 메서드는 접근한 행의 수를 반환하며, 테이블을 생성하거나 삭제할 때는 0을 반환
			System.out.println("테이블이 정상적으로 삭제되었습니다.");
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