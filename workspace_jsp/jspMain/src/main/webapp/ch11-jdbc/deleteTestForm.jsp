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
<title>상품 삭제</title>
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
		sql = "SELECT name FROM product WHERE num=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
%>
<div class="page-main align-center">
	<h2>상품 삭제</h2>
	상품 번호 <%= num %>, <b><%= rs.getString("name") %></b> 정말 삭제하시겠습니까?<br>
	<form action="deleteTest.jsp" method="post">
		<input type="hidden" name="num" value="<%= num %>">
		<input type="submit" value="삭제">
		<input type="button" value="목록" onclick="location.href = 'selectTest.jsp';">
	</form>
</div>
<script type="text/javascript">
	let word = document.querySelector('b');
	let last = word.textContent.charCodeAt(word.textContent.length-1); // 마지막 글자의 유니코드 값
	let post;
	if(last<44032 || last>55203) { // 마지막 글자가 한글이 아닌 경우
		post = '을/를';
	}
	else {
		post = ((last - 44032) % 28) > 0 ? '을' : '를';
	}
	word.parentNode.insertBefore(document.createTextNode(post), word.nextSibling);
</script>
<%
		}
		else {
%>
<div class="result-display">
	<div class="align-center">
		삭제하려는 상품이 존재하지 않습니다!<br>
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
		상품 삭제에 실패했습니다!<br>
		3초 후 목록 페이지로 이동합니다.
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