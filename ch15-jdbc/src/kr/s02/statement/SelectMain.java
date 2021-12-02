package kr.s02.statement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "scott";
		String db_password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			Class.forName(db_driver);
			// JDBC 수행 2단계 : Connection 객체 생성(ID, 비밀번호 인증)
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			// JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL문 작성
			sql = "SELECT * FROM test1";
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 행을 전달받아서 결과 집합을 만들고, ResultSet 객체에 담아서 반환
			rs = stmt.executeQuery(sql);

			System.out.println("ID\t나이");
			while(rs.next()) { // ResultSet에서 결과 집합의 행에 접근할 때 커서를 사용하는데, next() 메서드는 커서를 다음 행으로 이동시키고 다음 행이 존재하면 true 반환
				// 컬럼명을 통해 데이터를 반환
				System.out.print(rs.getString("id")); // getString() 메서드는 입력한 컬럼명과 매칭되어 있는 데이터를 String 자료형으로 반환
				System.out.print("\t");
				System.out.println(rs.getInt("age")); // getInt() 메서드는 입력한 컬럼명과 매칭되어 있는 데이터를 int 자료형으로 반환
				
				// 컬럼 인덱스를 통해 데이터를 반환
				// System.out.print(rs.getString(1)); // SELECT문에서 전체(*)를 반환한 경우 테이블 생성시의 컬럼 인덱스를 사용할 수 있지만, 그 외의 경우 컬럼 인덱스가 변동될 수 있으므로 주의
				// System.out.print("\t");
				// System.out.println(rs.getInt(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 객체 생성 순서의 역순으로 자원 정리
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}