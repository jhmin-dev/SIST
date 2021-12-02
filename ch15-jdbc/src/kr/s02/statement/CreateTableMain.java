package kr.s02.statement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTableMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "scott";
		String db_password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		// �����ͺ��̽� �����ÿ��� �޼��忡���� throws ���� ���ο� ������� �׻� try~catch~finally���� ����Ͽ� �ڿ� ����
		try {
			// JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName(db_driver);
			// JDBC ���� 2�ܰ� : Connection ��ü ����(ID, ��й�ȣ ����)
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			
			System.out.println("test1 ���̺��� �����մϴ�.");
			
			// JDBC ���� 3�ܰ� : Statement ��ü ����
			stmt = conn.createStatement();
			
			/*
			 * ���̺��� �����ϴ� SQL��
			 * ������ ������ ���̺����� �ߺ��Ǹ� ������ �߻��ϱ� ������ ���� ���������� �� ���� �����ؾ� ��
			 */
			sql = "CREATE TABLE test1 (id VARCHAR2(10), age NUMBER)"; // SQL���� �����ݷ����� �����ϸ� ����
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� �����ͺ��̽��� ���̺��� ����
			stmt.executeUpdate(sql);
			
			System.out.println("���̺��� ���������� �����Ǿ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����, ������ ������ �������� ����
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
}