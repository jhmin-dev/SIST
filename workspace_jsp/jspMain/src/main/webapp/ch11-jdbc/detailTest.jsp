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
<title>상품 상세 정보</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<% 
	int num = Integer.parseInt(request.getParameter("num"));

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "SELECT * FROM product WHERE num=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
%>
<div class="page-main">
	<h2 class="align-center">상품 상세 정보</h2>
	<hr style="border-style: solid; color: gray;"> <!-- <hr> 태그의 align, noshade, size, width 속성은 HTML5에서는 더 이상 지원되지 않으며, CSS로 제어됨 -->
	<ul>
		<li>상품 번호 : <%= num %></li>
		<li>상품명 : <%= rs.getString("name") %></li>
		<li>가격 : <%= String.format("%,d원", rs.getInt("price")) %></li>
		<li>재고 : <%= String.format("%,d개", rs.getInt("stock")) %></li>
		<li>원산지 : <%= rs.getString("origin") %></li>
		<li>등록일 : <span title="<%= rs.getString("reg_date") %>"><%= rs.getDate("reg_date") %></span></li>
	</ul>
	<hr style="border-style: solid; color: gray;">
	<div class="align-right">
		<input type="button" value="수정" onclick="location.href = 'updateTestForm.jsp?num=<%= num %>';">
		<input type="button" value="삭제" onclick="location.href = 'deleteTestForm.jsp?num=<%= num %>';">
		<input type="button" value="목록" onclick="location.href = 'selectTest.jsp';">
	</div>
</div>
<%
		}
		else {
%>
<div class="result-display">
	<div class="align-center">
		조회하려는 상품이 존재하지 않습니다!<br>
		<input type="button" value="이전 페이지" onclick="history.go(-1);">
		<input type="button" value="상품 목록" onclick="location.href = 'selectTest.jsp';">
	</div>
</div>
<%
		}
	}
	catch(Exception e) {
		e.printStackTrace();
%>
<div class="result-display">
	<div class="align-center">
		상품 상세 정보 조회에 실패했습니다!<br>
		3초 후 상품 목록 페이지로 이동합니다.
	</div>
</div>
<script type="text/javascript">
	setTimeout(function() {location.href = 'selectTest.jsp';}, 3000);
</script>
<%
	}
	finally {
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>
</body>
</html>