package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			// JDBC 수행 2단계 : Connection 객체 생성
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			// sql = "INSERT INTO test1 VALUES ('star', 50)"; // (Statement 객체 사용시와 마찬가지로) SQL문에 데이터를 직접 입력하는 방식도 가능하지만, 직접 입력 방식은 사용자로부터 데이터를 입력받는 경우 해킹 위험이 있으므로 권장하지 않음
			sql = "INSERT INTO test1 VALUES (?, ?)"; // 데이터를 넣을 자리에 바인드 변수 ?를 명시
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, "st'ar"); // 첫 번째 ?에 데이터를 전달; 자료형은 데이터를 저장할 컬럼(=첫 번째 컬럼=id)의 자료형을 따름
			pstmt.setInt(2, 50); // 두 번째 ?에 데이터를 전달; 자료형은 데이터를 저장할 컬럼(=두 번째 컬럼=age)의 자료형을 따름
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 삽입
			int count = pstmt.executeUpdate(); // 삽입 작업 후 삽입한 행의 수를 반환
			System.out.println(count + "개 행을 삽입했습니다.");
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