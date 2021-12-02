package kr.s05.callablestatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;

public class CallableStatementMain {
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = null;
		
		try {
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// ���ν��� ȣ�� ���� �ۼ�
			sql = "{call adjust(?, ?)}"; // ���ڿ� ���� ���� �Է����� �ʰ� ���ε� ���� ? ���
			
			// JDBC ���� 3�ܰ� : CallableStatement ��ü ����
			cstmt = conn.prepareCall(sql);
			// ?�� �����͸� ���ε�
			cstmt.setString(1, "CALL");
			cstmt.setFloat(2, 0.06f);
			
			// JDBC ���� �ܰ� : ���ν��� ����
			cstmt.executeUpdate();
			System.out.println("�޿� ������ �����Ǿ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(cstmt, conn);
		}
	}
}