package kr.s04.preparedstatement;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UpdateMemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("메모를 수정합니다.");
			System.out.print("메모 번호 > ");
			int num = Integer.parseInt(br.readLine());
			System.out.print("제목 > ");
			String title = br.readLine();
			System.out.print("작성자 > ");
			String name = br.readLine();
			System.out.print("내용 > ");
			String memo = br.readLine();
			System.out.print("이메일 > ");
			String email = br.readLine();
			
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			// 빈 행을 입력받은 경우, 기존 정보를 유지할 수 있게끔 SELECT문 실행
			if(title.equals("")|name.equals("")|memo.equals("")|email.equals("")) {
				sql = "SELECT * FROM test2 WHERE num=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, num);
				rs = pstmt2.executeQuery();
				if(rs.next()) {
					if (title.equals("")) title = rs.getString("title");
					if (name.equals("")) name = rs.getString("name");
					if (memo.equals("")) memo = rs.getString("memo");
					if (email.equals("")) email = rs.getString("email");
				}
				DBUtil.executeClose(rs, pstmt2, null); // 자원 정리를 하기 위해서는 SQL문장마다 별도의 PreparedStatement 객체를 생성해야 함
			}
			
			// SQL문 작성
			sql = "UPDATE test2 SET title=?, name=?, memo=?, email=? WHERE num=?";
			
			// JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			pstmt.setInt(5, num);
			
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행 변경
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 수정했습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
			if(br!=null) try {br.close();} catch(Exception e) {}
		}
	}
}