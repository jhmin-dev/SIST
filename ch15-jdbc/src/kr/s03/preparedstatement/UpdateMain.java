package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC ���� 1�ܰ� : ����̹� �ε�
			// JDBC ���� 2�ܰ� : Connection ��ü ����
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "UPDATE test1 SET age=? WHERE id=?"; // �����͸� ���� �ڸ��� ���ε� ���� ?�� ���
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� ������ ���ε�
			pstmt.setInt(1, 19); // ù ��° ?�� �����͸� ����; �ڷ����� �����͸� ������ �÷�(=age)�� �ڷ����� ����
			pstmt.setString(2, "star"); // �� ��° ?�� �����͸� ����; �ڷ����� �����͸� ������ �÷�(=id)�� �ڷ����� ����
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺��� ���� ����
			int count = pstmt.executeUpdate(); // ���� �۾� �� ������ ���� ���� ��ȯ
			System.out.println(count + "�� ���� ������ �����߽��ϴ�.");			
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