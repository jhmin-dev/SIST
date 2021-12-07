package miniproject;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {
	// 영화 등록
	public void insertMovie() {
		
	}
	
	// 영화 목록 확인
	public void selectListMovie() {
		
	}
	
	// 영화 수정
	public void updateMovie() {
		
	}
	
	// 영화 삭제
	public void deleteMovie() {
		
	}
	
	// 회원 가입
	public void insertMember() {
		
	}
	
	// 로그인
	public int loginCheck(String me_id, String me_passwd) {
		int me_num = 0;
		
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
	public void reservationCheck() {
		
	}
}