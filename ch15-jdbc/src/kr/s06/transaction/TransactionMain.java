package kr.s06.transaction;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			// 트랜잭션 처리를 위해서 자동 COMMIT 해제
			conn.setAutoCommit(false);
			
			// SQL문 작성
			sql = "INSERT INTO test1 VALUES (?, ?)";
			
			// JDBC 수행 3단계;
			pstmt1 = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt1.setString(1, "test");
			pstmt1.setInt(2, 10);
			
			// JDBC 수행 4단계 : SQL문 실행
			pstmt1.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES (?, ?)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, "COMMIT");
			pstmt2.setInt(2, 20);
			pstmt2.executeUpdate();
			
			// 트랜잭션 테스트를 위해 오류가 있는 SQL문 작성
			sql = "INSERT INTO test1 VALUES (?, ?";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, "ROLLBACK");
			pstmt3.setInt(2, 30);
			pstmt3.executeUpdate();
			
			// 모든 SQL문이 정상적으로 처리되면 COMMIT
			conn.commit();
			System.out.println("작업 완료");	
		}
		catch(Exception e) {
			e.printStackTrace();
			
			// 예외 발생하면 ROLLBACK
			try {
				conn.rollback();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		finally {
			DBUtil.executeClose(null, pstmt1, null);
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, conn); // PreparedStatement 객체가 여러 개일 때, 각각의 정리 순서는 중요하지 않고 Connection 객체만 마지막에 정리하면 됨
		}
	}
}