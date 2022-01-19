<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 삭제</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>상품 정보 삭제</h1>
	<form action="delete.jsp" method="post">
		<input type="hidden" name="num" value="<%= request.getParameter("num") %>">
		<div class="align-center">
			정말 삭제하시겠습니까?<br>
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href = 'list.jsp'">
		</div>
	</form>
</div>
</body>
</html>