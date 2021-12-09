package miniproject;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {
	// 영화 등록
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
			System.out.println("영화 등록이 되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null,pstmt,conn);
		}	
	}
	
	// 영화 목록 확인
	public void selectListMovie() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT mo_num,mo_title,mo_date,mo_time,mo_ban,mo_seats FROM m_movie "
					+ "LEFT OUTER JOIN(SELECT * FROM m_reservation WHERE re_num=1) "
					+ "USING(mo_num) ORDER BY mo_num DESC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("================================================================");
			System.out.println("영화 번호\t영화 제목\t\t관람가\t상영 날짜\t\t상영 시간\t잔여 좌석 수");
			System.out.println("================================================================");

			while (rs.next()) {
				System.out.print(rs.getInt("mo_num") + "\t");
				String mo_title = rs.getString("mo_title"); // 영화 제목이 너무 길면 말줄임표 처리하기 위해 변수 선언
				if(mo_title.length()>6+6) {
					System.out.print(mo_title.substring(0,6+6-2) + "..\t");
				}
				else if(mo_title.length()>6) {
					System.out.print(mo_title + "\t");
				}
				else {
					System.out.print(mo_title + "\t\t");
				}
				int mo_ban = rs.getInt("mo_ban"); // 연령 제한 0인 경우 전연령이라고 출력하기 위해 변수 선언
				if(mo_ban==0) {
					System.out.print("전연령\t");
				}
				else {
					System.out.print(mo_ban + "\t");
				}
				System.out.print(rs.getString("mo_date") + "\t");
				System.out.print(rs.getString("mo_time") + "\t");
				int mo_seats = rs.getInt("mo_seats"); // 남은 좌석 수 0인 경우 매진이라고 출력하기 위해 변수 선언
				if(mo_seats==0) {
					System.out.println("매진");
				}
				else {
					System.out.println(mo_seats);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 영화 수정  (MovieDAO) 
	   public void updateMovie(MovieVO movie) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      String sql = null;
	      
	      try {
	         conn = DBUtil.getConnection();
	         
	         sql = "UPDATE m_movie SET mo_title=?,"
	               + "mo_date=?, mo_time=?,mo_seats=? WHERE mo_num=?";
	         
	         pstmt = conn.prepareStatement(sql);
	         
	        
	         pstmt.setString(1, movie.getMo_title());
	         pstmt.setString(2,movie.getMo_date());
	         pstmt.setString(3,movie.getMo_time());
	         pstmt.setInt(4 ,movie.getMo_seats());
	         pstmt.setInt(5,movie.getMo_num());
	         
	         int count = pstmt.executeUpdate();
	         System.out.println(count+"편의 영화 정보가 수정되었습니다.");
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBUtil.executeClose(null,pstmt,conn);
	      }
	   
	   }
	
	// 영화 삭제
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
	         System.out.println(count+"편의 영화를 삭제하였습니다.");
	      }
	      catch(Exception e) {
	         if(e.getMessage().trim().endsWith("child record found")) { // 삭제하려는 mo_num 값이 m_reservation 테이블에서 참조되고 있어 삭제에 실패한 경우
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
	   
	   // 영화 존재 여부 확인
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
	         if(rs.next()) { // 있는 영화 번호를 입력한 경우
	            check = 1;
	         }
	         else { // 없는 영화 번호를 입력한 경우
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
			System.out.println("쌍용 씨네마의 회원이 되신 걸 축하드립니다.");
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
	public void reserve(ReservationVO vo) {
		Connection conn = null;
		PreparedStatement pstmt_i = null; // INSERT문을 담을 PreparedStatement 객체 선언
		PreparedStatement pstmt_u = null; // UPDATE문을 담을 PreparedStatement 객체 선언
		String sql_i = null;
		String sql_u = null;

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); // m_reservation 테이블과 m_movie 테이블의 정보를 모두 변경해야 하므로, 수동으로 트랜잭션 관리
			sql_i = "INSERT INTO m_reservation (re_num, me_num, mo_num, re_seats) "
					+ "VALUES (m_reservation_seq.NEXTVAL, ?, ?, ?)";
			pstmt_i = conn.prepareStatement(sql_i);
			pstmt_i.setInt(1, vo.getMe_num());
			pstmt_i.setInt(2, vo.getMo_num());
			pstmt_i.setInt(3, vo.getRe_seats());
			pstmt_i.executeUpdate(); // INSERT문 실행
			sql_u = "UPDATE m_movie SET mo_seats=mo_seats-? WHERE mo_num=?";
			pstmt_u = conn.prepareStatement(sql_u);
			pstmt_u.setInt(1, vo.getRe_seats());
			pstmt_u.setInt(2, vo.getMo_num());
			pstmt_u.executeUpdate(); // UPDATE문 실행
			conn.commit(); // INSERT문과 UPDATE문이 모두 성공했을 때만 현재 트랜잭션의 변경 내역을 데이터베이스에 반영
			System.out.println(getMovieOneLine(vo)+"을/를 "+vo.getRe_seats()+"석 예매했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 에러 발생시, 현재 트랜잭션의 변경 내역을 전부 취소
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
	public int checkAge(ReservationVO vo) {
		int check = 0; // 반환할 값을 담을 int 변수 선언하고 0으로 초기화
		int me_age = Integer.parseInt(getInfo(vo, "me_age")); // 회원의 나이 가져오기
		int mo_ban = Integer.parseInt(getInfo(vo, "mo_ban")); // 영화의 관람가 가져오기

		if(me_age>=mo_ban) { // 회원의 나이가 영화의 관람가 이상인 경우
			check = 1; // 1 반환 
		}
		else { // 회원의 나이가 영화의 관람가 미만인 경우
			System.out.println("해당 영화는 "+mo_ban+"세 이상 관람가입니다!"); // 초기값(=0) 반환하고 해당 영화의 관람가를 출력
		}

		return check;
	}

	// 잔여 좌석 수 확인
	public int checkSeats(ReservationVO vo) {
		int check = 0; // 반환할 값을 담을 int 변수 선언하고 0으로 초기화
		int mo_seats = Integer.parseInt(getInfo(vo, "mo_seats")); // 영화의 잔여 좌석 수 가져오기

		if(mo_seats>=vo.getRe_seats()) { // 영화의 잔여 좌석 수가 예매하려는 좌석 수 이상인 경우
			check=1; // 1 반환
		}
		else if(mo_seats==0) { // 영화의 잔여 좌석 수가 0인 경우
			System.out.println(getMovieOneLine(vo)+"은/는 현재 전 좌석이 매진되었습니다!"); // 초기값(=0) 반환하고 매진되었다고 출력
		}
		else { // 영화의 잔여 좌석 수가 예매하려는 좌석 수 미만인 경우
			System.out.println(getMovieOneLine(vo)+"은/는 현재 최대 "+mo_seats+"석만 예매 가능합니다!"); // 초기값(=0) 반환하고 예매 가능한 좌석 수를 출력
		}

		return check;
	}

	// 영화 제목과 상영 날짜, 시간을 한 줄로 반환
	public String getMovieOneLine(ReservationVO vo) {
		String mo_title = getInfo(vo, "mo_title");
		String mo_date = getInfo(vo, "mo_date");
		String mo_time = getInfo(vo, "mo_time");
		return mo_title+" ("+mo_date.substring(5,10)+" "+mo_time.substring(0,2)+"시 상영) ";
	}

	// PRIMARY KEY로 특정 컬럼의 값 가져오기
	public String getInfo(ReservationVO vo, String whichcol) { // PRIMARY KEY가 담긴 ReservationVO 객체와, 값 가져올 컬럼명을 인자로 받음
		String info = ""; // 반환할 값을 담을 String 변수를 선언하고 빈 문자열로 초기화
		
		String whichtab = "dual";
		int whichnum = 0;
		if(whichcol.startsWith("me_")) { // 값 가져올 컬럼명이 me_로 시작하는 경우
			whichtab = "m_member"; // 해당 컬럼은 m_member 테이블에 존재
			whichnum = vo.getMe_num(); // 해당 테이블의 PRIMARY KEY는 me_num
		}
		else if(whichcol.startsWith("mo_")) { // 값 가져올 컬럼명이 mo_로 시작하는 경우
			whichtab = "m_movie"; // 해당 컬럼은 m_movie 테이블에 존재
			whichnum = vo.getMo_num(); // 해당 테이블의 PRIMARY KEY는 mo_num
		}
		else if(whichcol.startsWith("re_")) { // 값 가져올 컬럼명이 re_로 시작하는 경우
			whichtab = "m_reservation"; // 해당 컬럼은 m_reservation 테이블에 존재
			whichnum = vo.getRe_num(); // 해당 테이블의 PRIMARY KEY는 re_num
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT " + whichcol + " FROM " + whichtab + " WHERE " + whichcol.substring(0,3) + "num=?"; // 입력한 컬럼명에 알맞은 테이블명과 PRIMARY KEY를 이용하여 해당 컬럼의 값을 조회
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, whichnum);
			rs = pstmt.executeQuery();
			if(rs.next()) { // PRIMARY KEY를 이용한 SELECT문 결과는 최대 한 건만 반환됨
				info = rs.getString(1); // 모든 컬럼이 NUMBER 혹은 VARCHAR2이므로, 두 자료형 모두 가져올 수 있도록 getString() 메서드 사용
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
	         sql = "SELECT re_num,me_num,mo_title,mo_date,mo_time,re_seats FROM m_reservation "
	            + "JOIN m_movie USING(mo_num)"
	            + "JOIN m_member USING(me_num) WHERE me_num=? "
	            + "ORDER BY re_num DESC";
	         pstmt=conn.prepareStatement(sql);      
	         pstmt.setInt(1, me_num);
	         rs=pstmt.executeQuery();
	         System.out.println("===========================================================");
	         System.out.println("예매 번호\t영화 번호\t영화 제목\t\t상영 날짜\t\t상영 시간\t좌석");
	         System.out.println("===========================================================");
	         while(rs.next()) {
	            System.out.print(rs.getInt("re_num")+"\t");
	            System.out.print(rs.getInt("me_num")+"\t");
	            String mo_title = rs.getString("mo_title"); // 영화 제목이 너무 길면 말줄임표 처리하기 위해 변수 선언
	            if(mo_title.length()>6+6) {
	            	System.out.print(mo_title.substring(0, 6+6-2)+"..\t");
	            }
	            else if(mo_title.length()>6) {
	            	System.out.print(mo_title+"\t");
	            }
	            else {
	            	System.out.print(mo_title+"\t\t");
	            }
	            System.out.print(rs.getString("mo_date")+"\t");
	            System.out.print(rs.getString("mo_time")+"\t");
	            int re_seats = rs.getInt("re_seats"); // 예매 좌석 수가 0인 경우 예매 취소라고 출력하기 위해 변수 선언
	            if(re_seats==0) {
	            	System.out.println("예매 취소");
	            }
	            else {
	            	System.out.println(re_seats);
	            }
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBUtil.executeClose(rs, pstmt,conn);
	      }
	   }
	  public void reservationCheck() {
		  Connection conn =null;
		  PreparedStatement pstmt = null;
		  String sql = null;
		  ResultSet rs = null;
		  try {
			  conn = DBUtil.getConnection();
			  sql = "SELECT re_num,mo_title,mo_date,mo_time,mo_ban,me_name,me_age "
			  		+ "FROM m_reservation JOIN m_member USING(me_num)"
			  		+ "JOIN m_movie USING(mo_num)";
			  pstmt = conn.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			  System.out.println("=======================================================================");
			  System.out.println("예매 번호\t영화 제목\t\t상영 날짜\t\t상영 시간\t관람가\t예매자명\t예매자 나이");
			  System.out.println("=======================================================================");
			  while(rs.next()) {
				  System.out.print(rs.getInt("re_num")+"\t");
				  String mo_title = rs.getString("mo_title"); // 영화 제목이 너무 길면 말줄임표 처리하기 위해 변수 선언
				  if(mo_title.length()>6+6) {
					  System.out.print(mo_title.substring(0, 6+6-2)+"..\t");
				  }
				  else if(mo_title.length()>6) {
					  System.out.print(mo_title+"\t");
				  }
				  else {
					  System.out.print(mo_title+"\t\t");
				  }
				  System.out.print(rs.getString("mo_date")+"\t");
				  System.out.print(rs.getString("mo_time")+"\t");
					int mo_ban = rs.getInt("mo_ban"); // 연령 제한 0인 경우 전연령이라고 출력하기 위해 변수 선언
					if(mo_ban==0) {
						System.out.print("전연령\t");
					}
					else {
						System.out.print(mo_ban + "\t");
					}
				  System.out.print(rs.getString("me_name")+"\t");
				  System.out.println(rs.getInt("me_age"));
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  DBUtil.executeClose(rs, pstmt, conn);
		  }
	  }

		// 예매 취소하기
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
				System.out.println(getMovieOneLine(vo)+"의 예매를 취소하였습니다.");
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
		
		// 1건의 예약 정보가 담긴 ReservationVO 객체 반환하기
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
	