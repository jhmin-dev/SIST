package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectDetailMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("메모 상세 페이지를 조회합니다.");
			System.out.print("메모 번호 > ");
			int num = Integer.parseInt(br.readLine());
			
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "SELECT * FROM test2 WHERE num=?";
					
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); // 상세 페이지를 조회하기 위해서는 테이블에 PRIMARY KEY가 지정되어 있어야 함
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 한 개의 레코드를 얻어 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			rs.next();
			System.out.println(rs.getString("memo"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			if(br!=null) try {br.close();} catch(Exception e) {}
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}