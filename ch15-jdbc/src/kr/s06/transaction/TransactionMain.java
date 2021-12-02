package kr.s06.transaction;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		
		try {
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// Ʈ����� ó���� ���ؼ� �ڵ� COMMIT ����
			conn.setAutoCommit(false);
			
			// SQL�� �ۼ�
			sql = "INSERT INTO test1 VALUES (?, ?)";
			
			// JDBC ���� 3�ܰ�;
			pstmt1 = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt1.setString(1, "test");
			pstmt1.setInt(2, 10);
			
			// JDBC ���� 4�ܰ� : SQL�� ����
			pstmt1.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES (?, ?)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, "COMMIT");
			pstmt2.setInt(2, 20);
			pstmt2.executeUpdate();
			
			// Ʈ����� �׽�Ʈ�� ���� ������ �ִ� SQL�� �ۼ�
			sql = "INSERT INTO test1 VALUES (?, ?";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, "ROLLBACK");
			pstmt3.setInt(2, 30);
			pstmt3.executeUpdate();
			
			// ��� SQL���� ���������� ó���Ǹ� COMMIT
			conn.commit();
			System.out.println("�۾� �Ϸ�");	
		}
		catch(Exception e) {
			e.printStackTrace();
			
			// ���� �߻��ϸ� ROLLBACK
			try {
				conn.rollback();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		finally {
			DBUtil.executeClose(null, pstmt1, null);
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, conn); // PreparedStatement ��ü�� ���� ���� ��, ������ ���� ������ �߿����� �ʰ� Connection ��ü�� �������� �����ϸ� ��
		}
	}
}