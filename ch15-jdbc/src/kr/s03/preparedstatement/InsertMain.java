package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC ���� 1�ܰ� : ����̹� �ε�
			// JDBC ���� 2�ܰ� : Connection ��ü ����
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			// sql = "INSERT INTO test1 VALUES ('star', 50)"; // (Statement ��ü ���ÿ� ����������) SQL���� �����͸� ���� �Է��ϴ� ��ĵ� ����������, ���� �Է� ����� ����ڷκ��� �����͸� �Է¹޴� ��� ��ŷ ������ �����Ƿ� �������� ����
			sql = "INSERT INTO test1 VALUES (?, ?)"; // �����͸� ���� �ڸ��� ���ε� ���� ?�� ���
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setString(1, "st'ar"); // ù ��° ?�� �����͸� ����; �ڷ����� �����͸� ������ �÷�(=ù ��° �÷�=id)�� �ڷ����� ����
			pstmt.setInt(2, 50); // �� ��° ?�� �����͸� ����; �ڷ����� �����͸� ������ �÷�(=�� ��° �÷�=age)�� �ڷ����� ����
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺� ���� ����
			int count = pstmt.executeUpdate(); // ���� �۾� �� ������ ���� ���� ��ȯ
			System.out.println(count + "�� ���� �����߽��ϴ�.");
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