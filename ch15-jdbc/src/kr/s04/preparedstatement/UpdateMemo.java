package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UpdateMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�޸� �����մϴ�.");
			System.out.print("�޸� ��ȣ > ");
			int num = Integer.parseInt(br.readLine());
			System.out.print("���� > ");
			String title = br.readLine();
			System.out.print("�ۼ��� > ");
			String name = br.readLine();
			System.out.print("���� > ");
			String memo = br.readLine();
			System.out.print("�̸��� > ");
			String email = br.readLine();
			
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// �� ���� �Է¹��� ���, ���� ������ ������ �� �ְԲ� SELECT�� ����
			if(title.equals("")|name.equals("")|memo.equals("")|email.equals("")) {
				sql = "SELECT * FROM test2 WHERE num=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, num);
				rs = pstmt2.executeQuery();
				if(rs.next()) {
					if (title.equals("")) title = rs.getString("title");
					if (name.equals("")) name = rs.getString("name");
					if (memo.equals("")) memo = rs.getString("memo");
					if (email.equals("")) email = rs.getString("email");
				}
				DBUtil.executeClose(rs, pstmt2, null); // �ڿ� ������ �ϱ� ���ؼ��� SQL���帶�� ������ PreparedStatement ��ü�� �����ؾ� ��
			}
			
			// SQL�� �ۼ�
			sql = "UPDATE test2 SET title=?, name=?, memo=?, email=? WHERE num=?";
			
			// JDBC ���� 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			pstmt.setInt(5, num);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺��� �� ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� ������ �����߽��ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
			if(br!=null) try {br.close();} catch(Exception e) {}
		}
	}
}