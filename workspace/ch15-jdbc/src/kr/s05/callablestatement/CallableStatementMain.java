package kr.s05.callablestatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;

public class CallableStatementMain {
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			// 프로시저 호출 문장 작성
			sql = "{call adjust(?, ?)}"; // 인자에 직접 값을 입력하지 않고 바인드 변수 ? 사용
			
			// JDBC 수행 3단계 : CallableStatement 객체 생성
			cstmt = conn.prepareCall(sql);
			// ?에 데이터를 바인딩
			cstmt.setString(1, "CALL");
			cstmt.setFloat(2, 0.06f);
			
			// JDBC 수행 단계 : 프로시저 실행
			cstmt.executeUpdate();
			System.out.println("급여 정보가 수정되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(cstmt, conn);
		}
	}
}