package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectDetailMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�޸� �� �������� ��ȸ�մϴ�.");
			System.out.print("�޸� ��ȣ > ");
			int num = Integer.parseInt(br.readLine());
			
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "SELECT * FROM test2 WHERE num=?";
					
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setInt(1, num); // �� �������� ��ȸ�ϱ� ���ؼ��� ���̺� PRIMARY KEY�� �����Ǿ� �־�� ��
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺�κ��� �� ���� ���ڵ带 ��� ResultSet�� ��Ƽ� ��ȯ
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // �Է��� PRIMARY KEY ���� ���� ���� �ִ� ���; ResultSet Ŀ���� �ʱ� ��ġ�� ù ��° �� ������, next() �޼��带 1ȸ �����ؾ� Ŀ���� ù ��° ������ �̵��ϰ� ��
				System.out.println("��ȣ : " + rs.getInt("num")); // getString()�� ��� ����
				System.out.println("���� : " + rs.getString("title"));
				System.out.println("�ۼ��� : " + rs.getString("name"));
				System.out.println("���� : " + rs.getString("memo"));
				System.out.println("�̸��� : " + rs.getString("email"));
				System.out.println("�ۼ��� : " + rs.getDate("reg_date"));
			}
			else { // �Է��� PRIMARY KEY ���� ���� ���� ���� ���
				System.out.println("�˻��� �����Ͱ� �����ϴ�.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			if(br!=null) try {br.close();} catch(Exception e) {}
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}