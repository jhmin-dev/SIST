<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
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
	<h2 class="align-center">상품 정보 수정</h2>
	<form id="myForm" action="updateTest.jsp" method="post">
		<input type="hidden" name="num" value="<%= num %>">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" value="<%= rs.getString("name") %>">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" value="<%= rs.getInt("price") %>" min="1" placeholder="1 ~ 999,999,999">
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" id="stock" value="<%= rs.getInt("stock") %>" min="0" placeholder="0 ~ 999,999,999">
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin" id="origin" value="<%= rs.getString("origin") %>">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href = 'selectTest.jsp';">
		</div>
	</form>
</div>
<script type="text/javascript" src="validateLength.js"></script>
<%
		}
		else {
%>
<div class="result-display">
	<div class="align-center">
		수정하려는 상품이 존재하지 않습니다!<br>
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
		상품 수정에 실패했습니다!<br>
		3초 후 이전 페이지로 이동합니다.
	</div>
</div>
<script type="text/javascript">
	setTimeout(function() {history.go(-1);}, 3000);
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