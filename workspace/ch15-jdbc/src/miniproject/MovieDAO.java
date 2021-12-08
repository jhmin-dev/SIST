package miniproject;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {
	// 영화 등록
	public void insertMovie() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "insert into m_movie (mo_num, mo_title, mo_ban, mo_date) "
				+ "values (m_movie_seq.nextval, '듄', 12, to_date(?, 'YYYY-MM-DD HH:MI:SS'))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "2021-12-25 11:00:00");
			int count = pstmt.executeUpdate();
			System.out.println(count+"편의 영화를 추가했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	// 영화 목록 확인
	public void selectListMovie() {

	}
	// 영화 수정
	public void updateMovie() {

	}
	// 영화 삭제
	public void deleteMovie(MovieVO movie) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "DELETE FROM m_movie WHERE mo_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie.getMo_num());
			int count = pstmt.executeUpdate();
			System.out.println(count+"편의 영화를 삭제하였습니다.");
		}
		catch(Exception e) {
			if(e.getMessage().trim().endsWith("child record found")) {
				System.out.println("해당 영화는 예매자가 있으므로 삭제할 수 없습니다!");
			}
			else {
				e.printStackTrace();
			}
		}
		finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 회원 가입
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
			System.out.println("CGV의 회원이 되신걸 축하드립니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	//아이디 중복 체크
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

	// 로그인
	public int loginCheck(String me_id,String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num = 0;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT me_num FROM m_member WHERE me_id =? AND me_passwd = ?";
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
	
	// 예매하기
	public void reserve(ReservationVO reservation) {
		Connection conn = null;
		PreparedStatement pstmt_i = null;
		PreparedStatement pstmt_u = null;
		String sql_i = null;
		String sql_u = null;

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			sql_i = "INSERT INTO m_reservation (re_num, me_num, mo_num, re_seats) "
					+ "VALUES (m_reservation_seq.NEXTVAL, ?, ?, ?)";
			pstmt_i = conn.prepareStatement(sql_i);
			pstmt_i.setInt(1, reservation.getMe_num());
			pstmt_i.setInt(2, reservation.getMo_num());
			pstmt_i.setInt(3, reservation.getRe_seats());
			sql_u = "UPDATE m_movie SET mo_seats=mo_seats-? WHERE mo_num=?";
			pstmt_u = conn.prepareStatement(sql_u);
			pstmt_u.setInt(1, reservation.getRe_seats());
			pstmt_u.setInt(2, reservation.getMo_num());
			pstmt_i.executeUpdate();
			pstmt_u.executeUpdate();
			conn.commit();
			System.out.println(getMovieOneLine(reservation)+"을/를 "+reservation.getRe_seats()+"석 예매했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("예매에 실패했습니다!");
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

	// 연령 제한 확인
	public int checkAge(ReservationVO reservation) {
		int check=0;
		int me_age = Integer.parseInt(getInfo(reservation, "me_age"));
		int mo_ban = Integer.parseInt(getInfo(reservation, "mo_ban"));

		if(me_age>=mo_ban) {
			check = 1;
		}
		else {
			System.out.println("해당 영화는 "+mo_ban+"세 이상 관람가입니다!");
		}

		return check;
	}

	// 잔여 좌석 수 확인
	public int checkSeats(ReservationVO reservation) {
		int check=0;
		int mo_seats = Integer.parseInt(getInfo(reservation, "mo_seats"));

		if(mo_seats>=reservation.getRe_seats()) {
			check=1;
		}
		else if(mo_seats==0) {
			System.out.println(getMovieOneLine(reservation)+"은/는 현재 전 좌석이 매진되었습니다!");
		}
		else {
			System.out.println(getMovieOneLine(reservation)+"은/는 현재 최대 "+mo_seats+"석만 예매 가능합니다!");
		}

		return check;
	}

	// 영화 제목과 상영일 한 줄 반환
	public String getMovieOneLine(ReservationVO reservation) {
		String mo_title = getInfo(reservation, "mo_title");
		String mo_date = getInfo(reservation, "mo_date");
		return mo_title+" ("+mo_date.substring(5,10)+" 상영) ";
	}

	// 특정 컬럼의 정보 반환
	public String getInfo(ReservationVO reservation, String whichcol) {
		String info = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String whichtab = "dual";
		int whichnum = 0;

		if(whichcol.startsWith("me_")) {
			whichtab = "m_member";
			whichnum = reservation.getMe_num();
		}
		else if(whichcol.startsWith("mo_")) {
			whichtab = "m_movie";
			whichnum = reservation.getMo_num();
		}
		else if(whichcol.startsWith("re_")) {
			whichtab = "m_reservation";
			whichnum = reservation.getRe_num();
		}

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT " + whichcol + " FROM " + whichtab + " WHERE " + whichcol.substring(0,3) + "num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, whichnum);
			rs = pstmt.executeQuery();
			if(rs.next()) { // me_num, mo_num, re_num 모두 PRIMARY KEY이므로 최대 한 건만 반환됨
				info = rs.getString(1);
			}
			else {
				System.out.println("조회할 데이터가 없습니다.");
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

	// 예매 정보 확인
	public void reservationCheck(int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num,mo_num,mo_date,re_seats FROM m_reservation "
				+ "JOIN m_movie USING(mo_num) "
				+ "JOIN m_member USING(me_num) WHERE me_num=? "
				+ "ORDER BY re_num DESC";
			pstmt=conn.prepareStatement(sql);		
			pstmt.setInt(1, me_num);
			rs=pstmt.executeQuery();
			System.out.println("=========================");
			System.out.println("예매번호\t영화번호\t영화제목\t좌석");
			System.out.println("=========================");
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getInt("mo_num")+"\t");
				System.out.print(rs.getDate("mo_date")+"\t");
				System.out.println(rs.getInt("re_seats"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt,conn);
		}
	}
	
	// 예매 취소하기
	public void cancelReservation(ReservationVO reservation) {
		
	}
}