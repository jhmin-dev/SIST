package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String title, name, memo, email; // try �������� ����ϴ� �����̹Ƿ� try �� �ȿ��� �����ص� ����
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�޸� �Է��մϴ�.");
			System.out.print("���� > ");
			title = br.readLine();
			System.out.print("�̸� > ");
			name = br.readLine();
			System.out.print("�޸� > ");
			memo = br.readLine();
			System.out.print("�̸��� > ");
			email = br.readLine();
			
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "INSERT INTO test2 (num, title, name, memo, email, reg_date) " // �� ���ڿ��� �������� ���� �и� �� + �����ڷ� ����
				+ "VALUES(test2_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)"; // �������� ���� �� ��ȯ�� ���� ��¥ ��ȯ�� ��ɾ�� ó���Ǿ�� �ϹǷ� ���ε� ���� ��� �Ұ�
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺� ���� ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �����Ͽ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
			if(br!=null) try {br.close();} catch(Exception e) {} // �ַܼκ��� �Է¹޴� ��쿡�� ���� ����
		}
	}
}