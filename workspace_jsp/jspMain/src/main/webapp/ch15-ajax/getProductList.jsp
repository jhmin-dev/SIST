<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %>
<?xml version="1.0" encoding="UTF-8"?>
<product>
<%
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
		sql = "SELECT * FROM product ORDER BY num DESC";
		
		// JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		
		// JDBC 수행 4단계 : SQL문을 실행하고 결과 행들을 ResultSet에 담아 반환
		rs = pstmt.executeQuery();
		while(rs.next()) {
%>
	<item>
		<num><%= rs.getInt("num") %></num>
		<name><%= rs.getString("name") %></name>
		<price><%= rs.getInt("price") %></price>
		<stock><%= rs.getInt("stock") %></stock>
		<origin><%= rs.getString("origin") %></origin>
		<reg_date><%= rs.getDate("reg_date") %></reg_date>
	</item>
<%
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		// 자원 정리
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>
</product>