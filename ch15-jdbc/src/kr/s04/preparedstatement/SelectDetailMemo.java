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
					
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num); // 상세 페이지를 조회하기 위해서는 테이블에 PRIMARY KEY가 지정되어 있어야 함
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 한 개의 레코드를 얻어 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 입력한 PRIMARY KEY 값을 가진 행이 있는 경우; ResultSet 커서의 초기 위치는 첫 번째 행 전으로, next() 메서드를 1회 실행해야 커서가 첫 번째 행으로 이동하게 됨
				System.out.println("번호 : " + rs.getInt("num")); // getString()도 사용 가능
				System.out.println("제목 : " + rs.getString("title"));
				System.out.println("작성자 : " + rs.getString("name"));
				System.out.println("내용 : " + rs.getString("memo"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("작성일 : " + rs.getDate("reg_date"));
			}
			else { // 입력한 PRIMARY KEY 값을 가진 행이 없는 경우
				System.out.println("검색된 데이터가 없습니다.");
			}
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