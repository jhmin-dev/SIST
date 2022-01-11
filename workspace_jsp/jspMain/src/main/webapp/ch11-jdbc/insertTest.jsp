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
<title>상품 등록 처리</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String origin = request.getParameter("origin");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;

	try {
		Class.forName(driverName);

		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

		sql = "INSERT INTO product (num, name, price, stock, origin, reg_date) "
			+ "VALUES (product_seq.NEXTVAL, ?, ?, ?, ?, SYSDATE)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, price);
		pstmt.setInt(3, stock);
		pstmt.setString(4, origin);
		
		pstmt.executeUpdate();
%>
<div class="result-display">
	<div class="align-center">
		상품 등록에 성공하였습니다!<br>
		<input type="button" value="추가 등록" onclick="location.href = 'insertTestForm.jsp';">
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
		상품 등록에 실패하였습니다!<br>
		3초 후 이전 페이지로 이동합니다.
	</div>
</div>
<script type="text/javascript"> /* <div> 태그는 onload 이벤트를 지원하지 않음 */
	setTimeout(function() {history.back();}, 3000)
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