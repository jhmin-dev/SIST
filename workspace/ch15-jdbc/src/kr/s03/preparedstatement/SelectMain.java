package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			// JDBC 수행 2단계 : Connection 객체 생성
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM test1";
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
					
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 반영하고 결과 집합을 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("ID\t나이");
			while(rs.next()) {
				System.out.print(rs.getString("id") + "\t");
				System.out.println(rs.getInt("age"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}