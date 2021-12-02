package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeleteMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�޸� �����մϴ�.");
			System.out.print("�޸� ��ȣ > ");
			int num = Integer.parseInt(br.readLine());
			
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "DELETE FROM test2 WHERE num=?";
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setInt(1, num);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺��� ���� ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �����Ǿ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			if(br!=null) try {br.close();} catch(Exception e) {}
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}