package kr.s08.score;

import kr.s03.preparedstatement.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScoreDAO {
	// 성적 입력
	public void insertInfo(ScoreVO score) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();	
			// SQL문 작성
			sql = "INSERT INTO score (num, name, korean, english, math, sum, avg, grade, reg_date) "
				+ "VALUES (score_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, score.getName());
			pstmt.setInt(2, score.getKorean());
			pstmt.setInt(3, score.getEnglish());
			pstmt.setInt(4, score.getMath());
			pstmt.setInt(5, score.makeSum());
			pstmt.setInt(6, score.makeAvg());
			pstmt.setString(7, score.makeGrade());
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 삽입
			int count = pstmt.executeUpdate();
			if(count==1) System.out.println("성적 입력을 완료하였습니다.");
			else System.out.println("성적 입력에 실패하였습니다.");
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
			sql = "SELECT * FROM score ORDER BY num DESC";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블에서 결과 집합을 얻어 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			System.out.println("총 자료 수 : " + getCountInfo());
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
			while(rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("korean") + "\t");
				System.out.print(rs.getInt("english") + "\t");
				System.out.print(rs.getInt("math") + "\t");
				System.out.print(rs.getInt("sum") + "\t");
				System.out.print(rs.getInt("avg") + "\t");
				System.out.println(rs.getString("grade"));
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
	
	// 레코드 총 수
	public int getCountInfo() {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT COUNT(num) FROM score";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 총 레코드 수를 구해서 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			} // rs에 행이 없는 경우 count는 기본값이 반환됨
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	// 상세 정보 보기
	public int selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int exitcode = 0;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM score WHERE num=?";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 결과 행을 얻고 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.printf("국어 : %3d\t영어 : %3d\t수학 : %3d%n", rs.getInt("korean"), rs.getInt("english"), rs.getInt("math"));
				System.out.printf("총점 : %3d\t평균 : %3d\t등급 : %3s%n", rs.getInt("sum"), rs.getInt("avg"), rs.getString("grade"));
				System.out.println("입력일 : " + rs.getString("reg_date"));
				exitcode = 1;
			}
			else {
				System.out.println(num + "번에 해당하는 자료가 없습니다.");
				exitcode = -1;
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
	
	// 수정
	public void updateInfo(ScoreVO score) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "UPDATE score SET name=?, korean=?, english=?, math=?, sum=?, avg=?, grade=? WHERE num=?";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setString(1, score.getName());
			pstmt.setInt(2, score.getKorean());
			pstmt.setInt(3, score.getEnglish());
			pstmt.setInt(4, score.getMath());
			pstmt.setInt(5, score.makeSum());
			pstmt.setInt(6, score.makeAvg());
			pstmt.setString(7, score.makeGrade());
			pstmt.setInt(8, score.getNum());
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행 정보를 갱신
			int count = pstmt.executeUpdate();
			if(count==1) System.out.println(score.getNum() + "번에 해당하는 자료를 수정하였습니다.");
			else System.out.println(score.getNum() + "번에 해당하는 자료를 수정하지 못했습니다!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 삭제
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "DELETE FROM score WHERE num=?";
			// JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 바인딩
			pstmt.setInt(1, num);
			// JDBC 수행 4단계 : SQL문을 실행해서 테이블의 행을 삭제
			int count = pstmt.executeUpdate();
			if(count==1) System.out.println(num + "번에 해당하는 자료를 삭제하였습니다.");
			else System.out.println(num + "번에 해당하는 자료를 삭제하지 못했습니다!");
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