package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String title, name, memo, email; // try 블럭에서만 사용하는 변수이므로 try 블럭 안에서 선언해도 무방
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("메모를 입력합니다.");
			System.out.print("제목 > ");
			title = br.readLine();
			System.out.print("이름 > ");
			name = br.readLine();
			System.out.print("메모 > ");
			memo = br.readLine();
			System.out.print("이메일 > ");
			email = br.readLine();
			
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "INSERT INTO test2 (num, title, name, memo, email, reg_date) " // 긴 문자열은 가독성을 위해 분리 후 + 연산자로 연결
				+ "VALUES(test2_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)"; // 시퀀스의 다음 값 반환과 현재 날짜 반환은 명령어로 처리되어야 하므로 바인드 변수 사용 불가
			
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 삽입
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 삽입하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
			if(br!=null) try {br.close();} catch(Exception e) {} // 콘솔로부터 입력받는 경우에는 생략 가능
		}
	}
}