package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1단계 : 드라이버 로드
			// JDBC 수행 2단계 : Connection 객체 생성
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "UPDATE test1 SET age=? WHERE id=?"; // 데이터를 넣을 자리에 바인드 변수 ?를 명시
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setInt(1, 19); // 첫 번째 ?에 데이터를 전달; 자료형은 데이터를 저장할 컬럼(=age)의 자료형을 따름
			pstmt.setString(2, "star"); // 두 번째 ?에 데이터를 전달; 자료형은 데이터를 저장할 컬럼(=id)의 자료형을 따름
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행을 갱신
			int count = pstmt.executeUpdate(); // 갱신 작업 후 갱신한 행의 수를 반환
			System.out.println(count + "개 행의 정보를 갱신했습니다.");			
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