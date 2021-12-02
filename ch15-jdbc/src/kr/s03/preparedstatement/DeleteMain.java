package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC ���� 1�ܰ� : ����̹� �ε�
			// JDBC ���� 2�ܰ� : Connection ��ü ����
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "DELETE FROM test1 WHERE id=?";
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� ������ ���ε�
			pstmt.setString(1, "star");
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺��� ���� ����
			int count = pstmt.executeUpdate(); // ���� �۾� �� ������ ���� ���� ��ȯ
			System.out.println(count + "�� ���� �����Ͽ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}