<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h2 class="align-center">상품 목록</h2>
	<div class="align-right">
		<input type="button" value="상품 등록" onclick="location.href = 'insertTestForm.jsp';">
	</div>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "SELECT * FROM product ORDER BY num DESC";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>
	<table>
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>가격 <small>(원)</small></th>
			<th>재고 <small>(개)</small></th>
			<th>원산지</th>
			<th>등록일</th>
		</tr>
<%
	while(rs.next()) {
%>
		<tr>
			<td><%= rs.getInt("num") %></td>
			<td><a href="detailTest.jsp?num=<%= rs.getInt("num") %>"><%= rs.getString("name") %></a></td>
			<td><%= String.format("%,d", rs.getInt("price")) %></td>
			<td><%= String.format("%,d", rs.getInt("stock")) %></td>
			<td><%= rs.getString("origin") %></td>
			<td><span title="<%= rs.getString("reg_date") %>"><%= rs.getDate("reg_date") %></span></td>
		</tr>
<%		
	}
%>
	</table>
<%
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>
</div>
</body>
</html>