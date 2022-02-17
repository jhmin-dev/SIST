package kr.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	// 관리자 : 전체 목록/검색 글 목록
	
	// 사용자 : 전체 글/검색 글 수
	
	// 사용자 : 전체 목록/검색 글 목록
	
	// 상세 상품 정보 목록
	
	// 주문 상세
	
	// 주문 수정
	
	// 주문 삭제
	
}