package kr.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.order.vo.OrderDetailVO;
import kr.order.vo.OrderVO;
import kr.util.DBUtil;

public class OrderDAO {
	// 싱글턴 패턴
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	private OrderDAO() {}
	
	// 주문 등록
	public void insertOrder(OrderVO order, List<OrderDetailVO> orderDetailList) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs = null;
		String sql = null;
		int order_num = 0;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// 오토 커밋 해제
			conn.setAutoCommit(false);
			
			// 시퀀스 값 가져오기
			// SQL문 작성
			sql = "SELECT zorder_seq.NEXTVAL FROM dual";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order_num = rs.getInt(1);
			}
			
			// zorder에 주문 정보 삽입
			// SQL문 작성
			sql = "INSERT INTO zorder (order_num, item_name, order_total, payment, "
				+ "receive_name, receive_post, receive_address1, receive_address2, "
				+ "receive_phone, notice, mem_num) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// PreparedStatement 객체 생성
			pstmt2 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt2.setInt(1, order_num);
			pstmt2.setString(2, order.getItem_name());
			pstmt2.setInt(3, order.getOrder_total());
			pstmt2.setInt(4, order.getPayment());
			pstmt2.setString(5, order.getReceive_name());
			pstmt2.setString(6, order.getReceive_post());
			pstmt2.setString(7, order.getReceive_address1());
			pstmt2.setString(8, order.getReceive_address2());
			pstmt2.setString(9, order.getReceive_phone());
			pstmt2.setString(10, order.getNotice());
			pstmt2.setInt(11, order.getMem_num());
			// SQL문 실행
			pstmt2.executeUpdate();
			
			// zorder_detail에 주문 상세 정보 삽입
			// SQL문 작성
			sql = "INSERT INTO zorder_detail (detail_num, item_num, item_name, "
				+ "item_price, item_total, order_quantity, order_num) "
				+ "VALUES (zdetail_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			// PreparedStatement 객체 생성
			pstmt3 = conn.prepareStatement(sql);

			for(int i=0;i<orderDetailList.size();i++) {
				OrderDetailVO orderDetail = orderDetailList.get(i);
				// ?에 데이터 바인딩
				pstmt3.setInt(1, orderDetail.getItem_num());
				pstmt3.setString(2, orderDetail.getItem_name());
				pstmt3.setInt(3, orderDetail.getItem_price());
				pstmt3.setInt(4, orderDetail.getItem_total());
				pstmt3.setInt(5, orderDetail.getOrder_quantity());
				pstmt3.setInt(6, order_num);
				// 쿼리를 메모리에 올림
				pstmt3.addBatch();
				// 계속 추가시 outOfMemory 발생하므로 1000개 단위로 executeBatch()
				if(i%1000==0) {
					pstmt3.executeBatch();
				}
			}
			// 쿼리를 전송
			pstmt3.executeBatch();
			
			// 상품의 재고 수 차감
			// SQL문 작성
			sql = "UPDATE zitem SET quantity=quantity-? WHERE item_num=?";
			// PreparedStatement 객체 생성
			pstmt4 = conn.prepareStatement(sql);
			
			for(int i=0;i<orderDetailList.size();i++) {
				OrderDetailVO orderDetail = orderDetailList.get(i);
				// ?에 데이터를 바인딩
				pstmt4.setInt(1, orderDetail.getOrder_quantity());
				pstmt4.setInt(2, orderDetail.getItem_num());
				// 쿼리를 메모리에 올림
				pstmt4.addBatch();
				// 메모리 초과 방지
				if(i%1000==0) {
					pstmt4.executeBatch();
				}
			}
			// 쿼리를 전송
			pstmt4.executeBatch();
			
			// 카트에서 주문 상품 삭제
			// SQL문 작성
			sql = "DELETE FROM zcart WHERE mem_num=?";
			// PreparedStatement 객체 생성
			pstmt5 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt5.setInt(1, order.getMem_num());
			// SQL문 실행
			pstmt5.executeUpdate();
			
			// 모든 SQL문이 성공하면
			conn.commit();
		}
		catch(Exception e) {
			// SQL문이 하나라도 실패하면
			conn.rollback();
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt5, null);
			DBUtil.executeClose(null, pstmt4, null);
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	// 관리자 : 전체 글/검색 글 수
	public int getOrderCount(String keyfield, String keyword) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "WHERE order_num=?";
				else if(keyfield.equals("2")) sub_sql = "WHERE id LIKE ?";
				else if(keyfield.equals("3")) sub_sql = "WHERE item_name LIKE ?";
			}
			
			// SQL문 작성
			sql = "SELECT COUNT(*) FROM zorder o JOIN zmember m "
				+ "ON o.mem_num=m.mem_num " + sub_sql;
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			if(keyword != null && !"".equals(keyword)) {
				if(keyfield.equals("1")) {
					pstmt.setString(1, keyword);
				}
				else if(keyfield.equals("2") || keyfield.equals("3")) {
					pstmt.setString(1, "%" + keyword + "%");
				}
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
	
	// 관리자 : 전체 목록/검색 글 목록
	public List<OrderVO> getListOrder(int startRow, int endRow, String keyfield, String keyword) throws Exception {
		List<OrderVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "WHERE order_num=?";
				else if(keyfield.equals("2")) sub_sql = "WHERE id LIKE ?";
				else if(keyfield.equals("3")) sub_sql = "WHERE item_name LIKE ?";
			}
			
			// SQL문 작성
			sql = "SELECT * FROM (SELECT a.*, ROWNUM AS rnum FROM (SELECT * "
					+ "FROM zorder o JOIN zmember m ON o.mem_num=m.mem_num " 
					+ sub_sql + " ORDER BY order_num DESC) a) "
				+ "WHERE rnum>=? AND rnum<=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) {
					pstmt.setString(++cnt, keyword);
				}
				else if(keyfield.equals("2") || keyfield.equals("3")) {
					pstmt.setString(++cnt, "%" + keyword + "%");
				}
			}
			pstmt.setInt(++cnt, startRow);
			pstmt.setInt(++cnt, endRow);
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			list = new ArrayList<OrderVO>();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				order.setOrder_num(rs.getInt("order_num"));
				order.setItem_name(rs.getString("item_name"));
				order.setOrder_total(rs.getInt("order_total"));
				order.setStatus(rs.getInt("status"));
				order.setReg_date(rs.getDate("reg_date"));
				order.setId(rs.getString("id"));
								
				list.add(order);
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
	
	// 사용자 : 전체 글/검색 글 수
	public int getOrderCountByMem_num(String keyfield, String keyword, int mem_num) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			
			// 검색 처리
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) sub_sql = "AND order_num=?";
				else if(keyfield.equals("2")) sub_sql = "AND item_name LIKE ?";
			}
			
			// SQL문 작성
			sql = "SELECT COUNT(*) FROM zorder WHERE mem_num=? " + sub_sql;
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(++cnt, mem_num);
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) {
					pstmt.setString(++cnt, keyword);
				}
				else if(keyfield.equals("2")) {
					pstmt.setString(++cnt, "%" + keyword + "%");
				}
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
	
	// 사용자 : 전체 목록/검색 글 목록
	public List<OrderVO> getOrderByMem_num(int startRow, int endRow, String keyfield, String keyword, int mem_num) throws Exception {
		List<OrderVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			// 검색 처리
			if(keyword!=null && !"".equals(sql)) {
				if(keyfield.equals("1")) sub_sql = "AND order_num=?";
				else if(keyfield.equals("2")) sub_sql = "AND item_name LIKE ?";
			}
			
			// SQL문 작성
			sql = "SELECT * FROM (SELECT a.*, ROWNUM AS rnum "
				+ "FROM (SELECT * FROM zorder WHERE mem_num=? " + sub_sql
				+ " ORDER BY order_num DESC) a) WHERE rnum>=? AND rnum<=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(++cnt, mem_num);
			if(keyword!=null && !"".equals(keyword)) {
				if(keyfield.equals("1")) {
					pstmt.setString(++cnt, keyword);
				}
				else if(keyfield.equals("2")) {
					pstmt.setString(++cnt, "%" + keyword + "%");
				}
			}
			pstmt.setInt(++cnt, startRow);
			pstmt.setInt(++cnt, endRow);
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			list = new ArrayList<OrderVO>();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				order.setOrder_num(rs.getInt("order_num"));
				order.setItem_name(rs.getString("item_name"));
				order.setOrder_total(rs.getInt("order_total"));
				order.setReg_date(rs.getDate("reg_date"));
				order.setStatus(rs.getInt("status"));
				
				list.add(order);
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
	
	// 개별 상품 목록
	public List<OrderDetailVO> getListOrderDetail(int order_num) throws Exception {
		List<OrderDetailVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= null;
		
		try {
			// 커넥션 풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM zorder_detail WHERE order_num=? ORDER BY item_num DESC";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, order_num);
			// SQL문을 실행해서 결과 행들을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			list = new ArrayList<OrderDetailVO>();
			while(rs.next()) {
				OrderDetailVO detail = new OrderDetailVO();
				detail.setItem_num(rs.getInt("item_num"));
				detail.setItem_name(rs.getString("item_name"));
				detail.setItem_price(rs.getInt("item_price"));
				detail.setItem_total(rs.getInt("item_total"));
				detail.setOrder_quantity(rs.getInt("order_quantity"));
				list.add(detail);
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
	
	// 괸리자/사용자 : 주문 상세
	public OrderVO getOrder(int order_num) throws Exception {
		OrderVO order = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// 커넥션 풀에서 커넥션 할당
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM zorder WHERE order_num=? ";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, order_num);
			// SQL문을 실행해서 결과 행을 ResultSet에 담아 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = new OrderVO();
				order.setOrder_num(rs.getInt("order_num"));
				order.setItem_name(rs.getString("item_name"));
				order.setOrder_total(rs.getInt("order_total"));
				order.setPayment(rs.getInt("payment"));
				order.setStatus(rs.getInt("status"));
				order.setReceive_name(rs.getString("receive_name"));
				order.setReceive_post(rs.getString("receive_post"));
				order.setReceive_address1(rs.getString("receive_address1"));
				order.setReceive_address2(rs.getString("receive_address2"));
				order.setReceive_phone(rs.getString("receive_phone"));
				order.setNotice(rs.getString("notice"));
				order.setReg_date(rs.getDate("reg_date"));
				order.setMem_num(rs.getInt("mem_num"));
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return order;
	}
	
	// 주문 수정
	public void updateOrder(OrderVO order) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			// 커넥션 풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			// 오토 커밋 해제
			conn.setAutoCommit(false);
			
			// zorder 수정
			// SQL문 작성
			sql = "UPDATE zorder SET payment=?, status=?, receive_name=?, "
				+ "receive_post=?, receive_address1=?, receive_address2=?, receive_phone=?, "
				+ "notice=?, modify_date=SYSDATE WHERE order_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, order.getPayment());
			pstmt.setInt(2, order.getStatus());
			pstmt.setString(3, order.getReceive_name());
			pstmt.setString(4, order.getReceive_post());
			pstmt.setString(5, order.getReceive_address1());
			pstmt.setString(6, order.getReceive_address2());
			pstmt.setString(7, order.getReceive_phone());
			pstmt.setString(8, order.getNotice());
			pstmt.setInt(9, order.getOrder_num());
			// SQL문 실행
			pstmt.executeUpdate();
			
			// 주문 취소일 경우만 zitem의 상품 갯수 조정
			if(order.getStatus()==5) {
				// 주문 번호에 해당하는 상품 정보 구하기
				List<OrderDetailVO> detailList = getListOrderDetail(order.getOrder_num());
				
				// SQL문 작성
				sql = "UPDATE zitem SET quantity=quantity+? WHERE item_num=?";
				// PreparedStatement 객체 생성
				pstmt2 = conn.prepareStatement(sql);
				for(int i=0;i<detailList.size();i++) {
					OrderDetailVO detail = detailList.get(i);
					// ?에 데이터를 바인딩
					pstmt2.setInt(1, detail.getOrder_quantity());
					pstmt2.setInt(2, detail.getItem_num());
					// 쿼리를 메모리에 올림
					pstmt2.addBatch();
					// 계속 추가시 outOfMemory 발생하므로 1000개 단위로 executeBatch()
					if(i%1000==0) {
						pstmt2.executeBatch();
					}
				} // end of for
				// 쿼리를 전송
				pstmt2.executeBatch();
			} // end of if
			
			// 모든 SQL문 실행이 성공하면
			conn.commit();
		}
		catch (Exception e) {
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
	
	// 주문 삭제
	public void deleteOrder(int order_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			// 주문 상세 정보 삭제
			// SQL문 작성
			sql = "DELETE FROM zorder_detail WHERE order_num=?";
			// PreparedStatement 객체 생성			
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, order_num);
			// SQL문 작성
			pstmt.executeUpdate();
			
			// 주문 정보 삭제
			// SQL문 작성
			sql = "DELETE FROM zorder WHERE order_num=?";
			// PreparedStatement 객체 생성
			pstmt2 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt2.setInt(1, order_num);
			// SQL문 실행
			pstmt2.executeUpdate();
			
			// 모든 SQL문 실행이 성공하면
			conn.commit();	
		}
		catch(Exception e) {
			// SQL문 실행이 하나라도 실패하면
			conn.rollback();
			throw new Exception(e);
		}
		finally {
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
}