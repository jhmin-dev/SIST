package kr.s07.note;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * DAO(Data Access Object): 데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
 */
public class NoteDAO {
	// 글 쓰기
	public void insertInfo(String name, String passwd, String subject, String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "INSERT INTO note VALUES (note_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
			// JDBC 수행 3단계 : PreparedStatment 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			if(count==1) System.out.println("글 작성이 완료되었습니다.");
			else System.out.println("글 작성에 실패하였습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 목록 보기
	public void selectListInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM note ORDER BY num DESC";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과 집합을 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			System.out.println("글 번호\t제목\t\t이름\t작성일");
			String subject, name;
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				subject = rs.getString("subject");
				if(subject.length()>6+6) { // 제목이 길면 말줄임표 처리; 길이 상한이 60byte(=국문 20자)이므로, 정렬용으로 \t 2개 사용
					System.out.print(subject.substring(0,4+6)+"..\t");
				}
				else if(subject.length()>7) {
					System.out.print(subject+"\t");
				}
				else {
					System.out.print(subject+"\t\t");
				}
				name = rs.getString("name");
				if(name.length()>6) { // 이름이 길면 말줄임표 처리
					System.out.print(name.substring(0,4)+"..\t");
				}
				else {
					System.out.print(name+"\t");
				}
				System.out.println(rs.getDate("reg_date")); // 목록 보기에서는 연, 월, 일만 표시
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
	
	// 상세 글 보기
	public int selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = null;
		int exitcode = 0; // if~else 도달 전에 예외 발생할 수 있으므로 기본값 지정
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM note WHERE num=?";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 한 개의 레코드를 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("글 번호 : " + rs.getInt("num"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("비밀번호 : " + rs.getString("passwd"));
				System.out.println("제목 : " + rs.getString("subject"));
				System.out.println("내용 : " + rs.getString("content"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("작성일 : " + rs.getString("reg_date")); // 상세 글 보기에서는 연, 월, 일, 시, 분, 초까지 표시
				exitcode = 1; // 있는 글 번호를 입력하여 정상적으로 상세 글 보기 작업을 완료한 경우
			}
			else {
				System.out.println(num + "번 글이 존재하지 않습니다!");
				exitcode = -1; // 없는 글 번호를 입력하여 상세 글 보기 작업에 실패한 경우
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return exitcode;
	}
	
	// 글 수정
	public void updateInfo(int num, String name, String passwd, String subject, String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// 빈 문자열을 입력받은 경우 기존 정보를 유지하기
			if((name+passwd+subject+content+email).equals("")) {
				System.out.println("수정할 내용이 없습니다!");
				return;
			}
			if(name.equals("")|passwd.equals("")|subject.equals("")|content.equals("")|email.equals("")) {
				sql = "SELECT * FROM note WHERE num=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, num);
				ResultSet rs = pstmt2.executeQuery();
				if(rs.next()) {
					if (name.equals("")) name = rs.getString("name");
					if (passwd.equals("")) passwd = rs.getString("passwd");
					if (subject.equals("")) subject = rs.getString("subject");
					if (content.equals("")) content = rs.getString("content");
					if (email.equals("")) email = rs.getString("email");
				}
				DBUtil.executeClose(rs, pstmt2, null);
			}
			// SQL문 작성
			sql = "UPDATE note SET name=?, passwd=?, subject=?, content=?, email=? WHERE num=?";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			pstmt.setInt(6, num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행 정보 갱신
			int count = pstmt.executeUpdate();
			if(count==1) System.out.println(num + "번 글을 수정하였습니다.");
			else System.out.println(num + "번 글을 수정하지 못했습니다!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 글 삭제
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "DELETE FROM note WHERE num=?";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행을 삭제
			int count = pstmt.executeUpdate();
			if(count==1) System.out.println(num + "번 글을 삭제하였습니다.");
			else System.out.println(num + "번 글을 삭제하지 못했습니다!");
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