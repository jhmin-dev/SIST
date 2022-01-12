<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정 처리</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "UPDATE product SET name=?, price=?, stock=?, origin=?, reg_date=SYSDATE WHERE num=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, request.getParameter("name"));
		pstmt.setInt(2, Integer.parseInt(request.getParameter("price")));
		pstmt.setInt(3, Integer.parseInt(request.getParameter("stock")));
		pstmt.setString(4, request.getParameter("origin"));
		pstmt.setInt(5, Integer.parseInt(request.getParameter("num")));
		pstmt.executeUpdate();
%>
<div class="result-display">
	<div class="align-center">
		상품 정보 수정에 성공했습니다!<br>
		<input type="button" value="상품 목록" onclick="location.href = 'selectTest.jsp';">
	</div>
</div>
<%
	}
	catch(Exception e) {
		e.printStackTrace();
%>
<div class="result-display">
	<div class="align-center">
		상품 정보 수정에 실패했습니다!<br>
		3초 후 상품 정보 수정 페이지로 이동합니다.
	</div>
</div>
<script type="text/javascript">
	setTimeout(function() {location.href = 'updateTestForm.jsp?num=<%= request.getParameter("num") %>';}, 3000);
</script>
<%
	}
	finally {
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>
</body>
</html>