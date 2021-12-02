package kr.s07.note;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * DAO(Data Access Object): �����ͺ��̽��� �����͸� ���������� ȣ���ϰ� �����ϴ� ��ü
 */
public class NoteDAO {
	// �� ����
	public void insertInfo(String name, String passwd, String subject, String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "INSERT INTO note VALUES (note_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
			
			// JDBC ���� 3�ܰ� : PreparedStatment ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺� ���� �߰�
			pstmt.executeUpdate();
			System.out.println("�� �ۼ��� �Ϸ�Ǿ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// ��� ����
	public void selectListInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "SELECT * FROM note ORDER BY num DESC";
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺�κ��� ��� ������ ��� ResultSet�� ��Ƽ� ��ȯ
			rs = pstmt.executeQuery();
			
			System.out.println("�� ��ȣ\t����\t\t�̸�\t�ۼ���");
			String subject, name;
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				subject = rs.getString("subject");
				if(subject.length()>6+6) { // ������ ��� ������ǥ ó��; ���� ������ 60byte(=���� 20��)�̹Ƿ�, ���Ŀ����� \t 2�� ���
					System.out.print(subject.substring(0,4+6)+"..\t");
				}
				else if(subject.length()>7) {
					System.out.print(subject+"\t");
				}
				else {
					System.out.print(subject+"\t\t");
				}
				name = rs.getString("name");
				if(name.length()>6) { // �̸��� ��� ������ǥ ó��
					System.out.print(name.substring(0,4)+"..\t");
				}
				else {
					System.out.print(name+"\t");
				}
				System.out.println(rs.getDate("reg_date")); // ��� ���⿡���� ��, ��, �ϸ� ǥ��
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
	
	// �� �� ����
	public int selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = null;
		
		try {
			// JDBC ���� 1,2�ܰ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "SELECT * FROM note WHERE num=?";
			
			// JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� �����͸� ���ε�
			pstmt.setInt(1, num);
			
			// JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺�κ��� �� ���� ���ڵ带 ��� ResultSet�� ��Ƽ� ��ȯ
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("�� ��ȣ : " + rs.getInt("num"));
				System.out.println("�̸� : " + rs.getString("name"));
				System.out.println("��й�ȣ : " + rs.getString("passwd"));
				System.out.println("���� : " + rs.getString("subject"));
				System.out.println("���� : " + rs.getString("content"));
				System.out.println("�̸��� : " + rs.getString("email"));
				System.out.println("�ۼ��� : " + rs.getString("reg_date")); // �� �� ���⿡���� ��, ��, ��, ��, ��, �ʱ��� ǥ��
			}
			else {
				System.out.println(num + "�� ���� �������� �ʽ��ϴ�!");
				return -1; // ���� �� ��ȣ�� �Է��Ͽ� �� �� ���� �۾��� ������ ���
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return 0; // �ִ� �� ��ȣ�� �Է��Ͽ� ���������� �� �� ���� �۾��� �Ϸ��� ���
	}
	
	// �� ����
	public void updateInfo(int num, String name, String passwd, String subject, String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			if(name.equals("")|passwd.equals("")|subject.equals("")|content.equals("")|email.equals("")) {
				sql = "SELECT * FROM note WHERE num=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, num);
				ResultSet rs = pstmt2.executeQuery();
				if(rs.next()) {
					if (name.equals("")) name = rs.getString("name");
					if (passwd.equals("")) passwd = rs.getString("passwd");
					if (subject.equals("")) subject = rs.getString("subject");
					if (content.equals("")) content = rs.getString("content");
					if (email.equals("")) email = rs.getString("email");
				}
				DBUtil.executeClose(rs, pstmt2, null);
			}
			
			sql = "UPDATE note SET name=?, passwd=?, subject=?, content=?, email=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			pstmt.setInt(6, num);
			int count = pstmt.executeUpdate();
			if(count!=0) System.out.println(num + "�� ���� �����Ǿ����ϴ�.");
			else System.out.println(num + "�� ���� �������� �ʽ��ϴ�!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// �� ����
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "DELETE FROM note WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			if(count!=0) System.out.println(num + "�� ���� �����Ͽ����ϴ�.");
			else System.out.println(num + "�� ���� �������� �ʽ��ϴ�!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}