<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="/ch13-ajax/dbinfo.jspf" %>
<%-- 배열 안에 스크립트릿 사용 --%>
[<% 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql= null;

	try {
		// JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		// JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

		// SQL문 작성
		sql = "SELECT * FROM people ORDER BY id DESC";
		
		// JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		
		// JDBC 수행 4단계
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id"); 
			String name = rs.getString("name"); 
			String job = rs.getString("job"); 
			String address = rs.getString("address"); 
			String blood_type = rs.getString("blood_type");
			
			if(rs.getRow()>1) { // 첫 번째 행을 제외하고
				out.print(","); // 쉼표 삽입
			}
%>
			{
				"id":"<%= id %>",
				"name":"<%= name %>",
				"job":"<%= job %>",
				"address":"<%= address %>",
				"blood_type":"<%= blood_type %>"
			}
<%			
		} // end of while
	} // end of try
	catch(Exception e) { // 예외 발생시 형식에 맞지 않는 데이터(에러 페이지)가 전송되도록 별도의 JSON 데이터를 만들지 않음
		e.printStackTrace();
	}
	finally {
		// 자원 정리
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>]