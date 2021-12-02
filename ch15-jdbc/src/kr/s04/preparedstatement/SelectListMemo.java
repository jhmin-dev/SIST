package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectListMemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "SELECT * FROM test2 ORDER BY num DESC"; // �ֽű��� ��ܿ� ���Բ� ����; reg_date�� �̿� ����������, �Ϲ������� ��Ͽ����� PRIMARY KEY�� �̿��Ͽ� ����
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺�κ��� ��� ������ ��� ResultSet�� ��Ƽ� ��ȯ
			rs = pstmt.executeQuery();
			
			System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���"); // ���� �� �̸����� �� ������������ ��ȸ�ϰ�, ��Ͽ����� ����
			while(rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getDate("reg_date")); // �÷��� �ڷ����� DATE�� ���, getDate() �޼���� getString() �޼��� ��� ��� ����
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}