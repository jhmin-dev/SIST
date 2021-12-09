package miniproject;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {
	// ��ȭ ���
	public void insertMovie(MovieVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO m_movie(mo_num,mo_title,mo_date,mo_time,mo_seats,mo_ban)"
					+ "VALUES(m_movie_seq.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMo_title());
			pstmt.setString(2, vo.getMo_date());
			pstmt.setString(3, vo.getMo_time());
			pstmt.setInt(4, vo.getMo_seats());
			pstmt.setInt(5, vo.getMo_ban());
			pstmt.executeUpdate();
			System.out.println("��ȭ����� �Ǿ����ϴ�.");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null,pstmt,conn);
		}
	}

	// ��ȭ ��� Ȯ��
	public void selectListMovie() {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn=DBUtil.getConnection();
			sql = "SELECT mo_num,mo_title,mo_date,mo_time,mo_ban,mo_seats FROM m_movie "
					+ "LEFT OUTER JOIN(SELECT * FROM m_reservation WHERE re_num=1) "
					+ "USING(mo_num) ORDER BY mo_num DESC ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			System.out.println("===========================================================");
			System.out.println("��ȭ��ȣ\t��ȭ����\t��������\t����\t\t�󿵽ð�\t�¼�");
			System.out.println("===========================================================");

			while(rs.next()) {
				System.out.print(rs.getInt("mo_num")+"\t");
				System.out.print(rs.getString("mo_title")+"\t");
				System.out.print(rs.getInt("mo_ban")+"\t");
				System.out.print(rs.getString("mo_date")+"\t");
				System.out.print(rs.getString("mo_time")+"\t");
				System.out.println(rs.getInt("mo_seats")+"\t");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt,conn);
		}
	}
	
	// ��ȭ ����
	public void updateMovie(MovieVO movie) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();

			sql = "UPDATE movie SET mo_title=?,"
					+ "mo_date=?, mo_time=? mo_seats=? WHERE mo_num=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1,movie.getMo_num());
			pstmt.setString(2, movie.getMo_title());
			pstmt.setString(3,movie.getMo_date());
			pstmt.setString(4,movie.getMo_time());
			pstmt.setInt(5 ,movie.getMo_seats());

			int count = pstmt.executeUpdate();
			System.out.println(count+"���� ��ȭ ������ �����Ǿ����ϴ�.");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null,pstmt,conn);
		}

	}
	
	// ��ȭ ����
	public void deleteMovie(int mo_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "DELETE FROM m_movie WHERE mo_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mo_num);
			int count = pstmt.executeUpdate();
			System.out.println(count+"���� ��ȭ�� �����Ͽ����ϴ�.");
		}
		catch(Exception e) {
			if(e.getMessage().trim().endsWith("child record found")) { // �����Ϸ��� mo_num ���� m_reservation ���̺��� �����ǰ� �־� ������ ������ ���
				System.out.println("�ش� ��ȭ�� �����ڰ� �����Ƿ� ������ �� �����ϴ�!");
			}
			else {
				e.printStackTrace();
			}
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// ��ȭ ���� ���� Ȯ��
	public int checkMovie(int mo_num) {
		int check = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT mo_num FROM m_movie WHERE mo_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mo_num);
			rs = pstmt.executeQuery();
			if(rs.next()) { // �ִ� ��ȭ ��ȣ�� �Է��� ���
				check = 1;
			}
			else { // ���� ��ȭ ��ȣ�� �Է��� ���
				check = -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return check;
	}
	
	// ȸ�� ����
	public void insertMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO m_member(me_num,me_id,me_passwd,me_name,me_age,me_phone)"
					+ "VALUES(m_member_seq.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMe_id());
			pstmt.setString(2, vo.getMe_passwd());
			pstmt.setString(3, vo.getMe_name());
			pstmt.setInt(4, vo.getMe_Age());
			pstmt.setString(5,vo.getMe_phone());
			pstmt.executeUpdate();
			System.out.println("CGV�� ȸ���� �ǽŰ� ���ϵ帳�ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// ���̵� �ߺ� üũ
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM m_member WHERE me_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,me_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return count;
	}

	// �α���
	public int loginCheck(String me_id,String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num = 0;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT me_num FROM m_member WHERE me_id=? AND me_passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				me_num = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs,pstmt,conn);
		}

		return me_num;
	}
	
	// �����ϱ�
	public void reserve(ReservationVO vo) {
		Connection conn = null;
		PreparedStatement pstmt_i = null; // INSERT���� ���� PreparedStatement ��ü ����
		PreparedStatement pstmt_u = null; // UPDATE���� ���� PreparedStatement ��ü ����
		String sql_i = null;
		String sql_u = null;

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); // m_reservation ���̺�� m_movie ���̺��� ������ ��� �����ؾ� �ϹǷ�, �������� Ʈ����� ����
			sql_i = "INSERT INTO m_reservation (re_num, me_num, mo_num, re_seats) "
					+ "VALUES (m_reservation_seq.NEXTVAL, ?, ?, ?)";
			pstmt_i = conn.prepareStatement(sql_i);
			pstmt_i.setInt(1, vo.getMe_num());
			pstmt_i.setInt(2, vo.getMo_num());
			pstmt_i.setInt(3, vo.getRe_seats());
			pstmt_i.executeUpdate(); // INSERT�� ����
			sql_u = "UPDATE m_movie SET mo_seats=mo_seats-? WHERE mo_num=?";
			pstmt_u = conn.prepareStatement(sql_u);
			pstmt_u.setInt(1, vo.getRe_seats());
			pstmt_u.setInt(2, vo.getMo_num());
			pstmt_u.executeUpdate(); // UPDATE�� ����
			conn.commit(); // INSERT���� UPDATE���� ��� �������� ���� ���� Ʈ������� ���� ������ �����ͺ��̽��� �ݿ�
			System.out.println(getMovieOneLine(vo)+"��/�� "+vo.getRe_seats()+"�� �����߽��ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // ���� �߻���, ���� Ʈ������� ���� ������ ���� ���
				System.out.println("���ſ� �����߽��ϴ�!");
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		finally {
			DBUtil.executeClose(null, pstmt_i, null);
			DBUtil.executeClose(null, pstmt_u, conn);
		}
	}

	// ���� ���� Ȯ��
	public int checkAge(ReservationVO vo) {
		int check = 0; // ��ȯ�� ���� ���� int ���� �����ϰ� 0���� �ʱ�ȭ
		int me_age = Integer.parseInt(getInfo(vo, "me_age")); // ȸ���� ���� ��������
		int mo_ban = Integer.parseInt(getInfo(vo, "mo_ban")); // ��ȭ�� ������ ��������

		if(me_age>=mo_ban) { // ȸ���� ���̰� ��ȭ�� ������ �̻��� ���
			check = 1; // 1 ��ȯ 
		}
		else { // ȸ���� ���̰� ��ȭ�� ������ �̸��� ���
			System.out.println("�ش� ��ȭ�� "+mo_ban+"�� �̻� �������Դϴ�!"); // �ʱⰪ(=0) ��ȯ�ϰ� �ش� ��ȭ�� �������� ���
		}

		return check;
	}

	// �ܿ� �¼� �� Ȯ��
	public int checkSeats(ReservationVO vo) {
		int check = 0; // ��ȯ�� ���� ���� int ���� �����ϰ� 0���� �ʱ�ȭ
		int mo_seats = Integer.parseInt(getInfo(vo, "mo_seats")); // ��ȭ�� �ܿ� �¼� �� ��������

		if(mo_seats>=vo.getRe_seats()) { // ��ȭ�� �ܿ� �¼� ���� �����Ϸ��� �¼� �� �̻��� ���
			check=1; // 1 ��ȯ
		}
		else if(mo_seats==0) { // ��ȭ�� �ܿ� �¼� ���� 0�� ���
			System.out.println(getMovieOneLine(vo)+"��/�� ���� �� �¼��� �����Ǿ����ϴ�!"); // �ʱⰪ(=0) ��ȯ�ϰ� �����Ǿ��ٰ� ���
		}
		else { // ��ȭ�� �ܿ� �¼� ���� �����Ϸ��� �¼� �� �̸��� ���
			System.out.println(getMovieOneLine(vo)+"��/�� ���� �ִ� "+mo_seats+"���� ���� �����մϴ�!"); // �ʱⰪ(=0) ��ȯ�ϰ� ���� ������ �¼� ���� ���
		}

		return check;
	}

	// ��ȭ ����� �� ��¥, �ð��� �� �ٷ� ��ȯ
	public String getMovieOneLine(ReservationVO vo) {
		String mo_title = getInfo(vo, "mo_title");
		String mo_date = getInfo(vo, "mo_date");
		String mo_time = getInfo(vo, "mo_time");
		return mo_title+" ("+mo_date.substring(5,10)+" "+mo_time.substring(0,2)+"�� ��) ";
	}

	// PRIMARY KEY�� Ư�� �÷��� �� ��������
	public String getInfo(ReservationVO vo, String whichcol) { // PRIMARY KEY�� ��� ReservationVO ��ü��, �� ������ �÷����� ���ڷ� ����
		String info = ""; // ��ȯ�� ���� ���� String ������ �����ϰ� �� ���ڿ��� �ʱ�ȭ
		
		String whichtab = "dual";
		int whichnum = 0;
		if(whichcol.startsWith("me_")) { // �� ������ �÷����� me_�� �����ϴ� ���
			whichtab = "m_member"; // �ش� �÷��� m_member ���̺� ����
			whichnum = vo.getMe_num(); // �ش� ���̺��� PRIMARY KEY�� me_num
		}
		else if(whichcol.startsWith("mo_")) { // �� ������ �÷����� mo_�� �����ϴ� ���
			whichtab = "m_movie"; // �ش� �÷��� m_movie ���̺� ����
			whichnum = vo.getMo_num(); // �ش� ���̺��� PRIMARY KEY�� mo_num
		}
		else if(whichcol.startsWith("re_")) { // �� ������ �÷����� re_�� �����ϴ� ���
			whichtab = "m_reservation"; // �ش� �÷��� m_reservation ���̺� ����
			whichnum = vo.getRe_num(); // �ش� ���̺��� PRIMARY KEY�� re_num
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT " + whichcol + " FROM " + whichtab + " WHERE " + whichcol.substring(0,3) + "num=?"; // �Է��� �÷��� �˸��� ���̺��� PRIMARY KEY�� �̿��Ͽ� �ش� �÷��� ���� ��ȸ
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, whichnum);
			rs = pstmt.executeQuery();
			if(rs.next()) { // PRIMARY KEY�� �̿��� SELECT�� ����� �ִ� �� �Ǹ� ��ȯ��
				info = rs.getString(1); // ��� �÷��� NUMBER Ȥ�� VARCHAR2�̹Ƿ�, �� �ڷ��� ��� ������ �� �ֵ��� getString() �޼��� ���
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return info;
	}
	
	// ���� ���� Ȯ���ϱ�
	public void selectListReservation() { // ��ü ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num, me_num, mo_num, mo_title, mo_date, mo_time, re_seats FROM m_reservation "
				+ "JOIN m_member USING(me_num) JOIN m_movie USING(mo_num) "
				+ "ORDER BY re_num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("=========================================================================");
			System.out.println("���� ��ȣ\tȸ�� ��ȣ\t��ȭ ��ȣ\t��ȭ ����\t\t�� ��¥\t\t�� �ð�\t���� �¼� ��");
			System.out.println("=========================================================================");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getInt("me_num")+"\t");
				System.out.print(rs.getInt("mo_num")+"\t");
				String mo_title = rs.getString("mo_title"); // ��ȭ ������ �ʹ� ��� ������ǥ ó���ϱ� ���� ���� ����
				if(mo_title.length()>6+6) {
					System.out.print(mo_title.substring(0,4+6)+"..\t");
				}
				else if(mo_title.length()>6) {
					System.out.print(mo_title+"\t");
				}
				else {
					System.out.print(mo_title+"\t\t");
				}
				System.out.print(rs.getString("mo_date")+"\t");
				System.out.print(rs.getString("mo_time").substring(0,5)+"\t"); // �� ���� ����
				int re_seats = rs.getInt("re_seats");
				if(re_seats==0) {
					System.out.println("���� ���");
				}
				else {
					System.out.println(re_seats);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	public void selectListReservation(int me_num) { // �� ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num, mo_num, mo_title, mo_date, mo_time, re_seats FROM m_reservation "
				+ "JOIN m_member USING(me_num) JOIN m_movie USING(mo_num) "
				+ "WHERE me_num=? ORDER BY re_num DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, me_num);
			rs = pstmt.executeQuery();
			System.out.println("=================================================================");
			System.out.println("���� ��ȣ\t��ȭ ��ȣ\t��ȭ ����\t\t�� ��¥\t\t�� �ð�\t���� �¼� ��");
			System.out.println("=================================================================");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getInt("mo_num")+"\t");
				String mo_title = rs.getString("mo_title"); // ��ȭ ������ �ʹ� ��� ������ǥ ó���ϱ� ���� ���� ����
				if(mo_title.length()>6+6) {
					System.out.print(mo_title.substring(0,4+6)+"..\t");
				}
				else if(mo_title.length()>6) {
					System.out.print(mo_title+"\t");
				}
				else {
					System.out.print(mo_title+"\t\t");
				}
				System.out.print(rs.getString("mo_date")+"\t");
				System.out.print(rs.getString("mo_time").substring(0,5)+"\t"); // �� ���� ����
				int re_seats = rs.getInt("re_seats");
				if(re_seats==0) {
					System.out.println("���� ���");
				}
				else {
					System.out.println(re_seats);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// ���� ���� Ȯ��
	public void reservationCheck(int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num,me_num,mo_date,mo_time,re_seats FROM m_reservation "
					+ "JOIN m_movie USING(mo_num)"
					+ "JOIN m_member USING(me_num) WHERE me_num=? "
					+ "ORDER BY re_num DESC";
			pstmt=conn.prepareStatement(sql);      
			pstmt.setInt(1, me_num);
			rs=pstmt.executeQuery();
			System.out.println("=========================");
			System.out.println("���Ź�ȣ\t��ȭ��ȣ\t��ȭ����\t�󿵳�¥\t�󿵽ð�\t�¼�");
			System.out.println("=========================");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getInt("me_num")+"\t");
				System.out.print(rs.getString("mo_date")+"\t");
				System.out.print(rs.getString("mo_time")+"\t");
				System.out.println(rs.getInt("re_seats"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt,conn);
		}
	}
	
	// ���� ����ϱ�
	public void cancelReservation(ReservationVO vo) {
		Connection conn = null;
		PreparedStatement pstmt_m = null;
		PreparedStatement pstmt_r = null;
		String sql_m = null;
		String sql_r = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			sql_m = "UPDATE m_movie SET mo_seats=mo_seats+? WHERE mo_num=?";
			pstmt_m = conn.prepareStatement(sql_m);
			pstmt_m.setInt(1, vo.getRe_seats());
			pstmt_m.setInt(2, vo.getMo_num());
			pstmt_m.executeUpdate();
			sql_r = "UPDATE m_reservation SET re_seats=0 WHERE re_num=?";
			pstmt_r = conn.prepareStatement(sql_r);
			pstmt_r.setInt(1, vo.getRe_num());
			pstmt_r.executeUpdate();
			conn.commit();
			System.out.println(getMovieOneLine(vo)+"�� ���Ÿ� ����Ͽ����ϴ�.");
		}
		catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		finally {
			DBUtil.executeClose(null, pstmt_m, null);
			DBUtil.executeClose(null, pstmt_r, conn);
		}
	}
	
	// 1���� ���� ������ ��� ReservationVO ��ü ��ȯ�ϱ�
	public ReservationVO getReservationVO(int re_num) {
		ReservationVO vo = new ReservationVO();
		vo.setRe_num(re_num);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM m_reservation WHERE re_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setMe_num(rs.getInt("me_num"));
				vo.setMo_num(rs.getInt("mo_num"));
				vo.setRe_seats(rs.getInt("re_seats"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return vo;
	}
}