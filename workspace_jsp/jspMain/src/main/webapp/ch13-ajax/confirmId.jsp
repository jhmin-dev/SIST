<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %> <%-- include된 파일과 contentType이 불일치하면 에러 --%>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	// 전송된 데이터 반환
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	try {
		// JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		// JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		// SQL문 작성
		sql = "SELECT id FROM people WHERE id=?";
		
		// JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		// ?에 데이터를 바인딩
		pstmt.setString(1, id);

		// JDBC 수행 4단계 : SQL문을 실행해서 결과 행을 Resultset에 담아 반환
		rs = pstmt.executeQuery();
		
		if(rs.next()) { // ID 중복
%>
{"result":"idDuplicated"} <%-- JSON 데이터 --%>
<%
		}
		else { // ID 중복되지 않음
%>
{"result":"idNotFound"} <%-- JSON 데이터 --%>
<%
		}
	}
	catch(Exception e) {
		e.printStackTrace();
%>
{"result":"failure"} <%-- JSON 데이터 --%>
<%
	}
	finally {
		// 자원 정리
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>