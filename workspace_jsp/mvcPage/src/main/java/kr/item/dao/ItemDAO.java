package kr.item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.item.vo.ItemVO;
import kr.util.DBUtil;

public class ItemDAO {
	// 싱글턴 패턴
	private static ItemDAO instance = new ItemDAO();
	public static ItemDAO getInstance() {
		return instance;
	}
	private ItemDAO() {}
	
	// 관리자 : 상품 등록
	public void insertItem(ItemVO item) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO zitem (item_num, name, price, quantity, photo1, photo2, detail, status) "
				+ "VALUES (zitem_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, item.getName());
			pstmt.setInt(2, item.getPrice());
			pstmt.setInt(3, item.getQuantity());
			pstmt.setString(4, item.getPhoto1());
			pstmt.setString(5, item.getPhoto2());
			pstmt.setString(6, item.getDetail());
			pstmt.setInt(7, item.getStatus());
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 관리자/사용자 : 전체 상품 갯수/검색 상품 갯수
	public int getItemCount(String keyfield, String keyword, int status) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0; // 가변적 ? 번호
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "AND name LIKE ?";
				else if(keyfield.equals("2")) sub_sql = "AND detail LIKE ?";
			}
			
			// SQL문 작성
			sql = "SELECT COUNT(*) FROM zitem WHERE status > ? " + sub_sql; // 전체 검색시에는 인자로 0 전달
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(++cnt, status);
			if(keyword != null && !"".equals(keyword)) {
				pstmt.setString(++cnt, "%" + keyword + "%");
			}
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	// 관리자/사용자 : 전체 목록/검색 목록
	public List<ItemVO> getListItem(int startRow, int endRow, String keyfield, String keyword, int status) throws Exception {
		List<ItemVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0; // 가변적 ? 번호
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "AND name LIKE ?";
				else if(keyfield.equals("2")) sub_sql = "AND detail LIKE ?";
			}
			
			// SQL문 작성
			sql = "SELECT * FROM (SELECT i.*, ROWNUM AS rnum "
				+ "FROM (SELECT * FROM zitem WHERE status > ? " + sub_sql
				+ " ORDER BY item_num DESC) i) WHERE rnum >= ? AND rnum <= ?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(++cnt, status);
			if(keyword!=null && !"".equals(keyword)) {
				pstmt.setString(++cnt, "%" + keyword + "%");
			}
			pstmt.setInt(++cnt, startRow);
			pstmt.setInt(++cnt, endRow);
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			list = new ArrayList<ItemVO>();
			while(rs.next()) {
				ItemVO item = new ItemVO();
				item.setItem_num(rs.getInt("item_num"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setQuantity(rs.getInt("quantity"));
				item.setPhoto1(rs.getString("photo1"));
				item.setPhoto2(rs.getString("photo2"));
				item.setReg_date(rs.getDate("reg_date"));
				item.setModify_date(rs.getDate("modify_date"));
				item.setStatus(rs.getInt("status"));
				
				// 자바빈을 ArrayList에 저장
				list.add(item);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 관리자/사용자 : 상품 상세
	public ItemVO getItem(int item_num) throws Exception {
		ItemVO item = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM zitem WHERE item_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, item_num);
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				item = new ItemVO();
				item.setItem_num(item_num);
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setQuantity(rs.getInt("quantity"));
				item.setPhoto1(rs.getString("photo1"));
				item.setPhoto2(rs.getString("photo2"));
				item.setDetail(rs.getString("detail"));
				item.setStatus(rs.getInt("status"));
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return item;
	}
	
	// 관리자 : 상품 수정
	public void updateItem(ItemVO item) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0; // 가변적 ? 번호
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			if(item.getPhoto1()!=null) sub_sql += ", photo1=?";
			if(item.getPhoto2()!=null) sub_sql += ", photo2=?";
			
			// SQL문 작성
			sql = "UPDATE zitem SET name=?, price=?, quantity=?" + sub_sql 
				+ ", detail=?, modify_date=SYSDATE, status=? WHERE item_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(++cnt, item.getName());
			pstmt.setInt(++cnt, item.getPrice());
			pstmt.setInt(++cnt, item.getQuantity());
			if(item.getPhoto1()!=null) pstmt.setString(++cnt, item.getPhoto1());
			if(item.getPhoto2()!=null) pstmt.setString(++cnt, item.getPhoto2());
			pstmt.setString(++cnt, item.getDetail());
			pstmt.setInt(++cnt, item.getStatus());
			pstmt.setInt(++cnt, item.getItem_num());
			// SQL문 실행
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 관리자 : 상품 삭제
	public void deleteItem(int item_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// 오토 커밋 해제
			conn.setAutoCommit(false);
			
			// 삭제하고자 하는 상품이 카트에 담겨 있으면 카트에 저장된 상품을 삭제
			// SQL문 작성
			sql = "DELETE FROM zcart WHERE item_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, item_num);
			// SQL문 실행
			pstmt.executeUpdate();
			
			// 상품 테이블에서 상품 삭제
			// SQL문 작성
			sql = "DELETE FROM zitem WHERE item_num=?";
			// PreparedStatement 객체 생성
			pstmt2 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt2.setInt(1, item_num);
			// SQL문 실행
			pstmt2.executeUpdate();
			
			// SQL문 실행이 모두 성공하면
			conn.commit();
		}
		catch(Exception e) {
			// SQL문 실행이 하나라도 실패하면
			conn.rollback();
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
}