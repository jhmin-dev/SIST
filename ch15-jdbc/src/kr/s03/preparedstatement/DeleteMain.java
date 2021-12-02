package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			// JDBC 수행 2단계 : Connection 객체 생성
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "DELETE FROM test1 WHERE id=?";
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, "star");
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행을 삭제
			int count = pstmt.executeUpdate(); // 삭제 작업 후 삭제한 행의 수를 반환
			System.out.println(count + "개 행을 삭제하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}