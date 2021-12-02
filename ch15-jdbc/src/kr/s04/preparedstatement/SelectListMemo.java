package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectListMemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM test2 ORDER BY num DESC"; // 최신글이 상단에 오게끔 정렬; reg_date도 이용 가능하지만, 일반적으로 목록에서는 PRIMARY KEY를 이용하여 정렬
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과 집합을 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t제목\t작성자\t작성일"); // 내용 및 이메일은 상세 페이지에서만 조회하고, 목록에서는 생략
			while(rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getDate("reg_date")); // 컬럼의 자료형이 DATE인 경우, getDate() 메서드와 getString() 메서드 모두 사용 가능
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